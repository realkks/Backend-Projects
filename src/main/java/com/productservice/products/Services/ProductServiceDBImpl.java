package com.productservice.products.Services;

import com.productservice.products.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

// Object of this class will be automatically created by spring when required.
@Service("DBImpl")
public class ProductServiceDBImpl implements ProductService {
    public Product createProduct(Product product){
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }
}
