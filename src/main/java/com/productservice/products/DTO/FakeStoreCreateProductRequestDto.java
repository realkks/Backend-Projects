package com.productservice.products.DTO;


import lombok.Getter;
import lombok.Setter;

// Add all attributes of 3rd party apis
@Setter
@Getter
public class FakeStoreCreateProductRequestDto {
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

}
