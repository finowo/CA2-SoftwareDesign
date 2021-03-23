package com.company;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private int warehouseId;
    private String location;
    private int orderNumber;

    private List<Product> productList;

    public Warehouse(String location, int orderNumber){
        this.location = location;
        this.orderNumber = orderNumber;
    }

    public Warehouse(int id, String location, int orderNumber){
        this.warehouseId = id ;
        this.location = location;
        this.orderNumber = orderNumber;

        productList = new ArrayList();
    }

    public void addProductToWarehouse(Product p){productList.add(p);}

    public void removeProductToWarehouse(Product p){productList.remove(p);}

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List <Product> getProductList() { return productList; }

    public void  setProductList(List <Product> productList){
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Warehouse Details " +
                "Warehouse Id : " + warehouseId +
                ", Location : '" + location + '\'' +
                ", Order Number : " + orderNumber +
                "\n LIST OF PRODUCTS "
                + productList +
                '}';
    }

}
