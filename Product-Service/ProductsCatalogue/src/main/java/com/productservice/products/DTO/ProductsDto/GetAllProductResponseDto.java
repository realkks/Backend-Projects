package com.productservice.products.DTO.ProductsDto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllProductResponseDto {
    private List<GetProductDto> products;
}
