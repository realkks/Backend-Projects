package com.productservice.products.DTO.ProductsDto;

import com.productservice.products.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

    public CreateProductDto fromProduct(Product product)  {            // It will convert dto object to product models
        CreateProductDto responseDto = new CreateProductDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getName());
        responseDto.setPrice(product.getPrice());
        responseDto.setCategory(product.getCategory());
        responseDto.setImage(product.getImageurl());
        responseDto.setDescription(product.getDescription());

        return responseDto;
    }
    public Product toProduct()  {            // It will convert dto object to product models
        Product product = new Product();
        product.setId(this.id); ;
        product.setName(this.title);
        product.setPrice(this.price);
        product.setCategory(this.category);
        product.setImageurl(this.image);
        product.setDescription(this.description);

        return product;
    }
}
