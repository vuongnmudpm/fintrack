package com.vuongnm.fintrack.repository;

import com.vuongnm.fintrack.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
//    public Category findByUserId(Integer userId);
//    public List<Category> findByIsSystemTrue();
//    public List<Category> findByUserIdOrIsSystemTrue();
}
