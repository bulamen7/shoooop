package com.bulamen7.shop.component;

import com.bulamen7.shop.model.product.ProductDto;
import com.bulamen7.shop.service.order.OrderService;
import com.bulamen7.shop.service.product.ProductService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private List<ProductDto> products = new ArrayList<>();
    private final OrderService orderService;
    private final ProductService productService;

    public Cart(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    public void addProduct(Long id) {
        ProductDto byId = productService.findById(id);
        products.add(byId);
    }

    public void removeProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public List<ProductDto> findAllProducts() {
        return products;
    }

    public void submitCart() {
        List<Long> productId = products.stream().map(ProductDto::getId).collect(Collectors.toList());
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        orderService.createOrder(productId, userDetails.getUsername());
        products.clear();
    }
}

