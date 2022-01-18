package com.bulamen7.shop.controller.authentication;

import com.bulamen7.shop.model.authentication.NewPasswordForm;
import com.bulamen7.shop.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class ChangePasswordControllerIT {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService;

    @Test
    void shouldChangePasswordPage() throws Exception {
        mockMvc.perform(get("/changePassword"))
                .andExpect(status()
                        .is(200))
                .andExpect(view()
                        .name("changePassword"))
                .andExpect(model()
                        .attributeExists("newPasswordForm"));
    }

    @Test
    @WithMockUser(username = "user")
    void shouldChangePassword() throws Exception {
        mockMvc.perform(post("/changePassword")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("password", "Randompw1")
                        .param("repeatedPassword", "Randompw1"))
                .andExpect(status()
                        .is(302))
                .andExpect(view()
                        .name("redirect:/logout"));
        verify(userService).changePassword(new NewPasswordForm("Randompw1", "Randompw1"), "user");
    }
}
