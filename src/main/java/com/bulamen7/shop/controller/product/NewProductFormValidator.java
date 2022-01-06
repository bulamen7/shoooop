package com.bulamen7.shop.controller.product;

import com.bulamen7.shop.model.product.NewProductForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

@Component
class NewProductFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return NewProductForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewProductForm form = (NewProductForm) target;
        if (form.getName() == null || form.getName().equals("")) {
            errors.rejectValue("name", "validator.field.blank");
        }
        if (form.getDescription() == null || form.getDescription().equals("")) {
            errors.rejectValue("description", "validator.field.blank");
        }
        if (form.getPrice() == null || form.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            errors.rejectValue("price", "newProductFormValidator.field.priceLowerThanZero");
        }
    }
}
