package com.shopping.products.controlleradvices;

import com.shopping.products.dtos.ArithmeticExceptionDto;
import com.shopping.products.dtos.ExceptionDto;
import com.shopping.products.exceptions.ProductNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException(){
        ArithmeticExceptionDto arithmeticExceptionDto = new ArithmeticExceptionDto();
        arithmeticExceptionDto.setMessage("Something gone wrong");
        return new ResponseEntity<>(arithmeticExceptionDto,HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<ExceptionDto> handleProductNotExistsException(ProductNotExistsException productNotExistsException){
        ExceptionDto dto=new ExceptionDto();
        dto.setMessage(productNotExistsException.getMessage());
        dto.setDetail("Check the Product ID,Probably it doesn't exist");

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
