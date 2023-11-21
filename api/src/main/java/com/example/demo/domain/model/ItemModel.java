package com.example.demo.domain.model;

import com.example.demo.domain.entity.Item;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ItemModel {

    private Integer id;

    private String label;

    public ItemModel(Item item) {
        this.id = item.getId();
        this.label = item.getLabel();
    }
}
