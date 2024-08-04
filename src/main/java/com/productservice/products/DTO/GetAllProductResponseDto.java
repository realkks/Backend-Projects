package com.productservice.products.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllProductResponseDto {
    private List<GetPrductDto> products;
}
