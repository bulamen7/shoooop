package com.bulamen7.shop.controller.authentication;

import com.bulamen7.shop.model.authentication.NewPasswordForm;
import com.bulamen7.shop.service.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/changePassword")
public class ChangePasswordController {
    private final UserService userService;
    private final NewPasswordFormValidator validator;

    public ChangePasswordController(UserService userService, NewPasswordFormValidator validator) {
        this.userService = userService;
        this.validator = validator;
    }

    @InitBinder(value = "newPasswordForm")
    public void init(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @GetMapping
    ModelAndView changePasswordPage() {
        ModelAndView modelAndView = new ModelAndView("changePassword");
        modelAndView.addObject("newPasswordForm", new NewPasswordForm());
        return modelAndView;
    }

    @PostMapping
    ModelAndView changePassword(@ModelAttribute("newPasswordForm") @Validated NewPasswordForm passwordForm,
                                BindingResult bindingResult, Authentication authentication) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("changePassword");
        }
        userService.changePassword(passwordForm, authentication.getName());
        return new ModelAndView("redirect:/logout");
    }
}
