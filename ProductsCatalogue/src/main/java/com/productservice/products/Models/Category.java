package com.productservice.products.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//This class will include all the details of Category

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    @Column(nullable = false, unique = true,name = "category_name")       //category attributes
    private String name;
    private String description;
    @OneToMany (mappedBy = "category",cascade = CascadeType.PERSIST)             //category attributes
    private List<Product> allProducts;
    @OneToMany(fetch = FetchType.EAGER)       // Fetch type EAGER will fetch that attribute when we will fetch the object of this class
    //Fetch type LAZY will fetch that attribute when we will use that attributes
    private List<Product> featuredProducts;
    @ManyToOne
    private SubCategory subCategory;

    // Creating new columns
    private int totalProducts;
}
