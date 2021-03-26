package com.company;

//runner "is-a" product
//runner inherits id, name, price, and brand from product
public class Runner extends Product {
    private double healToeOffset;
    private double weight;
    private double profit;


    public Runner(String n, double p, String b, double healToeOffset, double weight, double profit, int wId) {
        super(-1, n, p, b, wId);
        this.healToeOffset = healToeOffset;
        this.weight = weight;
        this.profit = profit;
    }

    public Runner(int id, String n, double p, String b, double healToeOffset, double weight, double profit) {
        super(id, n, p, b);
        this.healToeOffset = healToeOffset;
        this.weight = weight;
        this.profit = profit;
    }

    public Runner(int id, String n, double p, String b, double healToeOffset, double weight, double profit, int warehouseId) {
        super(id, n, p, b, warehouseId);
        this.healToeOffset = healToeOffset;
        this.weight = weight;
        this.profit = profit;
    }

    public Runner() { super(); }

    @Override
    public void printDetailedReport() {
        System.out.println("********** DETAILED RUNNER REPORT **********");
        System.out.println("Runner ID : " + super.getId());
        System.out.println("Runner Name : " + super.getName());
        System.out.println("Runner Price : " + super.getPrice());
        System.out.println("Runner Brand : " + super.getBrand());
        System.out.println("Heal-Toe-Offset : " + healToeOffset);
        System.out.println("Weight : " + weight);
        System.out.println("Profit : " + calcProfit());
        System.out.println("********************************************");
    }

    @Override
    public void printSummary() {
        System.out.println("*************** SUMMARY ***************");
        System.out.println("Runner ID : " + super.getId());
        System.out.println("Runner Brand : " + super.getBrand());
        System.out.println("Profit : " + calcProfit());
        System.out.println("***************************************");
    }


    @Override
    public double calcProfit() {
        //here i will just use a profit that im passing in
        //FIX THIS LATER FIN
        return profit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHealToeOffset() {
        return healToeOffset;
    }

    public void setHealToeOffset(double healToeOffset) {
        this.healToeOffset = healToeOffset;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Override
    public String toString()
    {
        //super.toString() calls the superclass' toString method()
        //this returns a string for the product instance variables
        //then the whole string is returned to the calling program
        return  "\n *******Runner*******" + '\n' + super.toString() + "\nHeal-Toe-Offset " + healToeOffset + "\nWeight " +  weight;
    }


}
