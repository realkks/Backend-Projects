package com.productservice.products.DTO;

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
    private String category;
    private String imageurl;

//    public Product toProduct()  {            // It will convert dto object to product models
//        Product product = new Product();
//        product.setId(this.id) ;
//        product.setName(this.name);
//        product.setPrice(this.price);
//        product.setCategory(this.category);
//        product.setImageurl(this.imageurl);
//        return product;
//    }



}