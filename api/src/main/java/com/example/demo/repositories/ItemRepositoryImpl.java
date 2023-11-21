package com.example.demo.repositories;

import com.example.demo.domain.entity.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemRepositoryImpl implements ItemRepository {

    private static int counter = 0;

    private static List<Item> items = new ArrayList<>();

    public void save(Item item) {
        item.setId(counter++);

        items.add(item);
    }

    public void save(List<Item> data) {
        items = new ArrayList<>(data);
    }

    public List<Item> findAll() {
        return items;
    }
}
