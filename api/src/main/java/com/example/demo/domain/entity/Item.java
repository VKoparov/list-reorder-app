package com.example.demo.domain.entity;

import com.example.demo.domain.model.ItemModel;
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
public class Item {

    private Integer id;

    private String label;

    public Item(ItemModel model) {
        this.id = model.getId();
        this.label = model.getLabel();
    }
}
