package com.productservice.products.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String name;
    private long id;
    private double price;
    private String category;
    private String imageurl;
}
