package com.spo.ecommerce.application.service;

import com.spo.ecommerce.application.repository.ProductRepository;
import com.spo.ecommerce.domain.Product;
import com.spo.ecommerce.domain.User;

import java.time.LocalDateTime;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
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

    public Product saveProduct(Product product) {
        User user = new User();
        user.setId(1);
        product.setDateCreated(LocalDateTime.now());
        product.setDateUpdated(LocalDateTime.now());
        product.setUser(user);
        return productRepository.saveProduct(product);
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteProductById(id);
    }
}
