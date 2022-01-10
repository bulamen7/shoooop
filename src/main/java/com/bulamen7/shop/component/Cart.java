package com.bulamen7.shop.component;

import com.bulamen7.shop.model.product.ProductDto;
import com.bulamen7.shop.service.product.ProductService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private List<ProductDto> products = new ArrayList<>();

    private final ProductService productService;

    public Cart(ProductService productService) {
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

    void submitCart() {
        //TODO
    }
}

