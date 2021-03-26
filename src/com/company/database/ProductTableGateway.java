package com.company.database;

import com.company.Product;
import com.company.Runner;
import com.company.RunningWatch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductTableGateway {
    //Define all fields in the table
    private static final String TABLE_NAME = "product";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_BRAND = "brand";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_PROFIT = "profit";
    private static final String COLUMN_WAREHOUSE_ID = "warehouseId";


    //ask about this im kinda confused
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_HEAL_TOE_OFFSET = "healToeOffset";
    private static final String COLUMN_WEIGHT = "weight";
    private static final String COLUMN_OS = "OS";
    private static final String COLUMN_BATTERY_LIFE = "batteryLife";


    private Connection mConnection;

    public SoftwareStaffTableGateway(Connection connection) {
        mConnection = connection;
    }

    public List<Product> getProduct()  {
        //the SQL query to execute
        String query;
        //the java.sql.Statement object used to execute the SQL query
        Statement stmt;
        //the java.sql.ResultSet representing the result of SQL query
        ResultSet rs;
        //the java.util.List containing the Programmer objects created for each row
        List<product> productList;

        String name, brand, price, OS,;
        int id, warehouseId;
        double weight, profit, batteryLife, healToeOffset;

        Product product;

        query = "SELECT * FROM " + TABLE_NAME ;

        productList = new ArrayList<Product>();

        try {
            stmt = this.mConnection.createStatement();
            rs = stmt.executeQuery(query);

            //iterate through the result set
            while (rs.next()) {

                id = rs.getInt(COLUMN_ID);
                name = rs.getString(COLUMN_NAME);
                brand = rs.getString(COLUMN_BRAND);
                price = rs.getDouble(COLUMN_PRICE);
                profit = rs.getDouble(COLUMN_PROFIT);
                warehouseId = rs.getInt(COLUMN_WAREHOUSE_ID);

                if (rs.getString(COLUMN_TYPE).equals("runner"))
                {
                    weight = rs.getString(COLUMN_WEIGHT);
                    healToeOffset = rs.getDouble(COLUMN_HEAL_TOE_OFFSET);
                    productList.add(new Runner(id, name, brand, healToeOffset, weight, profit, warehouseId));
                }
                else
                {
                    os = rs.getString(COLUMN_OS);
                    batteryLife = rs.getDouble(COLUMN_BATTERY_LIFE);
                    productList.add(new runningWatch(id, name, price, brand, os, batteryLife, profit, warehouseIdId));
                }
            }
        }
        catch(SQLException ex){
            System.out.println("ProductTableGateway Line 56: " + ex);
        }
        return productList;
    }

    public boolean editProduct(int id, double price)  {

        String query;
        PreparedStatement stmt;
        int numRowsAffected;

        query = "UPDATE " + TABLE_NAME + " SET " + COLUMN_PRICE + " = " + price + " WHERE " + COLUMN_ID + "= ?";

        try {
            stmt = mConnection.prepareStatement(query);
            stmt.setInt(1, id);
            System.out.println("\n\nTHE SQL LOOKS LIKE THIS " + stmt.toString() + "\n\n");
            numRowsAffected = stmt.executeUpdate();
            if (numRowsAffected == 1) {
                return true;
            }
        }
        catch (SQLException e)
        {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "SQL Exception in productTableGateway : editProduct(), Check the SQL you have created to see where your error is", e);
        }
        return false;
    }

    public boolean deleteProduct(int id)    {
        int numRowsAffected;
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + "= ?";
        try {
            PreparedStatement stmt;
            stmt = mConnection.prepareStatement(query);
            stmt.setInt(1, id);
            System.out.println("\n\nTHE SQL LOOKS LIKE THIS " + stmt.toString() + "\n\n");
            numRowsAffected = stmt.executeUpdate();
            if (numRowsAffected == 1) {
                return true;
            }
        }
        catch (SQLException e)
        {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "SQL Exception in productTableGateway : deleteProduct(), Check the SQL you have created to see where your error is", e);
        }
        return false;
    }

}
