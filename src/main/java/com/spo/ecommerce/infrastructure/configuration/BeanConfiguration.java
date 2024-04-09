package com.spo.ecommerce.infrastructure.configuration;

import com.spo.ecommerce.application.repository.ProductRepository;
import com.spo.ecommerce.application.repository.StockRepository;
import com.spo.ecommerce.application.service.ProductService;
import com.spo.ecommerce.application.service.StockService;
import com.spo.ecommerce.application.service.UploadFile;
import com.spo.ecommerce.application.service.ValidateStock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository, UploadFile uploadFile) {
        return new ProductService(productRepository, uploadFile);
    }
    @Bean
    public UploadFile uploadFile() {
        return new UploadFile();
    }

    @Bean
    public StockService stockService(StockRepository stockRepository) {
        return new StockService(stockRepository);
    }

    @Bean
    public ValidateStock validateStock(StockService stockService) {
        return new ValidateStock(stockService);
    }
}
