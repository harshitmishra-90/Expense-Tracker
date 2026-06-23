package com.harshit.expense_tracker.dto;

import com.harshit.expense_tracker.Model.User;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@NoArgsConstructor
@Data
public class ExpenseRequest {
 
    private String title;
    private int amount;
    private String category;
    private String description;
    private LocalDate expenseDate;

}
