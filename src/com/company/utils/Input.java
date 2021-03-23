package com.company.utils;

import java.util.Scanner;

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
        email = keyboard.nextLine();

        System.out.print("Enter price: ");
        mobile = keyboard.nextLine();

        System.out.print("Enter heal toe offset: ");
        skills = keyboard.nextLine();

        System.out.print("Enter weight: ");
        skills = keyboard.nextLine();

        System.out.print("Enter profit: ");
        skills = keyboard.nextLine();
        keyboard.nextLine();

        //Asking for the warehouse ID - this needs to exist in the db
        System.out.print("Enter Warehouse ID : ");
        mId = keyboard.nextInt();
        keyboard.nextLine();


        // Create the Runner object r
        Runner r =
                new Runner(name, brand, price, healToeOffset, weight, profit, wId);
        return r;
    }

    public static Warehouse readWarehouse() {
        String location;
        int orderNumber;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter warehouse location: ");
        name = keyboard.nextLine();

        System.out.println("Enter warehouse order number: ");
        office = keyboard.nextInt();
        keyboard.nextLine();

        return (new Warehouse(location, orderNumber));
    }
}

