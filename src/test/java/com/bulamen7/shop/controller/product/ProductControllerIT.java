package com.bulamen7.shop.controller.product;

import com.bulamen7.shop.model.product.NewProductForm;
import com.bulamen7.shop.model.product.UpdateProductForm;
import com.bulamen7.shop.service.product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerIT {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @Test
    void shouldReturnIndexPage() throws Exception {
        //given

        //when
        mockMvc.perform(get("/products"))
                .andExpect(status()
                        .is(200))
                .andExpect(view()
                        .name("product/index"))
                .andExpect(model()
                        .attributeExists("productsList"));
        //then
    }

    @Test
    void shouldAddProduct() throws Exception {
        //when
        ResultActions result = mockMvc.perform(post("/products/add")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "test")
                .param("price", "15")
                .param("description", "cos tam"));

        //then
        result.andExpect(status()
                        .is(302))
                .andExpect(redirectedUrl("/products"));
        verify(productService).addProduct(eq(new NewProductForm("test", BigDecimal.valueOf(15), "cos tam")));
    }

    @Test
    void shouldGetProductPage() throws Exception {
        mockMvc.perform(get("/products/add"))
                .andExpect(status()
                        .is(200))
                .andExpect(view()
                        .name("product/addProduct"))
                .andExpect(model()
                        .attributeExists("newProduct"));
    }

    @Test
    void shouldDeleteProduct() throws Exception {
        //when
        mockMvc.perform(get("/products/5/delete"));

        //then
        verify(productService).deleteById(5L);
    }

    @Test
    void shouldPatchProduct() throws Exception {
        mockMvc.perform(post("/products/2/patch")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "Arek")
                        .param("price", "10")
                        .param("description", "opis"))
                .andExpect(status()
                        .is(302))
                .andExpect(view()
                        .name("redirect:/products"));
        verify(productService).patchUpdate(2L, new UpdateProductForm("Arek", BigDecimal.valueOf(10), "opis"));

    }

    @Test
    void shouldPutProduct() throws Exception {
        mockMvc.perform(post("/products/2/put")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "Arek")
                        .param("price", "10")
                        .param("description", "opis"))
                .andExpect(status()
                        .is(302))
                .andExpect(view()
                        .name("redirect:/products"));

        verify(productService).putUpdate(2L, new UpdateProductForm("Arek", BigDecimal.valueOf(10), "opis"));
    }

    @Test
    void shouldAddProductView() throws Exception {
        mockMvc.perform(get("/products/add"))
                .andExpect(status()
                        .is(200))
                .andExpect(view()
                        .name("product/addProduct"));
    }
}















