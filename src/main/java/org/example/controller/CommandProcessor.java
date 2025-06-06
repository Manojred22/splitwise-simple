package org.example.controller;

import org.example.model.*;
import org.example.service.BalanceService;
import org.example.service.ExpenseService;

import java.util.*;

public class CommandProcessor {
    private final Map<String, User> users = new HashMap<>();
    private final BalanceService balanceService = new BalanceService();
    private final ExpenseService expenseService = new ExpenseService(balanceService);

    public void addUser(User user){
        users.put(user.getId(),user);
    }

    public void processCommand(String command){
        String[] tokens = command.split(" ");
        if(tokens[0].equals("SHOW")){
            if(tokens.length ==1){
                balanceService.showAllBalances();
            }else{
                balanceService.showBalances(tokens[1]);
            }

        } else if (tokens[0].equals("EXPENSE")) {
            String paidByID = tokens[1];
            double amount = Double.parseDouble(tokens[2]);
            int numUsers = Integer.parseInt(tokens[3]);

            List<Split> splits = new ArrayList<>();
            ExpenseType expenseType = ExpenseType.valueOf(tokens[4+numUsers].toUpperCase());

            for(int i=0;i<numUsers;i++){
                String toUserId = tokens[4+i];
                User user = users.get(toUserId);
                switch (expenseType){
                    case EQUAL:
                        splits.add(new EqualSplit(user));
                        break;

                    case EXACT:
                        double exactAmount = Double.parseDouble(tokens[5+numUsers+i]);
                        splits.add(new ExactSplit(user, exactAmount));
                        break;

                    case PERCENT:
                        double percent = Double.parseDouble(tokens[5+numUsers+i]);
                        splits.add(new PercentSplit(user, percent));
                        break;

                }

            }
            expenseService.addExpense(expenseType,amount,users.get(paidByID),splits);

        }
    }


}
