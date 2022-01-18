package com.bulamen7.shop.controller.product;

import com.bulamen7.shop.component.Cart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class CartControllerIT {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    Cart cart;

    @Test
    void shouldGetCartPageView() throws Exception {
        mockMvc.perform(get("/cart"))
                .andExpect(status()
                        .is(200))
                .andExpect(view()
                        .name("cart/index"))
                .andExpect(model()
                        .attributeExists("products"));
    }

    @Test
    void shouldAddProductToUserCart() throws Exception {
        mockMvc.perform(get("/cart/addProduct/1"))
                .andExpect(status()
                        .is(302))
                .andExpect(view()
                        .name("redirect:/cart"));
        verify(cart).addProduct(1L);

    }
}