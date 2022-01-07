package com.bulamen7.shop.controller.authentication;

import com.bulamen7.shop.model.user.RegistrationForm;
import com.bulamen7.shop.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class RegistrationControllerIT {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService;

    @Test
    void shouldGetRegistrationPage() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status()
                        .is(200))
                .andExpect(view()
                        .name("register"))
                .andExpect(model()
                        .attributeExists("registerForm"));
    }

    @Test
    void shouldPatchProduct() throws Exception {
        mockMvc.perform(post("/register/add")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "Arek")
                        .param("email", "randomMail@wp.pl")
                        .param("login", "log")
                        .param("password", "pass"))
                .andExpect(status()
                        .is(302))
                .andExpect(view()
                        .name("redirect:/login"));
        verify(userService).saveUser(new RegistrationForm("Arek", "randomMail@wp.pl", "log", "pass"));
    }
}