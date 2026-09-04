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

    public List<Expense> getAllExpenses(){ //SQL Server'daki tablodan bütün kayıtları çeker ve Java'nın liste formatına (List) çevirip geri verir.
        return ExpenseRepository.findAll(); 
    }

    public Expense savExpense(Expense expense) { //Dışarıdan yeni bir harcama verisi geldiğinde bu metot devreye girer. İçindeki expenseRepository.save(expense) komutu gelen veriyi alır ve SQL Server'daki tablomuza yeni satır olarak kaydeder.
        return ExpenseRepository.save(expense);
    }

    public Expense saveExpense(Expense expense) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveExpense'");
    }
}
