package com.bulamen7.shop.service.order.exception;

public class OrderNotFoundException extends RuntimeException {
    private static final String EXCEPTION_MESSAGE = "There is no order with id: %s ";

    public OrderNotFoundException(long id) {
        super(String.format(EXCEPTION_MESSAGE, id));
    }
}
