package com.company.utils;

import java.util.Scanner;

import com.company.RunningWatch;
import com.company.Warehouse;
import com.company.Runner;

/**** @author finowo ****/

public class Input {

    //Called to read in a new runner when Create runner is chosen by user
    public static Runner readRunner() {

        String name, brand;
        double price, healToeOffset, weight, profit;
        int wId;

        Scanner keyboard = new Scanner(System.in);

        // ask the user for all the programmer data except the ID - ID is automatically
        // created in the database when you are creating something for the first time
        System.out.print("Enter name: ");
        name = keyboard.nextLine();

        System.out.print("Enter brand: ");
        brand = keyboard.nextLine();

        System.out.print("Enter price: ");
        price = keyboard.nextDouble();

        System.out.print("Enter heal toe offset: ");
        healToeOffset = keyboard.nextDouble();

        System.out.print("Enter weight: ");
        weight = keyboard.nextDouble();

        System.out.print("Enter profit: ");
        profit = keyboard.nextDouble();
        keyboard.nextLine();

        //Asking for the warehouse ID - this needs to exist in the db
        System.out.print("Enter Warehouse ID : ");
        wId = keyboard.nextInt();
        keyboard.nextLine();

        // Create the Runner object r
        Runner r =
                new Runner(name, price, brand, healToeOffset, weight, profit, wId);
        return r;
    }

    public static RunningWatch readRunningWatch() {

        String name, brand, os;
        double price, batteryLife, profit;
        int wId;

        Scanner keyboard = new Scanner(System.in);

        // ask the user for all the programmer data except the ID - ID is automatically
        // created in the database when you are creating something for the first time
        System.out.print("Enter name: ");
        name = keyboard.nextLine();

        System.out.print("Enter brand: ");
        brand = keyboard.nextLine();

        System.out.print("Enter price: ");
        price = keyboard.nextDouble();

        System.out.print("Enter operating system: ");
        os = keyboard.nextLine();

        keyboard.nextLine();
        System.out.print("Enter battery life: ");
        batteryLife = keyboard.nextDouble();

        System.out.print("Enter profit: ");
        profit = keyboard.nextDouble();
        keyboard.nextLine();

        //Asking for the warehouse ID - this needs to exist in the db
        System.out.print("Enter Warehouse ID : ");
        wId = keyboard.nextInt();
        keyboard.nextLine();


        // Create the Running watch object r
        RunningWatch rw =
                new RunningWatch(name, price, brand, os, batteryLife, profit, wId);
        return rw;
    }

    public static Warehouse readWarehouse() {
        String location;
        int orderNumber;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter warehouse location: ");
        location = keyboard.nextLine();

        System.out.println("Enter warehouse order number: ");
        orderNumber = keyboard.nextInt();
        keyboard.nextLine();

        return (new Warehouse(location, orderNumber));
    }
}

