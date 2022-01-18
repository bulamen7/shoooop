package com.bulamen7.shop.repository.order;

import com.bulamen7.shop.repository.product.ProductEntity;
import com.bulamen7.shop.repository.user.UserEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserEntity user;

    @ManyToMany(mappedBy = "orderEntities")
    private List<ProductEntity> products = new ArrayList<>();

    public OrderEntity() {
    }

    public OrderEntity(UserEntity user) {
        this.user = user;
    }

    public void addProduct(ProductEntity productEntity) {
        this.products.add(productEntity);
    }

    public Long getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }
}
