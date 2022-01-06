package com.bulamen7.shop.service.user;

import com.bulamen7.shop.model.user.RegistrationForm;
import com.bulamen7.shop.repository.user.User;
import com.bulamen7.shop.repository.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(RegistrationForm newUserForm) {
        if (userRepository.existsByLogin(newUserForm.getLogin())) {
            throw new IllegalStateException("Duplicated User");
        }
        userRepository.save(new User(newUserForm.getName(), newUserForm.getLogin(), passwordEncoder.encode(newUserForm.getPassword()), newUserForm.getEmail()));
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User not found"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
//TODO walidator dla hasla, dodac pola, testy dla rejestracji,