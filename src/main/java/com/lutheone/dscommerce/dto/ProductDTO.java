package com.lutheone.dscommerce.dto;

public class ProductDTO {

    private String id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    public ProductDTO() {
    }

    public ProductDTO(String id, Double price, String imgUrl, String description, String name) {
        this.id = id;
        this.price = price;
        this.imgUrl = imgUrl;
        this.description = description;
        this.name = name;
    }

    public String getId() {
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
