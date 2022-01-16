package com.bulamen7.shop.controller.authentication;

import com.bulamen7.shop.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/test")
public class TestController {
    private final UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    ModelAndView changePasswordPage() {
        ModelAndView modelAndView = new ModelAndView("changePw");
        return modelAndView;
    }

//    @PostMapping("/sent")
//    String changePassword(@ModelAttribute("newPassword") NewPasswordForm passwordForm, Authentication authentication) {
//        userService.changePassword(passwordForm, authentication.getName());
//        return "redirect:/logout";
//    }
}
