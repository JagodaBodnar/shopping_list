package com.example.shopping_list.cart.controller;

import com.example.shopping_list.cart.exceptions.CartNotFoundException;
import com.example.shopping_list.cart.exceptions.ProductQuantityOutOfBound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CartControllerAdvice {
    @ExceptionHandler(CartNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String handleCartNotFoundException(CartNotFoundException exception){
        return exception.getMessage();
    }
    @ExceptionHandler(ProductQuantityOutOfBound.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    private String handleProductQuantityOutOfBound(ProductQuantityOutOfBound exception){
        return exception.getMessage();
    }
}
