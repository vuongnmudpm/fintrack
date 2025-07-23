package com.vuongnm.fintrack.repository;

import com.vuongnm.fintrack.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {
    public List<Categories> findByUserId(Integer userId);
    public List<Categories> findByIsSystemTrue();
    public List<Categories> findByUserIdOrIsSystemTrue();
}
