package com.bulamen7.shop.controller.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerIT {
    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldFindAllOrders() throws Exception {
        mockMvc.perform(get("/orders"))
                .andExpect(status()
                        .is(200))
                .andExpect(view()
                        .name("order/index"))
                .andExpect(model()
                        .attributeExists("orders"));
    }

    @Test
    void shouldFindOrderById() throws Exception {
        mockMvc.perform(get("/orders/1"))
                .andExpect(status()
                        .is(200))
                .andExpect(view()
                        .name("order/order"))
                .andExpect(model()
                        .attributeExists("order"));
    }
}
