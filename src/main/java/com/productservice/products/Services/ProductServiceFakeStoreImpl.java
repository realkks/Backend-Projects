package com.productservice.products.Services;

import com.productservice.products.Models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// Object of this class will be automatically created by spring when required.
@Service("FakeStoreImpl")
//@Primary
public class ProductServiceFakeStoreImpl implements ProductService {
    public  void createProduct(long id,String name , double price, String category, String imageurl){
        //return null;
    }
}
