package com.productservice.products.Services;

import com.productservice.products.Exceptions.ProductNotFoundException;
import com.productservice.products.Models.Category;
import com.productservice.products.Models.Product;
import com.productservice.products.Repositories.CategoryRepo;
import com.productservice.products.Repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Object of this class will be automatically created by spring when required.
@Service("DBImpl")
public class ProductServiceDBImpl implements ProductService {
    // Create productRepository object
    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;
    // create constructor and assign the productrepo object .
    public ProductServiceDBImpl(ProductRepo productRepo1,CategoryRepo categoryRepo1){
        this.productRepo = productRepo1;
        this.categoryRepo= categoryRepo1;
    }
    public Product createProduct(Product product) {
        String categoryName = product.getCategory().getName();
        product.setCategory(getCategoryToBeInProduct(product));
        Product saveProduct = productRepo.save(product);
        return saveProduct;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }


    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isEmpty()){
            throw new ProductNotFoundException();
        }
        Product productToUpdate = productOptional.get();
        if(product.getName()!=null) {
            productToUpdate.setName(product.getName());
        }
        if(product.getPrice()!=null) {
            productToUpdate.setPrice(product.getPrice());
        }
        if(product.getDescription()!=null) {
            productToUpdate.setDescription(product.getDescription());
        }
        if(product.getCategory()!=null) {

            productToUpdate.setCategory(getCategoryToBeInProduct(product));
        }
        if(product.getImageurl()!=null) {
            productToUpdate.setImageurl(product.getImageurl());
        }

        return productRepo.save(productToUpdate);
    }

    // This method will check the categoryname in category
    private Category getCategoryToBeInProduct(Product product){
        String categoryName = product.getCategory().getName();
        Optional<Category> category = categoryRepo.findByName(categoryName);

        Category tobePutInCategory = null;
        if (category.isEmpty()){
            Category category1 = new Category();
            category1.setName(categoryName);
            //tobePutInCategory = categoryRepo.save(category1);
            tobePutInCategory = category1;
        }
        else{
            tobePutInCategory = category.get();
        }
        return tobePutInCategory;
    }
}
