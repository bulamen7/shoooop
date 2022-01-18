package com.bulamen7.shop.controller.authentication;

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
class LoginControllerIT {
    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldGetLoginPageView() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status()
                        .is(200))
                .andExpect(view()
                        .name("login"))
                .andExpect(model()
                        .attributeExists("form"));
    }
}