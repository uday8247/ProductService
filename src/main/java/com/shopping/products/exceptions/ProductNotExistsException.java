package com.shopping.products.exceptions;

public class ProductNotExistsException extends Exception{

    public ProductNotExistsException(String message){
        super(message);
    }
}
