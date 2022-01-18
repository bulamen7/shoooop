package com.bulamen7.shop.controller.authentication;

import com.bulamen7.shop.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
}
//    @Test
//    void shouldChangePassword() throws Exception {
//        mockMvc.perform(post("/changePassword")
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .param("newPassword", "Randompw1")
//                        .param("repeatedNewPassword", "Randompw1"))
//                .andExpect(status()
//                        .is(302))
//                .andExpect(view()
//                        .name("changePassword"));
//        //  verify(userService).changePassword(new NewPasswordForm("Randompw1", "Randompw1"), Authentication.class.getName());

