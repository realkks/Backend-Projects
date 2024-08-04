package com.productservice.products.Services;

import com.productservice.products.Models.Product;

public interface ProductService {
    void createProduct(long id,String name , double price, String category, String imageurl);


}
