package com.productservice.products.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;

// This will be used to create beans manually , so that spring can autowire the object anywhere .
@Configuration
public class ApplicationConfiguration {

    @Bean
    public RestTemplate createRestTemplate (){
        return new RestTemplate();
    }

}
