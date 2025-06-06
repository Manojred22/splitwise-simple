package org.example.model;

import java.util.List;

public class Expense {
    protected User paidBy;
    protected double totalAmount;
    protected ExpenseType expenseType;
    protected List<Split> splitList;

    public Expense(User paidBy, double totalAmount, ExpenseType expenseType, List<Split> splitList){
        this.paidBy = paidBy;
        this.totalAmount = totalAmount;
        this.expenseType = expenseType;
        this.splitList = splitList;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

    public User getPaidBy() {
        return paidBy;
    }
}
