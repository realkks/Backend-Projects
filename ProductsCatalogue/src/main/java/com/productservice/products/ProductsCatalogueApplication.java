package com.productservice.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsCatalogueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsCatalogueApplication.class, args);
        System.out.println("Project is running");
    }

}
