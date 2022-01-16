package com.bulamen7.shop.service;

import com.bulamen7.shop.model.order.OrderDto;
import com.bulamen7.shop.model.product.ProductDto;
import com.bulamen7.shop.repository.order.OrderEntity;
import com.bulamen7.shop.repository.product.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ModelMapper {
    public static OrderDto map(OrderEntity entity) {
        List<ProductEntity> products = entity.getProducts();
        List<ProductDto> collect = products.stream().map(ModelMapper::map).collect(Collectors.toList());
        return new OrderDto(entity.getId(), entity.getUser().getId(), collect);
    }

    public static ProductDto map(ProductEntity product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getDescription(), product.getCreateDateTime());
    }

}
