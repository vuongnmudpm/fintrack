package com.vuongnm.fintrack.controller;

import com.vuongnm.fintrack.entity.Categories;
import com.vuongnm.fintrack.repository.CategoryRepository;
import com.vuongnm.fintrack.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    //get all categories
    public ResponseEntity<List<Categories>> getAllCategories() {
        List<Categories> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
}
