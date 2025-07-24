package com.vuongnm.fintrack.service;

import com.vuongnm.fintrack.entity.Transaction;
import com.vuongnm.fintrack.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    //add new transaction
    public Transaction createTransaction(Transaction transaction) {
        transaction.setCreatedAt(LocalDate.now().atStartOfDay());
        return transactionRepository.save(transaction);
    }

    //get all transaction by user
    public List<Transaction> getAllTransactionByUser(Integer userId) {
        return transactionRepository.findByUserId(userId);
    }

    //update transaction
    public Transaction updateTransaction(Integer id, Transaction updated) {
        Transaction existing = (Transaction) transactionRepository.findByUserId(id);

        existing.setTitle(updated.getTitle());
        existing.setAmount(updated.getAmount());
        existing.setType(updated.getType());
        existing.setCategory(updated.getCategory());
        existing.setTransactionDate(updated.getTransactionDate());
        existing.setPaymentMethod(updated.getPaymentMethod());
        existing.setNote(updated.getNote());
        existing.setDescription(updated.getDescription());
        existing.setReceiptImageUrl(updated.getReceiptImageUrl());
        existing.setIsRecurring(updated.getIsRecurring());
        existing.setRecurringInterval(updated.getRecurringInterval());
        existing.setStatus(updated.getStatus());
        existing.setUpdatedAt(updated.getUpdatedAt());

        return transactionRepository.save(existing);
    }

    //delete transaction
    public boolean deleteTransaction(Integer id) {
        if (transactionRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Transaction not exist!");
        }
        transactionRepository.deleteById(id);
        return false;
    }

    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }
    
    public Transaction getTransactionById(Integer id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }

    //tong thu chi theo user

 }
