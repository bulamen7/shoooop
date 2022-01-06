package com.bulamen7.shop.service.user;

import com.bulamen7.shop.model.user.RegistrationForm;
import com.bulamen7.shop.repository.user.User;
import com.bulamen7.shop.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(RegistrationForm newUserForm) {
        if (userRepository.existsByLogin(newUserForm.getLogin())) {
            throw new IllegalStateException("Duplicated User");
        }
        userRepository.save(new User(newUserForm.getName(), newUserForm.getLogin(), newUserForm.getEmail(), newUserForm.getPassword()));
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
