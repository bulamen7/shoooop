package com.bulamen7.shop.controller.authentication;

import com.bulamen7.shop.model.authentication.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping()
    ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("form", new LoginForm());
        return modelAndView;
    }
}
