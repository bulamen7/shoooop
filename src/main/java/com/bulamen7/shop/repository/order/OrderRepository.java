package com.bulamen7.shop.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
//TODO BAZY, relacje , klucz obcy, 2x jeden do wielu = wiele do wielu
//create table company z kluczem glownym
// create table employee z kluczem glownym i kluczem obczym do tabeli company