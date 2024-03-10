package com.example.shopping_list.item.service;

import com.example.shopping_list.cart_item.model.CartItem;
import com.example.shopping_list.item.model.Item;
import com.example.shopping_list.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository repository;

    public Page<Item> getItems(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
