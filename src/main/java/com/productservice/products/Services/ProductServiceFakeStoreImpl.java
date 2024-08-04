package com.productservice.products.Services;

import com.productservice.products.Models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// Object of this class will be automatically created by spring when required.
@Service("FakeStoreImpl")
//@Primary
public class ProductServiceFakeStoreImpl implements ProductService {
    public Product createProduct(Product product){
        return null;
    }
}
