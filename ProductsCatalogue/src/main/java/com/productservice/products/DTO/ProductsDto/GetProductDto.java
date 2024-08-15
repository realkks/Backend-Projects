package com.productservice.products.DTO.ProductsDto;

import com.productservice.products.Models.Category;
import com.productservice.products.Models.Product;
import lombok.Getter;
import lombok.Setter;


// This class will be used to set attributes dto object to product object .
@Getter
@Setter
public class GetProductDto {
    private long id;
    private String title;
    private Double price;
    private String description;
    private String image;

    public static GetProductDto fromProduct(Product product){
        GetProductDto getProductDto = new GetProductDto();
        getProductDto.setId(product.getId());
        getProductDto.setTitle(product.getName());
        getProductDto.setPrice(product.getPrice());
        getProductDto.setImage(product.getImageurl());
        getProductDto.setDescription(product.getDescription());

        return getProductDto;
    }
}
