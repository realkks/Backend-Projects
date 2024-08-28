package com.productservice.products.DTO.ProductsDto;

import com.productservice.products.Models.Category;
import com.productservice.products.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
    //private long id;
    private String title;
    private Double price;
    private String description;
    private String image;
    private String categoryName;

    public CreateProductDto fromProduct(Product product)  {            // It will convert dto object to product models
        CreateProductDto responseDto = new CreateProductDto();
        //responseDto.setId(product.getId());
        responseDto.setTitle(product.getName());
        responseDto.setPrice(product.getPrice());
        responseDto.setImage(product.getImageurl());
        responseDto.setDescription(product.getDescription());

        return responseDto;
    }
    public Product toProduct()  {            // It will convert dto object to product models
        Product product = new Product();
        //product.setId(this.id); ;
        product.setName(this.title);
        product.setPrice(this.price);
        Category category = new Category();
        category.setName(categoryName);
        product.setCategory(category);
        product.setImageurl(this.image);
        product.setDescription(this.description);

        return product;
    }
}
