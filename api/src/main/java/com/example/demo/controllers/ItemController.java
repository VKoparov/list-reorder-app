package com.example.demo.controllers;

import com.example.demo.domain.model.ItemActionRequest;
import com.example.demo.domain.model.ItemModel;
import com.example.demo.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/items")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemModel>> get() {
        List<ItemModel> response = this.itemService.findAll();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody ItemModel request) {
        this.itemService.create(request);

        return ResponseEntity.ok(CREATED);
    }

    @PutMapping
    public ResponseEntity<List<ItemModel>> changePosition(@RequestBody ItemActionRequest request) {
        List<ItemModel> response = this.itemService.changePosition(request.getId(), request.getAction());

        return ResponseEntity.ok(response);
    }
}
