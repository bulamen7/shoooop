package com.bulamen7.shop.model.product;

import java.math.BigDecimal;
import java.util.Objects;

public class NewProductForm {
    private String name;
    private BigDecimal price;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NewProductForm() {
    }

    public NewProductForm(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewProductForm that = (NewProductForm) o;
        return Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, description);
    }

    @Override
    public String toString() {
        return "NewProductForm{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

}
