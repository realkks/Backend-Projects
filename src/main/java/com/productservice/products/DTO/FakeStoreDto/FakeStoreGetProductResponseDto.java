package com.productservice.products.DTO.FakeStoreDto;

import com.productservice.products.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreGetProductResponseDto {

    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

    public Product toProduct() {
        Product product = new Product();
        product.setId(this.getId());
        product.setName(this.getTitle());
        product.setImageurl(this.getImage());
        product.setPrice(this.getPrice());
        product.setCategory(this.getCategory());
        product.setDescription(this.getDescription());

        return product;
    }
}
