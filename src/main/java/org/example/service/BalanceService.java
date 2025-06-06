package org.example.service;

import org.example.model.User;

import java.util.HashMap;
import java.util.Map;

public class BalanceService {
    private final Map<String, Map<String, Double>> balanceSheet = new HashMap<>();

    public void addBalance(User from, User to, double amount){
        updateBalance(from, to, amount);
        updateBalance(to,from,-amount);
    }

    public void updateBalance(User from, User to, double amount){
        balanceSheet.putIfAbsent(from.getId(), new HashMap<>());
        Map<String, Double> map = balanceSheet.get(from.getId());
        map.put(to.getId(), map.getOrDefault(to.getId(),0.0) + amount);
    }

    public void showBalances(String userID){
        boolean hasBalance = false;
        if(balanceSheet.containsKey(userID)){
            for(Map.Entry<String, Double> entry: balanceSheet.get(userID).entrySet()){
                if (entry.getValue()>0){
                    hasBalance = true;
                    System.out.println(userID + " owes " + entry.getKey() + " : " + String.format("%.2f", entry.getValue()));
                }
            }
        }
        if(!hasBalance){
            System.out.println("No balances");
        }
    }

    public void showAllBalances(){
        boolean hasAny = false;
        for(String userId: balanceSheet.keySet()){
            for(Map.Entry<String, Double> entry : balanceSheet.get(userId).entrySet()){
                if(entry.getValue()>0){
                    hasAny=true;
                    System.out.println(userId + " owes " + entry.getKey() + " : " + String.format("%.2f", entry.getValue()));
                }
            }
        }
        if(!hasAny){
            System.out.println("No balances");
        }
    }
}
