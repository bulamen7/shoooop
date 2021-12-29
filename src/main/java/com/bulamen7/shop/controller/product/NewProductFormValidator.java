package com.bulamen7.shop.controller.product;

import com.bulamen7.shop.model.product.NewProductForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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
    }
}
