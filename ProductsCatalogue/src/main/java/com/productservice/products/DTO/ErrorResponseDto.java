package com.productservice.products.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {
    String status;
    String errorMessage;
}
