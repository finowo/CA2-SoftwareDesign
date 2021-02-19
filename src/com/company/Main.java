package com.company;

public class Main {

    public static void main(String[] args) {

        runner r1 = new runner("AirMax", 69.99, "Adidas", 24.6, 344, 15);
        r1.printDetailedReport();
        r1.printSummary();



        //call the get methods and print
        System.out.println("\n\n********* Printing each instance variable by calling it's get method *********");
        //note, you can call the superclass get method even though r1 is a Programmer
        System.out.println("ID is " + r1.getId());
        System.out.println("Name is " + r1.getName());
        //call the runner get methods
        System.out.println("Heal-Toe-Offset is " + r1.getHealToeOffset());
        System.out.println("Profit is " + r1.calcProfit());


        //getting the string from toString() - print the string that is returned from runner toString()
        System.out.println("\n********* Printing with toString() *********");
        System.out.println(r1.toString());

        runningWatch w1 = new runningWatch(-1,"Versa 3", 129.99, "Fitbit", "FitOS", 25, 35);
        //call the get methods and print.
        System.out.println("\n\n********* Printing each instance variable by calling it's get method *********");
        //note, you can call the superclass get method even though h1 is a sub class
        System.out.println("ID is " + w1.getId());
        System.out.println("Name is " + w1.getName());
        //call the watch get methods
        System.out.println("Battery Life in days is " + w1.getBatteryLife());

        System.out.println("Operating System is " + w1.getOs());

        //getting the string from toString() - print the string that is returned from runner toString()
        System.out.println("\n********* Printing with toString() *********");
        System.out.println(w1.toString());

    }
}
