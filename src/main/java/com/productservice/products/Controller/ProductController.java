package com.productservice.products.Controller;

import com.productservice.products.DTO.CreateProductResponseDto;
import com.productservice.products.DTO.CreateProductRequestDto;
import com.productservice.products.Models.Product;
import com.productservice.products.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products") // /products path will be common for all methods in this class .
public class ProductController {

    @Value("${productServiceType}")
    //String serviceType;
    private ProductService prodService;

    public ProductController(@Qualifier("FakeStoreImpl") ProductService prodService){    // In qualifier we will add service class name
        this.prodService = prodService;                  //Assigning object of productService
    }

    @PostMapping("") // This method will create products .
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createdto) {   // We will receive dto object as part of request body
        //Product product = ProductService.createProduct(CreateProductRequestDto.toProduct());
         return "This product is priced at :"+createdto.getPrice();
    }

    @GetMapping("")
    public void getAllProducts(){

    }
    @GetMapping("/{id}")        // Variable path
    public String getSingleProduct(@PathVariable ("id") long id){    // Defining path variable and receiving required id.
        return "Here is your product" + id ;
    }

    @DeleteMapping("/{id}")
    public void deleteSingleproduct(){

    }
    @RequestMapping(name="kamlesh",value="/kamlesh")    // To create user defined request type
    public String something(){
    return "Kamlesh magic ";
    }
}
