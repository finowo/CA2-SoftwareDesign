package com.company;

public class RunningWatch extends Product {

    private String os;
    private double batteryLife;
    private double profit;

    //i added the profit, battery life, and OS as parameters
    //these are passed to the superclass constructor
    public RunningWatch(String n, double p, String b, String os, double batteryLife, double profit, int wId){
        super(-1, n, p, b, wId);
        this.os = os;
        this.batteryLife = batteryLife;
        this.profit = profit;
    }

    public RunningWatch(int id, String n, double p, String b, String os, double batteryLife, double profit){
        super(id, n, p, b);
        this.os = os;
        this.batteryLife = batteryLife;
        this.profit = profit;
    }

    public RunningWatch(int id, String n, double p, String b, String os, double batteryLife, double profit, int warehouseId){
        super(id, n, p, b, warehouseId);
        this.os = os;
        this.batteryLife = batteryLife;
        this.profit = profit;
    }

    public RunningWatch() {
        super();
    }


    @Override
    public void printDetailedReport() {
        System.out.println("********** DETAILED WATCH REPORT **********");
        System.out.println("Watch ID: " + super.getId());
        System.out.println("Watch Name: " + super.getName());
        System.out.println("Watch Price: " + super.getPrice());
        System.out.println("Watch OS: " + os);
        System.out.println("Watch Battery Life: " + batteryLife);
        System.out.println("Watch Profit: " + profit);
        System.out.println("**************************************");

    }

    @Override
    public void printSummary() {
        System.out.println("********** WATCH SUMMARY **********");
        System.out.println("Watch ID: " + super.getId());
        System.out.println("Watch Name: " + super.getName());
        System.out.println("Watch Price: " + super.getPrice());
        System.out.println("**************************************");
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

    public double getBatteryLife() { return batteryLife; }

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
        return "\n******* Watch *******" + '\n'
                + super.toString() +
                "OS = " + os + '\n' +
                "Battery Life = " + batteryLife + '\n' +
                "Profit = " + profit + '\n';
    }

}

