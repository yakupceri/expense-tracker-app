package com.yakupceri.expense_tracker_backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yakupceri.expense_tracker_backend.domain.Expense;
import com.yakupceri.expense_tracker_backend.repository.ExpenseRepository;

import dto.ExpenseDTO;

@Service 
public class ExpenseService {

    private final ExpenseRepository ExpenseRepository;

    ExpenseService(ExpenseRepository ExpenseRepository) {
        this.ExpenseRepository = ExpenseRepository;
    }

// Tüm harcamaları getir (Web sitesindeki liste tablosu için)
public List<ExpenseDTO> getAllExpenses() {
    return ExpenseRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
}

public ExpenseDTO convertToDTO(Expense expense) {
    ExpenseDTO dto = new ExpenseDTO();
    dto.setId(expense.getId());
    dto.setTitle(expense.getTitle());
    dto.setAmount(expense.getAmount());
    dto.setCategory(expense.getCategory());
    dto.setDate(expense.getDate());
    return dto;
}

private Expense convertToEntity(ExpenseDTO dto) {
        Expense expense = new Expense();
        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setCategory(dto.getCategory());
        expense.setDate(dto.getDate());
        return expense;
}

  // Yeni harcama kaydet (DTO alıp Entity'ye çevirir, kaydeder ve DTO döner)
    public ExpenseDTO saveExpense(ExpenseDTO expenseDTO) { 
        //Dışarıdan gelen DTO'yu Entity'ye çeviriyoruz (convertToEntity burada çalışıyor!)
        Expense expense = convertToEntity(expenseDTO);

        //veritabanına kaydediyoruz
        Expense savedExpense = ExpenseRepository.save(expense);
        
        // Kaydedilen harcamayı DTO'ya çevirip döndürüyoruz  
        return convertToDTO(savedExpense); 
        }

    // Harcama sil (Web sitesindeki sil butonu için)
    public void deleteExpense(Long id) {
        ExpenseRepository.deleteById(id);
    }
}
