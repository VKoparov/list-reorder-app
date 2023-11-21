package com.example.demo.repositories;

import com.example.demo.domain.entity.Item;

import java.util.List;

public interface ItemRepository {

    void save(Item item);

    void save(List<Item> items);

    List<Item> findAll();
}
