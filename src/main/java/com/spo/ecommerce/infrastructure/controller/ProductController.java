package com.spo.ecommerce.infrastructure.controller;

import com.spo.ecommerce.application.service.ProductService;
import com.spo.ecommerce.domain.Product;
import com.spo.ecommerce.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create")
    public String create() {
        return "admin/products/create";
    }

    @PostMapping("/save-product")
    public String saveProduct(Product product) {
        log.info("Nombre de producto: {}", product);
        productService.saveProduct(product);
        //return "admin/products/create";
        return "redirect:/admin";
    }

    @GetMapping("/show")
    public String showProduct(Model model) {
        User user = new User();
        user.setId(1);

        Iterable<Product> products = productService.getProductsByUser(user);
        model.addAttribute("products", products);
        return "admin/products/show";
    }
}
