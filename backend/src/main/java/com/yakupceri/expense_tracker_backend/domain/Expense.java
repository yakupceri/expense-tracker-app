package com.yakupceri.expense_tracker_backend.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Table(name = "expenses")
@Data 

public class Expense {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Double amount;
    private String category;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY) //Çok sayıda harcama, tek bir kullanıcıya ait olabilir
    @JoinColumn(name = "user_id", nullable = false) //expenses tablosuna user_id adında bir sütun ekler ve hangi harcamanın hangi kullanıcıya ait olduğunu bu sütun üzerinden birbirine bağlar.
    private User user;
}
