package dto;

import java.time.LocalDate;

import com.yakupceri.expense_tracker_backend.domain.Expense;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data 
public class ExpenseDTO {
    private Long id;

    @NotBlank(message = "Harcama başlığı boş olamaz!")
    private String title;

    @NotNull(message = "Tutar alanı boş olamaz!")
    @Positive(message = "Tutar sıfırdan büyük olmalıdır!") //Girilen Tutar 0 dan büyük olmalıdır.
    private Double amount;

    @NotBlank (message = "Kategori alanı boş olamaz!")
    private String category;

    @NotNull (message = "Tarih alanı boş olamaz!")
    private LocalDate date;

}

