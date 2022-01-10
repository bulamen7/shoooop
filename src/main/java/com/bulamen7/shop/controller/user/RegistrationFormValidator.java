package com.bulamen7.shop.controller.user;

import com.bulamen7.shop.model.user.RegistrationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RegistrationFormValidator implements Validator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegistrationForm form = (RegistrationForm) target;
        Matcher matcher = EMAIL_PATTERN.matcher(form.getPassword());
        if (!matcher.matches()) {
            errors.rejectValue("password", "validator.field.passwordInvalid");
        }

        if (!equalsPasswords(form.getPassword(), form.getRepeatedPassword())) {
            errors.rejectValue("password", "validator.field.passwordAreNotSame");
            errors.rejectValue("repeatedPassword", "validator.field.passwordAreNotSame");
        }
    }

    private boolean equalsPasswords(String password, String repeatedPassword) {
        return password.equals(repeatedPassword);
    }
}
