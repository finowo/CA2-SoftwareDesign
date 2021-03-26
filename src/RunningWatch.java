package com.company;

public class RunningWatch extends Product{

    private String os;
    private double batteryLife;
    private double profit;

    //i added the profit, battery life, and OS as parameters
    //these are passed to the superclass constructor
    public RunningWatch(int id, String n, double p, String b, String os, double batteryLife, double profit){
        super(id, n, p, b);
        this.os = os;
        this.batteryLife = batteryLife;
        this.profit = profit;
    }

    @Override
    public void printDetailedReport() {

    }

    @Override
    public void printSummary() {

    }

    @Override
    public double calcProfit() {
        //this method takes the profit margin and multiplies it by the price to find the profit.
        //FIX THIS LATER FIN
        return profit;
    }

    public String getOs() {
        return os;
    }

    public void setOS(String os) {
        this.os = os;
    }

    public double getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(double batteryLife) {
        this.batteryLife = batteryLife;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return
                "\n\nRunning Watch " + super.toString() + "\nProfit : " + profit;
    }

}

