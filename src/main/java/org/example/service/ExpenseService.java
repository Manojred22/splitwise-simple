package org.example.service;

import org.example.factory.ExpenseFactory;
import org.example.model.Expense;
import org.example.model.ExpenseType;
import org.example.model.Split;
import org.example.model.User;

import java.util.List;

public class ExpenseService {
    private final BalanceService balanceService;

    public ExpenseService(BalanceService balanceService){
        this.balanceService = balanceService;
    }

    public void addExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits){
        Expense expense = ExpenseFactory.createExpense(paidBy,amount,expenseType,splits);

        for(Split split: splits){
            if(!split.getUser().equals(paidBy)){
                balanceService.addBalance(split.getUser(),paidBy, split.getAmount());
            }
        }
    }

}
