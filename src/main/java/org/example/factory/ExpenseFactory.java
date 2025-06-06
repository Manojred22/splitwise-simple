package org.example.factory;

import org.example.model.*;

import java.util.List;

public class ExpenseFactory {

    public static Expense  createExpense(User paidBy, double amount, ExpenseType expenseType, List<Split> splits){
        switch (expenseType){
            case EQUAL:
                int n = splits.size();
                double splitAmount = ((amount/n)*100)/100;
                for(Split split: splits){
                    split.setAmount(splitAmount);
                }
                break;

            case EXACT:
                double total = 0;
                for(Split split: splits){
                    total += split.getAmount();
                }
                if(total != amount){
                    throw new IllegalArgumentException(" Exact split amount doesnt match total amount ");
                }
                break;

            case PERCENT:
                for(Split split: splits){
                    if(!(split instanceof PercentSplit percentSplit)){
                        throw new IllegalArgumentException("Invalid split for Percentage");
                    }
                    split.setAmount((amount*percentSplit.getPercent())/100);
                }
                break;

            default:
                throw new IllegalArgumentException("Unsupported Expense Type");
        }

        return new Expense(paidBy,amount,expenseType,splits);
    }
}
