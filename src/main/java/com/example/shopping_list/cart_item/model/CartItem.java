package com.example.shopping_list.cart_item.model;

import com.example.shopping_list.item.model.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Entity
@Getter
@Setter
@Table(name="pp_cart_item")
public class CartItem {
    @OneToOne
    @Id
    private Item item;

    private long quantity;
    public void updateItemQuantity(long quantity){
        setQuantity(this.quantity + quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return quantity == cartItem.quantity && Objects.equals(item, cartItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, quantity);
    }
}
