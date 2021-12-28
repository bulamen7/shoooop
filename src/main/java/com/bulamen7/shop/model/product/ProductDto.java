package com.bulamen7.shop.model.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private LocalDateTime createDateTime;

    public ProductDto(Long id, String name, BigDecimal price, String description, LocalDateTime createDateTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.createDateTime = createDateTime;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", createDateTime=" + createDateTime +
                '}';
    }
}
