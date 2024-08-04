package com.productservice.products.Services;

import com.productservice.products.DTO.GetProductResponseDto;
import com.productservice.products.Models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProduct();


}
