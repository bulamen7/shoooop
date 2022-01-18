package com.bulamen7.shop.service.product.exception;

public class ProductNotFoundException extends RuntimeException {
    private static final String EXCEPTION_MESSAGE = "There is no product with id: %s ";

    public ProductNotFoundException(long id) {
        super(String.format(EXCEPTION_MESSAGE, id));
    }
}
