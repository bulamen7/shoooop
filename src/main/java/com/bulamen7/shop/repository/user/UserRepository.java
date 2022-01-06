package com.bulamen7.shop.repository.user;

import com.bulamen7.shop.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
