package com.bulamen7.shop.service.product;

import com.bulamen7.shop.model.product.NewProductForm;
import com.bulamen7.shop.model.product.ProductDto;
import com.bulamen7.shop.model.product.UpdateProductForm;
import com.bulamen7.shop.repository.product.ProductEntity;
import com.bulamen7.shop.repository.product.ProductRepository;
import com.bulamen7.shop.service.ModelMapper;
import com.bulamen7.shop.service.product.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(NewProductForm productForm) {
        productRepository.save(new ProductEntity(productForm.getName(), productForm.getPrice(), productForm.getDescription()));
    }

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(ModelMapper::map)
                .collect(Collectors.toList());
    }

    public ProductDto findById(Long id) {
        return productRepository
                .findById(id)
                .map(ModelMapper::map)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void deleteById(Long id) {
        productRepository
                .deleteById(id);
    }

    public void patchUpdate(Long id, UpdateProductForm updateProductForm) {
        ProductEntity entityProduct = productRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Product cant be update"));

        if (updateProductForm.getPrice() != null) {
            entityProduct.setPrice(updateProductForm.getPrice());
        }
        if (updateProductForm.getName() != null) {
            entityProduct.setName(updateProductForm.getName());
        }
        if (updateProductForm.getDescription() != null) {
            entityProduct.setDescription(updateProductForm.getDescription());
        }
    }

    public void putUpdate(Long id, UpdateProductForm updateProductForm) {
        ProductEntity entityProduct = productRepository
                .findById(id).
                orElseThrow(() -> new RuntimeException("Product cant be update"));
        entityProduct.setPrice(updateProductForm.getPrice());
        entityProduct.setName(updateProductForm.getName());
        entityProduct.setDescription(updateProductForm.getDescription());
    }


}
