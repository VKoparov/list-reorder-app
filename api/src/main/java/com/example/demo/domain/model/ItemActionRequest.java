package com.example.demo.domain.model;

import com.example.demo.domain.enums.Action;
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
public class ItemActionRequest {

    private Integer id;

    private String action;
}
