package com.bulamen7.shop.service.product;

import com.bulamen7.shop.model.product.EntityProduct;
import com.bulamen7.shop.model.product.ProductDto;
import com.bulamen7.shop.repository.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceIT {

    @Autowired
    ProductService sut;
    @MockBean
    ProductRepository productRepository;

    @Test
    void findAll() {
        //given
        EntityProduct entityProduct = new EntityProduct();
        when(productRepository.findAll()).thenReturn(List.of(entityProduct));
        //when
        int size = sut.findAll().size();
        //then
        assertThat(size).isEqualTo(1);
    }

    @Test
    void shouldFindById() {
        //given
        EntityProduct entityProduct = new EntityProduct("A", BigDecimal.TEN, "desc");
        when(productRepository.findById(1L)).thenReturn(Optional.of(entityProduct));
        //when
        ProductDto expectedProduct = sut.findById(1L);
        //then
        assertThat(expectedProduct.getId()).isEqualTo(entityProduct.getId());
    }

    @Test
    void deleteById() {
        //given
        //when
        sut.deleteById(5L);
        //then
        verify(productRepository).deleteById(any());
    }


}
