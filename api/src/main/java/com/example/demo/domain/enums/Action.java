package com.example.demo.domain.enums;

import com.example.demo.domain.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

@Getter
@AllArgsConstructor
public enum Action {
    UP(
            (List<Item> items, Integer id) -> {
                int index = getIndex(items, id);
                if (index > 0 && index < items.size()) {
                    Collections.swap(items, index, index - 1);
                }
                return items;
            }
    ),
    DOWN(
            (List<Item> items, Integer id) -> {
                int index = getIndex(items, id);
                if (index >= 0 && index < items.size() - 1) {
                    Collections.swap(items, index, index + 1);
                }
                return items;
            }
    );

    final BiFunction<List<Item>, Integer, List<Item>> function;

    private static int getIndex(List<Item> items, int id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .map(items::indexOf)
                .get();
    }
}
