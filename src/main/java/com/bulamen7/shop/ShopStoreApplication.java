package com.bulamen7.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ShopStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopStoreApplication.class, args);

    }
}

