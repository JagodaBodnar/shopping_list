package com.example.shopping_list.cart.model;

import com.example.shopping_list.cart_item.model.CartItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pp_cart")
@AllArgsConstructor
@Getter
@NoArgsConstructor/*(access = AccessLevel.PROTECTED)*/
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> cartItemList = new ArrayList<>();

    @Transient
    //it means it is not adding to database
    private BigDecimal totalPrice;

    public BigDecimal getTotalPrice() {
        return this.cartItemList.stream().map(element -> element.getItem().getPrice().multiply(BigDecimal.valueOf(element.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Transient
    private long totalNumber;

    public long getTotalNumber() {
        return this.cartItemList.stream().mapToLong(CartItem::getQuantity).sum();
    }
}
