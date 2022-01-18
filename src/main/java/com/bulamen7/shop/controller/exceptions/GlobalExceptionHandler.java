package com.bulamen7.shop.controller.exceptions;

import com.bulamen7.shop.service.order.exception.OrderNotFoundException;
import com.bulamen7.shop.service.product.exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OrderNotFoundException.class)
    ModelAndView orderException(OrderNotFoundException exception) {
        return getModelAndView(exception.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    ModelAndView productException(ProductNotFoundException exception) {
        return getModelAndView(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    ModelAndView methodArgumentException(MethodArgumentTypeMismatchException exception) {
        return getModelAndView(exception.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    ModelAndView illegalArgumentException(IllegalStateException exception) {
        return getModelAndView(exception.getMessage());
    }

    private ModelAndView getModelAndView(String exception) {
        ModelAndView modelAndView = new ModelAndView("error/errorPage");
        modelAndView.addObject("message", exception);
        return modelAndView;
    }
}
