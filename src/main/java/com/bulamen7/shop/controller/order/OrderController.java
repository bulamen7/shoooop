package com.bulamen7.shop.controller.order;

import com.bulamen7.shop.service.order.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("order/index");
        modelAndView.addObject("orders", orderService.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}")
    ModelAndView findById(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("order/order");
        modelAndView.addObject("order", orderService.findById(id));
        return modelAndView;
    }
}
