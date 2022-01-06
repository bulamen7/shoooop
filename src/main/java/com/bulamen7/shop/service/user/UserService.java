package com.bulamen7.shop.service.user;

import com.bulamen7.shop.model.user.User;
import com.bulamen7.shop.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        if (!userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        } else throw new IllegalStateException("Duplicated User");
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
