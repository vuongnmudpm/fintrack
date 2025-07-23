package com.vuongnm.fintrack.repository;

import com.vuongnm.fintrack.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
        List<Transaction> findByUserId(Integer userId);

    void deleteById(Integer id);
}
