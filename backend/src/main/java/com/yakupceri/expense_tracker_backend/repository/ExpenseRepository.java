package com.yakupceri.expense_tracker_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yakupceri.expense_tracker_backend.domain.Expense;

@Repository 
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
