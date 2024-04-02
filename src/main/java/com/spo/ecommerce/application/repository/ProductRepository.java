package com.spo.ecommerce.application.repository;

import com.spo.ecommerce.domain.Product;
import com.spo.ecommerce.domain.User;

public interface ProductRepository {
    Iterable<Product> getProducts();
    Iterable<Product> getProductsByUser(User user);
    Product getProductById(Integer id);
    Product saveProduct(Product product);
    void deleteProductById(Integer id);

}
