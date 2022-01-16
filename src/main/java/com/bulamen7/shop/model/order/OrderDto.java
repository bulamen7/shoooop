package com.bulamen7.shop.model.order;

import com.bulamen7.shop.model.product.ProductDto;

import java.util.List;

public class OrderDto {
    private final long id;
    private final long userId;
    private final List<ProductDto> products;

    public OrderDto(long id, long userId, List<ProductDto> products) {
        this.id = id;
        this.userId = userId;
        this.products = products;
    }

    public long getUserId() {
        return userId;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "userId=" + userId +
                ", products=" + products +
                '}';
    }
}
