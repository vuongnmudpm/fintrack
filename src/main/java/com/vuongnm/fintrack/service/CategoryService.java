package com.vuongnm.fintrack.service;

import com.vuongnm.fintrack.entity.Categories;
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

    //Creta new cat egory
    public Categories createCategory(Categories categories) {
        Optional<Categories> optionalCategories = categoryRepository.findById(categories.getCategory_id());
        if(optionalCategories.isEmpty()) {
            throw new RuntimeException("Category not found");
        }
        return categoryRepository.save(categories);
    }

    //Get all categories (system + user)
    public List<Categories> getAllCategories() {
        return categoryRepository.findByUserIdOrIsSystemTrue();
    }

    //Get categories by system
    public List<Categories> getSystemCategories() {
        return categoryRepository.findByIsSystemTrue();
    }

    //Get categories by user
    public List<Categories> getCategorieUser(Integer userId) {
        return categoryRepository.findByUserId(userId);
    }

    //Update categories by user
    public Categories updateCategories(Integer id, Categories categories, Integer userId) {
        Categories category = categoryRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Category not exist!"));

        category.setName(categories.getName());
        category.setType(categories.getType());
        category.setUpdate_at(categories.getUpdate_at());
        return categoryRepository.save(category);
    }

    //Delete categories by user
    public void deleteCategories(Integer id, Integer userId) {
        Categories category = categoryRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Category not exist"));
        categoryRepository.deleteById(id);
    }
}
