package com.productservice.products.Advices;

import com.productservice.products.DTO.ErrorResponseDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// This class will work as Exception Advice and exception will work for all controller classes .

@ControllerAdvice
public class ExceptionAdvices {
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDto handleException(RuntimeException e){

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setStatus("ERROR!");
        errorResponseDto.setErrorMessage(e.getMessage());
        return errorResponseDto;
    }

    @ExceptionHandler(Exception.class)
    public String exceptionHandle(){
        return "Something went wrong";
    }
}
