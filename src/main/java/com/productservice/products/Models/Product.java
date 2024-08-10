package com.productservice.products.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

// This class have all the attributes of products
@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String name;
    private Double price;
    private String imageurl;
    private String description;
    @ManyToOne
    private Category category;
}
