package com.company.database;

import com.company.Product;
import com.company.Runner;
import com.company.Model;
import com.company.RunningWatch;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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

    public ProductTableGateway(Connection connection) {
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
        List<Product> productList;

        String name, brand, OS;
        int id, warehouseId;
        double weight, profit, batteryLife, healToeOffset, price;

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
                    weight = rs.getDouble(COLUMN_WEIGHT);
                    healToeOffset = rs.getDouble(COLUMN_HEAL_TOE_OFFSET);
                    productList.add(new Runner(id, name, price, brand, healToeOffset, weight, profit, warehouseId));
                }
                else
                {
                    OS = rs.getString(COLUMN_OS);
                    batteryLife = rs.getDouble(COLUMN_BATTERY_LIFE);
                    productList.add(new RunningWatch(id, name, price, brand, OS, batteryLife, profit, warehouseId));
                }
            }
        }
        catch(SQLException ex){
            System.out.println("ProductTableGateway Line 56: " + ex);
        }
        return productList;
    }

    public int addProduct(Product p)  {

        String query;
        PreparedStatement stmt;
        int numRowsAffected;
        int generatedId;

        query = "INSERT INTO " + TABLE_NAME + " (" +
                COLUMN_NAME + ", " +
                COLUMN_BRAND + ", " +
                COLUMN_PRICE + ", " +
                COLUMN_TYPE + ", " +
                COLUMN_HEAL_TOE_OFFSET + ", " +
                COLUMN_WEIGHT + ", " +
                COLUMN_OS + ", " +
                COLUMN_BATTERY_LIFE + ", " +
                COLUMN_PROFIT + ", " +
                COLUMN_WAREHOUSE_ID+
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            stmt = mConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getBrand());
            stmt.setDouble(3, p.getPrice());
            stmt.setDouble(9, p.getProfit());
            stmt.setDouble(10, p.getWarehouseID());

            if (p.getClass() == Runner.class) {
                Runner r1 = new Runner();
                r1 = (Runner) p;
                stmt.setString(4, "runner");
                stmt.setDouble(5, ((Runner) p).getHealToeOffset());
                stmt.setDouble(6, ((Runner) p).getWeight());
                stmt.setNull(7, 1);
                stmt.setNull(8, 1);
            }

            else if (p.getClass() == RunningWatch.class) {
                RunningWatch rw1 = new RunningWatch();
                rw1 = (RunningWatch) p;
                stmt.setString(4, "runningWatch");
                stmt.setString(7, ((RunningWatch) p).getOs());
                stmt.setDouble(8, ((RunningWatch) p).getBatteryLife());
                stmt.setNull(5, 1);
                stmt.setNull(6, 1);
            }

            System.out.println(stmt.toString());

            numRowsAffected = stmt.executeUpdate();


            if (numRowsAffected == 1) {
                    // if one row was inserted, retrieve the id that was assigned to that row in the database and ret
                    ResultSet keys = stmt.getGeneratedKeys();
                    keys.next();
                    generatedId = keys.getInt(1);
                    //dbProgrammer.setId(id);
                return generatedId;
            }

        }
        catch (SQLException e)
        {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "SQL Exception in productTableGateway : addProduct(), Check the SQL you have created to see where your error is", e);
        }
        return -1;
    }

    public List<Product> getProductByStoreId(int pid)  {
        //the SQL query to execute
        String query;
        //the java.sql.Statement object used to execute the SQL query
        Statement stmt;
        //the java.sql.ResultSet representing the result of SQL query
        ResultSet rs;
        //the java.util.List will contain the softwareStaff objects for the manager
        List<Product> productList;

        String name, brand, os, type;
        int id, warehouseID;
        double price, batteryLife, healToeOffset, weight, profit;



        query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_WAREHOUSE_ID + " = " + pid;

        productList = new ArrayList<Product>();

        try {
            stmt = this.mConnection.createStatement();
            rs = stmt.executeQuery(query);


            while (rs.next()) {

                id = rs.getInt(COLUMN_ID);
                name = rs.getString(COLUMN_NAME);
                brand = rs.getString(COLUMN_BRAND);
                price = rs.getDouble(COLUMN_PRICE);
                profit = rs.getDouble(COLUMN_PROFIT);
                warehouseID= rs.getInt(COLUMN_WAREHOUSE_ID);

                if (rs.getString(COLUMN_TYPE).equals("runner"))
                {
                    healToeOffset = rs.getDouble(COLUMN_HEAL_TOE_OFFSET);
                    weight  = rs.getDouble(COLUMN_WEIGHT);
                    productList.add(new Runner(id, name, price, brand, healToeOffset, weight, profit, warehouseID));
                } else if (rs.getString(COLUMN_TYPE).equals("runningwatch"))
                {
                    os = rs.getString(COLUMN_OS);
                    batteryLife = rs.getDouble(COLUMN_BATTERY_LIFE);
                    productList.add(new RunningWatch(id, name, price, brand, os, batteryLife, profit, warehouseID));
                }
            }
        }
        catch(SQLException ex){
            System.out.println("SoftwareStaffTableGateway Line 150: " + ex);
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
