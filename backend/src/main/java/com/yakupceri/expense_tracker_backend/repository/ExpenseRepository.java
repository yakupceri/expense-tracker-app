package com.yakupceri.expense_tracker_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yakupceri.expense_tracker_backend.domain.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
