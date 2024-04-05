package com.spo.ecommerce.application.service;

import com.spo.ecommerce.application.repository.ProductRepository;
import com.spo.ecommerce.domain.Product;
import com.spo.ecommerce.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

public class ProductService {

    private final ProductRepository productRepository;

    private final UploadFile uploadFile;

    public ProductService(ProductRepository productRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
    }

    public Iterable<Product> getProducts() {
        return productRepository.getProducts();
    }

    public Iterable<Product> getProductsByUser(User user) {
        return productRepository.getProductsByUser(user);
    }

    public Product getProductById(Integer id) {
        return productRepository.getProductById(id);
    }

    public Product saveProduct(Product product, MultipartFile multipartFile) throws IOException {
        if(product.getId() == null) {
            User user = new User();
            user.setId(1);
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setUser(user);
            product.setImage(uploadFile.upload(multipartFile));
            return productRepository.saveProduct(product);
        } else {
            Product productUpdated = productRepository.getProductById(product.getId());
            if(multipartFile.isEmpty()) {
                productUpdated.setImage(productUpdated.getImage());
            } else {
                if(!productUpdated.getImage().equals("default.jpg")) {
                    uploadFile.deleteImage(productUpdated.getImage());
                }
                product.setImage(uploadFile.upload(multipartFile));
            }
            product.setCode(productUpdated.getCode());
            product.setUser(productUpdated.getUser());
            product.setDateCreated(productUpdated.getDateCreated());
            product.setDateUpdated(LocalDateTime.now());

            return productRepository.saveProduct(product);
        }
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteProductById(id);
    }
}
