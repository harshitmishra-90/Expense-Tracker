package com.harshit.expense_tracker.Controller;

import com.harshit.expense_tracker.Service.ExpenseService;
import com.harshit.expense_tracker.dto.ExpenseReponse;
import com.harshit.expense_tracker.dto.ExpenseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ExpenseReponse addExpense(
            @RequestBody ExpenseRequest expenseRequest) {

        return expenseService.addExpense(expenseRequest);
    }

    @GetMapping("/{id}")
    public ExpenseReponse getExpenseById(
            @PathVariable int id) {

        return expenseService.getById(id);
    }

    @PutMapping("/{id}")
    public ExpenseReponse updateExpense(
            @PathVariable int id,
            @RequestBody ExpenseRequest expenseRequest) {

        return expenseService.updateExpense(id, expenseRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteExpense(
            @PathVariable int id) {

        return expenseService.deleteExpense(id);
    }
}