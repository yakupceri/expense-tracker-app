package com.yakupceri.expense_tracker_backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yakupceri.expense_tracker_backend.domain.Expense;
import com.yakupceri.expense_tracker_backend.service.ExpenseService;

import dto.ExpenseDTO;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*")

public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @GetMapping //Tüm harcamaları listele: GET http://localhost:8080/api/expenses
    public List<ExpenseDTO> getAllExpenses() { //komutu ile servisi tetikler, veritabanındaki tüm harcamaları çeker ve ekrana JSON olarak fırlatır.
        return expenseService.getAllExpenses();
    }

    @PostMapping //Yeni harcama ekle: POST http://localhost:8080/api/expenses
    public ResponseEntity<ExpenseDTO> createExpense(@Valid @RequestBody ExpenseDTO expenseDTO) {
        ExpenseDTO createdExpense = expenseService.saveExpense(expenseDTO);
        return ResponseEntity.ok(createdExpense);
    }

    // Harcama sil: DELETE http://localhost:8080/api/expenses/{id}
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
    }
}
