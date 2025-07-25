package com.vuongnm.fintrack.controller;

import com.vuongnm.fintrack.entity.Categories;
import com.vuongnm.fintrack.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;

    //get all categories
    public ResponseEntity<List<Categories>> getAllCategories() {
        List<Categories> categories = categoryRepository.findAll();
        return ResponseEntity.ok(categories);
    }
}           
