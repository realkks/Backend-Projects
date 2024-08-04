package com.productservice.products.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductResponseDto {

    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

}
