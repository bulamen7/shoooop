package com.bulamen7.shop.controller.authentication;

import com.bulamen7.shop.model.user.RegistrationForm;
import com.bulamen7.shop.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    ModelAndView registrationPage() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("registerForm", new RegistrationForm());
        return modelAndView;
    }

    @PostMapping("/add")
    String registerUser(@ModelAttribute("registerForm") RegistrationForm registerForm) {
        userService.saveUser(registerForm);
        return "redirect:/login";
    }
}
