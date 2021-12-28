package com.bulamen7.shop.controller.product;

import com.bulamen7.shop.model.product.NewProductForm;
import com.bulamen7.shop.model.product.ProductDto;
import com.bulamen7.shop.model.product.UpdateProductForm;
import com.bulamen7.shop.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
class ProductController {
    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/index");
        modelAndView.addObject("newProduct", new NewProductForm());
        List<ProductDto> products = productService.findAll();
        modelAndView.addObject("productsList", products);
        return modelAndView;
    }

    @GetMapping("/{id}")
    ModelAndView findProduct(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();

        ProductDto product = productService.findById(id);
        modelAndView.setViewName("product/product");
        modelAndView.addObject("product", product);
        modelAndView.addObject("updateForm", new UpdateProductForm());
        return modelAndView;
    }

    @PostMapping
    String addProduct(NewProductForm product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }

    @PostMapping("/{id}/patch")
    String patchProduct(@PathVariable Long id, UpdateProductForm updateProductForm) {
        System.out.println("jestem tu: " + updateProductForm);
        productService.patchUpdate(id, updateProductForm);
        return "redirect:/products";
    }

    @PostMapping("/{id}/put")
    String putProduct(@PathVariable Long id, UpdateProductForm updateProductForm) {
        productService.putUpdate(id, updateProductForm);
        return "redirect:/products";
    }
}
