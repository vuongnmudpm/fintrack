package com.vuongnm.fintrack.service;

import com.vuongnm.fintrack.entity.Category;
import com.vuongnm.fintrack.exception.CategoryAlreadyExistException;
import com.vuongnm.fintrack.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }


    //Creta new category
    public Category createCategory(Category category) {
        Category categoryCheck = categoryRepository.findByName(category.getName());
        if (categoryCheck != null) {
            throw new CategoryAlreadyExistException("Category with name '" + category.getName() + "' already exists.");
        }
        return categoryRepository.save(category);
    }

//
//    //Get all categories (system + user)
////    public List<Category> getAllCategories() {
////        return categoryRepository.findByUserIdOrIsSystemTrue();
////    }
//
//    //Get categories by system
////    public List<Category> getSystemCategories() {
////        return categoryRepository.findByIsSystemTrue();
////    }
//
//    //Get category by user
////    public Category getCategoriesByUser(Integer userId) {
////        return categoryRepository.findByUserId(userId);
////    }
//
    //Get category by category id
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }
//
//    //Update categories by user
    public Category updateCategories(Integer id, Category categories, Integer userId) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not exist!"));

        category.setName(categories.getName());
        category.setType(categories.getType());
        category.setUpdateAt(categories.getUpdateAt());
        return categoryRepository.save(category);
    }

    //Delete categories by user
    public boolean deleteCategory(Integer id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true; // xoá thành công
        } else {
            return false; // không tồn tại
        }
    }
}
