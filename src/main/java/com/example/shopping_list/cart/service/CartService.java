package com.example.shopping_list.cart.service;

import com.example.shopping_list.cart.exceptions.CartNotFoundException;
import com.example.shopping_list.cart.exceptions.ProductQuantityOutOfBound;
import com.example.shopping_list.cart.model.Cart;
import com.example.shopping_list.cart.repository.CartRepository;
import com.example.shopping_list.cart_item.model.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository repository;

    public Cart getCart(UUID id) {
        return repository.findById(id).orElseThrow(() -> new CartNotFoundException("Cart was not found."));
    }

    public void deleteCart(UUID id) {
        repository.deleteById(id);
    }

    public Cart createCart() {
        return repository.save(new Cart());
    }

    public Cart updateCart(CartItem body, UUID id) {
        Cart findCart = getCart(id);
        Optional<CartItem> first = findCart.getCartItemList()
                .stream()
                .filter(element -> Objects.equals(element.getItem().getId(), body.getItem().getId())).findFirst();
        if(first.isPresent()){
            CartItem cartItem = first.get();
            if(cartItem.getQuantity() + body.getQuantity() < 0){
                throw new ProductQuantityOutOfBound("Given quantity is out of bound.");
            }
            if(cartItem.getQuantity() + body.getQuantity() == 0){

            }
            if(cartItem.getItem().getQuantity() >= (body.getQuantity() +  cartItem.getQuantity())){
                cartItem.updateItemQuantity(body.getQuantity());
            }
            else{
                throw new ProductQuantityOutOfBound("Given quantity is out of bound.");
            }
        }
        else{
            findCart.getCartItemList().add(body);
        }
        return repository.save(findCart);
    }
}
