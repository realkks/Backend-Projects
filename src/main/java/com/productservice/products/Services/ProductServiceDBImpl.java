package com.productservice.products.Services;

import com.productservice.products.Models.Product;
import org.springframework.stereotype.Service;

// Object of this class will be automatically created by spring when required.
@Service("DBImpl")
public class ProductServiceDBImpl implements ProductService {
    public Product createProduct(Product product){
        return null;
    }
}
