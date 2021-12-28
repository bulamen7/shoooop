package com.bulamen7.shop.service.product;

import com.bulamen7.shop.model.product.EntityProduct;
import com.bulamen7.shop.model.product.NewProductForm;
import com.bulamen7.shop.model.product.ProductDto;
import com.bulamen7.shop.model.product.UpdateProductForm;
import com.bulamen7.shop.repository.product.ProductRepository;
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
        productRepository.save(new EntityProduct(productForm.getName(), productForm.getPrice(), productForm.getDescription()));
    }

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(product -> map(product))
                .collect(Collectors.toList());
    }

    public ProductDto findById(Long id) {
        return productRepository
                .findById(id)
                .map(product -> map(product))
                .orElseThrow(() -> new RuntimeException("Product doesnt exists"));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void patchUpdate(Long id, UpdateProductForm updateProductForm) {
        EntityProduct entityProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException());
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
        EntityProduct entityProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException());
        entityProduct.setPrice(updateProductForm.getPrice());
        entityProduct.setName(updateProductForm.getName());
        entityProduct.setDescription(updateProductForm.getDescription());
    }

    private ProductDto map(EntityProduct product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getDescription(), product.getCreateDateTime());
    }


}
