package com.example.shopping_list.item.controller;

import com.example.shopping_list.item.model.Item;
import com.example.shopping_list.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Item> getItems(Pageable pageable){
        return service.getItems(pageable);
    }

}
