package com.spo.ecommerce.infrastructure.adapter;

import com.spo.ecommerce.infrastructure.entity.ProductEntity;
import com.spo.ecommerce.infrastructure.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockCrudRepository extends CrudRepository<StockEntity, Integer> {

    List<StockEntity> findByProductEntity(ProductEntity productEntity);
}
