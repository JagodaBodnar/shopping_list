package com.example.shopping_list.cart.exceptions;

public class ProductQuantityOutOfBound extends RuntimeException{
    public ProductQuantityOutOfBound(String message) {
        super(message);
    }
}
