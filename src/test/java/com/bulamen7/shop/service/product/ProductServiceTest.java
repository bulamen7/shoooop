package com.bulamen7.shop.service.product;

import com.bulamen7.shop.model.product.ProductDto;
import com.bulamen7.shop.repository.product.ProductEntity;
import com.bulamen7.shop.repository.product.ProductRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProductServiceTest {
    ProductRepository productRepository = mock(ProductRepository.class);
    ProductService productService = new ProductService(productRepository);

    @Test
    void findAll() {
        //given
        ProductEntity entityProduct = new ProductEntity();
        when(productRepository.findAll()).thenReturn(List.of(entityProduct));
        //when
        int size = productService.findAll().size();
        //then
        assertThat(size).isEqualTo(1);
    }

    @Test
    void shouldFindById() {
        //given
        ProductEntity entityProduct = new ProductEntity("A", BigDecimal.TEN, "desc");
        when(productRepository.findById(1L)).thenReturn(Optional.of(entityProduct));
        //when
        ProductDto expectedProduct = productService.findById(1L);
        //then
        assertThat(expectedProduct.getId()).isEqualTo(entityProduct.getId());
    }

    @Test
    void deleteById() {
        //given
        //when
        productService.deleteById(5L);
        //then
        verify(productRepository).deleteById(any());
    }
}