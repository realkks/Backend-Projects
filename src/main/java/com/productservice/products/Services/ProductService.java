package com.productservice.products.Services;

import com.productservice.products.Exceptions.ProductNotFoundException;
import com.productservice.products.Models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProduct();
    Product updateProduct(Long id, Product product) throws ProductNotFoundException;


}
