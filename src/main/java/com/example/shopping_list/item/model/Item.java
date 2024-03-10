package com.example.shopping_list.item.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "pp_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pp_item_seq")
    @SequenceGenerator(name = "pp_item_seq", allocationSize = 1)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private BigDecimal price;
    private long quantity;

}
