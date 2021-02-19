package com.company;

//superclass - sub-classes will inherit id, name, price and the brand name of the object
//product class - superclass that has common information for all products
//product cannot be instantiated as it is abstract

public abstract class Product implements Reports {

    private int id;
    private String name;
    private double price;
    private String brand;


    public Product(int id, String n, double p, String b) {
        this.id = id;
        this.name = n;
        this.price = p;
        this.brand = b;

    }


    //defining the calcProfit method - this will force any subclass to implement it
    public abstract double calcProfit();

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    @Override
    //this method will return the brand name and the product name of the specific item
    //this @override always returns a string
    public String toString()
    {
        return "Name : " + getBrand() + getName();
    }


}
