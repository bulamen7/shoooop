package com.bulamen7.shop.controller.cart;

import com.bulamen7.shop.component.Cart;
import com.bulamen7.shop.model.product.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    private final Cart cart;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    @GetMapping
    ModelAndView cartPage() {
        ModelAndView modelAndView = new ModelAndView("cart/index");
        List<ProductDto> products = cart.findAllProducts();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/submit")
    String submitOrder() {
        cart.submitCart();
        return "redirect:/cart";
    }


    //trick: get method changes system state
    @GetMapping("/addProduct/{id}")
    String addProductToCart(@PathVariable Long id) {
        cart.addProduct(id);
        return "redirect:/cart";
    }

}
