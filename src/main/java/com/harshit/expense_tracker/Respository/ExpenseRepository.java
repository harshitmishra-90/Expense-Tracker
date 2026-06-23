package com.harshit.expense_tracker.Respository;

import com.harshit.expense_tracker.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Integer> {

}
