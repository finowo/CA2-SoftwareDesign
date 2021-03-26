package com.company;

import com.company.Model;
import com.company.Product;
import com.company.Warehouse;
import com.company.utils.Input;

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
            System.out.println("*********** MENU ************");
            System.out.println();

            System.out.print("Enter option: ");
            String line = keyboard.nextLine();
            System.out.println(line);
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
                    editProduct();
                    break;
                }

                case 4: {
                    deleteProduct();
                    break;
                }

                case 5: {
                    viewWarehouseById();
                    break;
                }
                case 6: {
                    viewWarehouse();
                    break;
                }
                case 7: {
                    createNewWarehouse();
                    break;
                }

                case 8: {
//                    System.out.println("idfk how im supposed to do this");
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

                Product = Input.readRunner();
                int generatedId = model.createProduct(Product);
                System.out.println("Product created with ID "+ generatedId);
                break;
            }
            case 2:
            {
                Product = Input.readRunningWatch();
                int generatedId = model.createProduct(Product);
                System.out.println("Product created with ID "+ generatedId);
                break;
            }


        }
    }


    private static void editProduct() {
        System.out.print("Enter the ID of the Product to update:");
        int id = Integer.parseInt(keyboard.nextLine());
        System.out.print("Enter the new price of the product:");
        int price = Integer.parseInt(keyboard.nextLine());
        if (model.editProduct(id, price)) {
            System.out.println("\nProduct updated: Please note, that this only changes the price at the moment.");
        }
        else {
            System.out.println("\nProduct not updated, check your database to see if a Product with this ID actually exists");
        }
    }

    private static void deleteProduct() {
        System.out.print("Enter the ID of the Product to delete:");
        int id = Integer.parseInt(keyboard.nextLine());
        if (model.deleteProduct(id)) {
            System.out.println("\nProduct deleted");
        }
        else {
            System.out.println("\nProduct not deleted, check your database to see if a Product with this ID actually exists");
        }
    }

    private static void createNewWarehouse() {
        Warehouse w = Input.readWarehouse();

        if (model.createWarehouse(w))
            System.out.println("Success: Warehouse Added to the DataBase");
        else
            System.out.println("Oopsie Poopsie Something went Wrong :(");
    }

    private static void viewWarehouseById() {
        System.out.println("Enter the ID for the Warehouse");
        int id = keyboard.nextInt();
        Warehouse w = null;
        //consume the new line that will come after typing in the ID integer
        keyboard.nextLine();

        System.out.println("Do you also want to view the product for that Warehouse? (y/n)");
        if (keyboard.nextLine().equalsIgnoreCase("y")){
            w = model.viewWarehouseWithProducts(id);
        } else{
            System.out.println("Can you write the code that just gets manager with ID but no staff");
        //if you choose n, this print statement will try print a null pointer
        System.out.println("************ PRINTING MANAGER DETAILS ************\n\n" + w.toString());
        }
    }

    private static void viewProduct() {
        List<Product> productList = model.viewProduct();
        for (Product product : productList) {
            System.out.println("Name: " + product.toString());
        }
    }

    private static void viewWarehouse() {
        System.out.println("Enter the ID for the Warehouse");
        int b = keyboard.nextInt();
        Warehouse w = model.viewWarehouse(b);
        System.out.println("Name: " + w.toString());
        keyboard.nextLine();
    }
}
