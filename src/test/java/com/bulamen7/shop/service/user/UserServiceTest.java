package com.bulamen7.shop.service.user;

import com.bulamen7.shop.model.user.RegistrationForm;
import com.bulamen7.shop.repository.user.User;
import com.bulamen7.shop.repository.user.UserRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceTest {
    UserRepository userRepository = mock(UserRepository.class);
    PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
    UserService userService = new UserService(userRepository, passwordEncoder);

    @Test
    void shouldSaveUser() {
        RegistrationForm registrationForm = new RegistrationForm("Marek", "login", "pass", "wp@wp.pl", "pass");
        userService.saveUser(registrationForm);
        verify(userRepository).save(any());
    }


    @Test
    void shouldFindById() {
        User user = new User("Marek", "login", "pass", "wp@wp.pl");
        //when
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        User expectedUser = userService.findById(1L);
        //then
        AssertionsForClassTypes.assertThat(expectedUser).isEqualTo(user);
    }

    @Test
    void findAll() {
        User user = new User("Marek", "login", "pass", "wp@wp.pl");
        User user2 = new User("Marek5", "login5", "pass5", "w5p@wp.pl");
        //when
        when(userRepository.findAll()).thenReturn(List.of(user, user2));
        List<User> expectedUsers = userService.findAll();
        //then
        assertThat(expectedUsers).isEqualTo(userRepository.findAll());
    }

    @Test
    void deleteUserById() {
        userService.deleteUserById(5L);
        verify(userRepository).deleteById(any());
    }
}
