package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Product> productList = new ArrayList();

        Runner r1 = new Runner("AirMax", 69.99, "Adidas", 24.6, 344, 15);
        Runner r2 = new Runner("New Balance", 45.99, "NB", 32.3, 255, 7);
        Runner r3 = new Runner("Canvas Star", 129.99, "Converse", 27, 180, 30);
        Runner r4 = new Runner("SuperCool", 89.99, "Puma", 26.5, 153, 7.32);

        RunningWatch w1 = new RunningWatch(-1,"Versa 3", 129.99, "Fitbit", "FitOS", 25, 35);
        RunningWatch w2 = new RunningWatch(-1,"Versa 3", 129.99, "Fitbit", "FitOS", 25, 35);
        RunningWatch w3 = new RunningWatch(-1,"Versa 3", 129.99, "Fitbit", "FitOS", 25, 35);
        RunningWatch w4 = new RunningWatch(-1,"Versa 3", 129.99, "Fitbit", "FitOS", 25, 35);

        //adding runner and watch objects to the list of products
        productList.add(r1);
        productList.add(r2);
        productList.add(w1);
        productList.add(w2);

        Warehouse wh1 = new Warehouse(12, "Dublin", 37);
        wh1.setProductList(productList);

        wh1.addProductToWarehouse(r3);
        wh1.addProductToWarehouse(w3);

        System.out.println("************MANAGER DETAILS************");
        System.out.println(wh1.toString());

//        //calling the detailed summary
//        r1.printDetailedReport();
//        r1.printSummary();
//        //call the get methods and print
//        System.out.println("\n\n********* Printing each instance variable by calling it's get method *********");
//        //note, you can call the superclass get method even though r1 is a Programmer
//        System.out.println("ID is " + r1.getId());
//        System.out.println("Name is " + r1.getName());
//        //call the runner get methods
//        System.out.println("Heal-Toe-Offset is " + r1.getHealToeOffset());
//        System.out.println("Profit is " + r1.calcProfit());
//
//
//        //getting the string from toString() - print the string that is returned from runner toString()
//        System.out.println("\n********* Printing with toString() *********");
//        System.out.println(r1.toString());
//
//        //call the get methods and print.
//        System.out.println("\n\n********* Printing each instance variable by calling it's get method *********");
//        //note, you can call the superclass get method even though h1 is a sub class
//        System.out.println("ID is " + w1.getId());
//        System.out.println("Name is " + w1.getName());
//        //call the watch get methods
//        System.out.println("Battery Life in days is " + w1.getBatteryLife());
//        System.out.println("Operating System is " + w1.getOs());
//
//        //getting the string from toString() - print the string that is returned from runner toString()
//        System.out.println("\n********* Printing with toString() *********");
//        System.out.println(w1.toString());

    }
}
