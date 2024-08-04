package com.productservice.products.DTO;

import com.productservice.products.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetPrductDto {
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

    public static GetPrductDto fromProduct(Product product){
        GetPrductDto getProductDto = new GetPrductDto();
        getProductDto.setId(product.getId());
        getProductDto.setTitle(product.getName());
        getProductDto.setPrice(product.getPrice());
        getProductDto.setCategory(product.getCategory());
        getProductDto.setImage(product.getImageurl());
        getProductDto.setDescription(product.getDescription());

        return getProductDto;
    }
}
