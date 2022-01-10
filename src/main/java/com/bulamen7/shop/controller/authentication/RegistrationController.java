package com.bulamen7.shop.controller.authentication;

import com.bulamen7.shop.controller.user.RegistrationFormValidator;
import com.bulamen7.shop.model.user.RegistrationForm;
import com.bulamen7.shop.service.user.UserService;
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
@RequestMapping("/register")
public class RegistrationController {
    private final UserService userService;
    private final RegistrationFormValidator validator;

    public RegistrationController(UserService userService, RegistrationFormValidator validator) {
        this.userService = userService;
        this.validator = validator;
    }

    @InitBinder(value = "registerForm")
    public void init(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @GetMapping
    ModelAndView registrationPage() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("registerForm", new RegistrationForm());
        return modelAndView;
    }

    @PostMapping("/add")
    ModelAndView registerUser(@ModelAttribute("registerForm") @Validated RegistrationForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }
        userService.saveUser(registerForm);
        return new ModelAndView("redirect:/login");
    }
}
