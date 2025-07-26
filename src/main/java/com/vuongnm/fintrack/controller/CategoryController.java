package com.vuongnm.fintrack.controller;

import com.vuongnm.fintrack.entity.Category;
import com.vuongnm.fintrack.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    //get all categories
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    //get category by id
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    //create a category
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    //update a category
    public ResponseEntity<Category> updateCategory(@PathVariable Integer categoryId, @PathVariable Integer userId, @RequestBody Category category) {
        return ResponseEntity.ok(categoryService.updateCategories(categoryId, category, userId));
    }

    public ResponseEntity<Void> deleteCategory(@PathVariable Integer categoryId, @PathVariable Integer userId) {
        boolean deleted = categoryService.deleteCategory(categoryId, userId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
