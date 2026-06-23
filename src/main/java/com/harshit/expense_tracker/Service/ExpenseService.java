package com.harshit.expense_tracker.Service;


import com.harshit.expense_tracker.Model.Expense;
import com.harshit.expense_tracker.Respository.ExpenseRepository;
import com.harshit.expense_tracker.dto.ExpenseReponse;
import com.harshit.expense_tracker.dto.ExpenseRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
@Autowired
    private ExpenseRepository expenseRepository;
@Autowired
private ModelMapper modelMapper;

    public ExpenseReponse addExpense(ExpenseRequest expenseRequest)
    {
//        Expense expense=new Expense();
//        expense.setAmount(expenseRequest.getAmount());
//        expense.setExpenseDate(expenseRequest.getExpenseDate());
//        expense.setTitle(expenseRequest.getTitle());
//        expense.setCategory(expense.getCategory());
//        expenseRepository.save(expense);
        //convert expneseRequest object to book entity
      Expense expense=  modelMapper.map(expenseRequest,Expense.class);
      // call the method of repo to save the entity


          Expense savedExpense= expenseRepository.save(expense);
          return modelMapper.map(savedExpense,ExpenseReponse.class);
    }
    public ExpenseReponse updateExpense(
            int id,
            ExpenseRequest request) {

        Expense expense =
                expenseRepository.findById(id)
                        .orElseThrow(
                                () ->
                                        new RuntimeException(
                                                "Expense not found"));

        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDescription(
                request.getDescription());
        expense.setExpenseDate(
                request.getExpenseDate());

        Expense updatedExpense =
                expenseRepository.save(expense);

        return modelMapper.map(
                updatedExpense,
                ExpenseReponse.class);
    }

    public ExpenseReponse getById(int id)
    {

        Expense expense =
                expenseRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Expense not found"));
        return modelMapper.map(expense,ExpenseReponse.class);
    }

    public String deleteExpense(int id )
    {

        Expense expense =
                expenseRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Expense not found"));
        expenseRepository.delete(expense);
        return "deleted";
    }
}
