package com.bulamen7.shop.service.order;

import com.bulamen7.shop.model.order.OrderDto;
import com.bulamen7.shop.repository.order.OrderEntity;
import com.bulamen7.shop.repository.order.OrderRepository;
import com.bulamen7.shop.repository.product.ProductEntity;
import com.bulamen7.shop.repository.product.ProductRepository;
import com.bulamen7.shop.repository.user.UserEntity;
import com.bulamen7.shop.repository.user.UserRepository;
import com.bulamen7.shop.service.ModelMapper;
import com.bulamen7.shop.service.order.exception.OrderNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream()
                .map(ModelMapper::map)
                .collect(Collectors.toList());
    }

    public OrderDto findById(long id) {
        return orderRepository.findById(id).map(ModelMapper::map)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    public void createOrder(List<Long> productsId, String userName) {
        UserEntity user = userRepository.findByLogin(userName)
                .orElseThrow(() -> new IllegalStateException("Couldnt find user with name " + userName));

        OrderEntity orderEntity = new OrderEntity(user);
        List<ProductEntity> products = productsId.stream()
                .map(id -> productRepository.findById(id))
                .map(entity -> entity.get())
                .collect(Collectors.toList());
        for (ProductEntity product : products) {
            product.addOrder(orderEntity);
            orderEntity.addProduct(product);
        }
        orderRepository.save(orderEntity);
    }

}
