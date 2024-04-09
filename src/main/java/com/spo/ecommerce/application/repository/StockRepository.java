package com.spo.ecommerce.application.repository;

import com.spo.ecommerce.domain.Product;
import com.spo.ecommerce.domain.Stock;

import java.util.List;

public interface StockRepository {

    Stock saveStock(Stock stock);
    List<Stock> getStockByProduct(Product product);
}
