package com.example.demo.services;

import com.example.demo.domain.entity.Item;
import com.example.demo.domain.enums.Action;
import com.example.demo.domain.model.ItemModel;
import com.example.demo.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<ItemModel> findAll() {
        return this.itemRepository.findAll()
                .stream()
                .map(ItemModel::new)
                .collect(Collectors.toList());
    }

    public void create(ItemModel model) {
        Item item = new Item(model);

        this.itemRepository.save(item);
    }

    public List<ItemModel> changePosition(Integer id, String action) {
        List<Item> items = this.itemRepository.findAll();

        List<Item> updatedItems = Action.valueOf(action)
                .getFunction()
                .apply(items, id);

        this.itemRepository.save(updatedItems);

        return findAll();
    }
}
