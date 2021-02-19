package com.company;


//runner "is-a" product
//runner inherits id, name, price, and brand from product
public class runner extends Product{
    private double healToeOffset;
    private double weight;
    private double profit;


    public runner(String n, double p, String b, double healToeOffset, double weight, double profit) {
        //calling the superclass constructor; product
        //this constructor expects id, name, price, and brand
        //we don't have an id yet we pass in -1
        super(-1, n, p, b);
        this.healToeOffset = healToeOffset;
        this.weight = weight;
        this.profit = profit;
    }

    public runner(int id, String n, double p, String b, double healToeOffset, double weight, double profit) {
        super(id, n, p, b);
        this.healToeOffset = healToeOffset;
        this.weight = weight;
        this.profit = profit;

        //call to superclass constructor must be the first line in subclass constructor
        //super(id, n, p, b); don't have to call to the super class after the other assignments

    }

    public runner(int id, String n, double p, String b) {
        super(id, n, p, b);
    }


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
        return super.toString() + "\nHeal-Toe-Offset " + healToeOffset + "\nWeight " +  weight;
    }


}
