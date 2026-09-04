package com.yakupceri.expense_tracker_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yakupceri.expense_tracker_backend.domain.Expense;
import com.yakupceri.expense_tracker_backend.service.ExpenseService;

@RestController 
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*")

public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @GetMapping //Veri çekmek ve Okumak için
    public List<Expense> getAllExpenses() { //komutu ile servisi tetikler, veritabanındaki tüm harcamaları çeker ve ekrana JSON olarak fırlatır.
        return  expenseService.getAllExpenses();
    }

    @PostMapping //Veri kaydetmek ve oluşturmak için
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.saveExpense(expense);
    }
}
