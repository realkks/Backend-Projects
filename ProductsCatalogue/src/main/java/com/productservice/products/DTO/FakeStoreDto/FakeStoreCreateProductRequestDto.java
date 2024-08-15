package com.productservice.products.DTO.FakeStoreDto;


import com.productservice.products.Models.Category;
import com.productservice.products.Models.Product;
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
    private String categoryName;

    public static FakeStoreCreateProductRequestDto fromProduct(Product product){
        FakeStoreCreateProductRequestDto fscprd = new FakeStoreCreateProductRequestDto();
        fscprd.setTitle(product.getName());
        fscprd.setDescription(product.getDescription());
        fscprd.setCategoryName(product.getCategory().getName());
        fscprd.setPrice(product.getPrice());
        fscprd.setImage(product.getImageurl());

        return fscprd;
    }

}
