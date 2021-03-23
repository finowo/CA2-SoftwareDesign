package com.company;

import com.company.utils.Input;
import com.mysql.cj.log.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Model model;
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        //keyboard = new Scanner(System.in);
        model = Model.getInstance();
        int opt;

        /*****Display Menu*****/

        do {
            System.out.println("\n*********** MENU ************");

            System.out.println("1. Create a Product");
            System.out.println("2. Read all Products");
            System.out.println("3. Update a Product");
            System.out.println("4. Delete a Product");

            System.out.println("5. View Warehouse by Id");
            System.out.println("6. View all Warehouses");
            System.out.println("7. Create new Warehouse");
            System.out.println("8. Assign Product to existing Warehouse");


            System.out.println("9. Exit");
            System.out.println("*********** Cya! ************");
            System.out.println();

            System.out.print("Enter option: ");
            String line = keyboard.nextLine();
            opt = Integer.parseInt(line);

            /*****Deciding Which Option The User Chooses *****/

            switch (opt) {

                case 1: {
                    createProduct();
                    break;
                }

                case 2: {
                    viewProduct();
                    break;
                }

                case 3: {
                    break;
                }

                case 4: {
                    break;
                }

                case 5: {
                    viewWarehousebyId();
                    break;
                }
                case 6: {
                    //viewAllManagers();
                    //break;
                }
                case 7: {
                    createNewWarehouse();
                    break;
                }

                case 8: {
                    System.out.println("Not implemented yet.");
                    break;
                }

            }
        }
        while (opt != 9);
        System.out.println("Cya! o/");
    }

    //Creates either a RunningWatch or Runner
    private static void createProduct() {
        Product Product = null;

        System.out.println("\nWhat do you want to create?");
        System.out.println("1. Runner");
        System.out.println("2. Running Watch");

        int choice = Integer.parseInt(keyboard.nextLine());

        switch (choice){
            case 1:
            {
                product = Input.readProduct();
                int generatedId = model.createProduct(product);
                System.out.println("Product created with ID "+ generatedId);
                break;
            }
            case 2:
            {
                //Do something similar for second subclass
                break;
            }


        }
        model.createProduct(product);
    }

    private static void createNewWarehouse() {
        Warehouse w = Input.readWarehouse();

        if (model.createWarehouse(w))
            System.out.println("Success: Warehouse Added to the DataBase");
        else
            System.out.println("Oopsie Poopsie Something went Wrong :(");
    }

    private static void viewWarehousebyId() {
        System.out.println("Enter the ID for the Warehouse");
        int id = keyboard.nextInt();
        Warehouse w = null;
        //consume the new line that will come after typing in the ID integer
        keyboard.nextLine();

        System.out.println("Do you also want to view the product for that Warehouse? (y/n)");
        if (keyboard.nextLine().equalsIgnoreCase("y"))
            w = model.viewWarehouse(id);
        else
            System.out.println("Can you write the code that just gets manager with ID but no staff");

        //if you choose n, this print statement will try print a null pointer
        System.out.println("************ PRINTING MANAGER DETAILS ************\n\n" + w.toString());
    }


    private static void viewProduct() {
        List<Product> productList = model.viewProduct();
        for (Product Product : ProductList) {
            System.out.println("Name: " + Product.toString());
        }
    }
}
