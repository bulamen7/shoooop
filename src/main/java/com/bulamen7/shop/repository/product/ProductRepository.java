package com.bulamen7.shop.repository.product;

import com.bulamen7.shop.model.product.EntityProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<EntityProduct,Long> {
}
