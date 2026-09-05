package com.yakupceri.expense_tracker_backend.dto;

import jakarta.validation.constraints.NotBlank;

public class ExpenseDTO {
    private Long id;

    @NotBlank(message = "Harcama Başlığı boş olamaz!")
    private String title;


}
