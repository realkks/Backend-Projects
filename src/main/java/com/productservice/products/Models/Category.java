package com.productservice.products.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//This class will include all the details of Category

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String name;
    private String description;
    @OneToMany (mappedBy = "category")             //category attributes
    private List<Product> allProducts;
    @OneToMany
    private List<Product> featuredProducts;
    @ManyToOne
    private SubCategory subCategory;
}
