package com.productservice.products.Services;

import com.productservice.products.DTO.FakeStoreCreateProductRequestDto;
import com.productservice.products.DTO.FakeStoreGetProductResponseDto;
import com.productservice.products.DTO.GetAllProductResponseDto;
import com.productservice.products.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Object of this class will be automatically created by spring when required.
@Service("FakeStoreImpl")
//@Primary
public class ProductServiceFakeStoreImpl implements ProductService {

    private RestTemplate restTemplate; // It will allow to call any third party apis.

    public ProductServiceFakeStoreImpl(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    public Product createProduct(Product product){
        // Create fakestore api object
        FakeStoreCreateProductRequestDto request = new FakeStoreCreateProductRequestDto();
        // Setting 3rd party api attribute name according to ours
        request.setTitle(product.getName());
        request.setPrice(product.getPrice());
        request.setCategory(product.getCategory());
        request.setImage(product.getImageurl());
        request.setDescription(product.getDescription());

        // Calling 3rd party api : Parameters required for postForObject (url,object,return onject)
        FakeStoreGetProductResponseDto response =  restTemplate.postForObject
                ("https://fakestoreapi.com/products",request,
                FakeStoreGetProductResponseDto.class);
        Product fakeStoreproduct = new Product();
        fakeStoreproduct.setId(response.getId());
        fakeStoreproduct.setName(response.getTitle());
        fakeStoreproduct.setImageurl(response.getImage());
        fakeStoreproduct.setPrice(response.getPrice());
        fakeStoreproduct.setCategory(response.getCategory());
        fakeStoreproduct.setDescription(response.getDescription());

        return fakeStoreproduct;
    }

    @Override
    public List<Product> getAllProduct() {
        FakeStoreGetProductResponseDto[] response = restTemplate.getForObject
                ("https://fakestoreapi.com/products", FakeStoreGetProductResponseDto[].class);

        List<FakeStoreGetProductResponseDto> responseDtoList = Stream.of(response).toList();
        List<Product> products = new ArrayList<>();
        for(FakeStoreGetProductResponseDto responsedto :responseDtoList){
            products.add(responsedto.toProduct());
        }
        return products;

    }
}
