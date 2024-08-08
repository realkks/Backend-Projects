package com.productservice.products.DTO.ProductsDto;

import com.productservice.products.Models.Category;
import com.productservice.products.Models.Product;
import lombok.Getter;
import lombok.Setter;

//It is used to create object for either to receive information from outside the system  .
@Getter
@Setter
public class CreateProductRequestDto {
    private long id;
    private String name;
    private double price;
    private String categoryName;
    private String imageurl;
    private String description;

    // It will act as a mapper
    public Product toProduct()  {            // It will convert dto object to product models
        Product product = new Product();
        product.setId(this.id); ;
        product.setName(this.name);
        product.setPrice(this.price);
        Category category = new Category();
        category.setName(categoryName);
        product.setCategory(category);
        product.setImageurl(this.imageurl);
        product.setDescription(this.description);

        return product;
    }



}