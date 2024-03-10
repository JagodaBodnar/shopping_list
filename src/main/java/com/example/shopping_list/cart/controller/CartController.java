package com.example.shopping_list.cart.controller;

import com.example.shopping_list.cart.model.Cart;
import com.example.shopping_list.cart.service.CartService;
import com.example.shopping_list.cart_item.model.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/carts")
public class CartController {
    private final CartService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cart getCart(@PathVariable UUID id){
        return service.getCart(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Cart createCart(){
        return service.createCart();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cart updateCart(@RequestBody CartItem body, @PathVariable UUID id){
        return service.updateCart(body, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCart(@PathVariable UUID id){
        service.deleteCart(id);
    }
}
