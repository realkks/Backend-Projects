package com.productservice.products.DTO;

import com.productservice.products.Models.Product;
import lombok.Getter;
import lombok.Setter;

//It is used to create object for either to send information out from our system
@Setter
@Getter
public class CreateProductResponseDto {
    private long id;
    private String name;
    private double price;
    private String category;
    private String imageurl;

    public static CreateProductResponseDto fromProduct(Product product){
        CreateProductResponseDto responseDto = new CreateProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setName(product.getName());
        responseDto.setPrice(product.getPrice());
        responseDto.setCategory(product.getCategory());
        responseDto.setImageurl(product.getImageurl());

        return responseDto;
    }

}
