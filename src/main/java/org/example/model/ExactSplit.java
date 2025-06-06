package org.example.model;

public class ExactSplit extends Split{
    protected User user;
    public ExactSplit(User user, double amount){
        super(user);
        this.amount = amount;
    }
}
