package com.lutheone.dscommerce.dto;

import com.lutheone.dscommerce.entities.Product;
import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

    private Long id;

    @Size(min = 3, max = 80)
    @NotBlank(message = "Field cannot be blank")
    private String name;

    @Size(min = 10, message = "Description must have at least 10 characters")
    @NotBlank(message = "Field cannot be blank")
    private String description;

    @Positive(message = "Price must be positive")
    private Double price;
    private String imgUrl;

    @JsonCreator
    public ProductDTO(Long id, Double price, String imgUrl, String description, String name) {
        this.id = id;
        this.price = price;
        this.imgUrl = imgUrl;
        this.description = description;
        this.name = name;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
