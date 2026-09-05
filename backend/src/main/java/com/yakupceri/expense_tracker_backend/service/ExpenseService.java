package com.yakupceri.expense_tracker_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yakupceri.expense_tracker_backend.domain.Expense;
import com.yakupceri.expense_tracker_backend.repository.ExpenseRepository;

@Service 
public class ExpenseService {
    private final ExpenseRepository ExpenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.ExpenseRepository = expenseRepository;
    }

     // Tüm harcamaları getir (Web sitesindeki liste tablosu için)
    public List<Expense> getAllExpenses(){
        return ExpenseRepository.findAll(); 
    }

    // Yeni harcama kaydet (Web sitesindeki form için)
    public Expense saveExpense(Expense expense) { 
        return ExpenseRepository.save(expense);
    }

    // Harcama sil (Web sitesindeki sil butonu için)
    public void deleteExpense(Long id) {
        ExpenseRepository.deleteById(id);
    }
}
