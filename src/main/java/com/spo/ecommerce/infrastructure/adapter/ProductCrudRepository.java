package com.spo.ecommerce.infrastructure.adapter;

import com.spo.ecommerce.domain.Product;
import com.spo.ecommerce.infrastructure.entity.ProductEntity;
import com.spo.ecommerce.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    Iterable<ProductEntity> findByUserEntity(UserEntity userEntity);
}
