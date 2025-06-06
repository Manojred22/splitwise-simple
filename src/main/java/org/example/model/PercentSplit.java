package org.example.model;

public class PercentSplit extends Split {
    private double percent;

    public PercentSplit(User user, Double percent){
        super(user);
        this.percent = percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getPercent(){
        return percent;
    }
}
