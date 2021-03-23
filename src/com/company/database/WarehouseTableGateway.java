package com.company.database;

import com.company.Warehouse;

import java.sql.*;
import java.util.logging.Logger;

public class WarehouseTableGateway {

    private static final String TABLE_NAME = "manager";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "location";
    private static final String COLUMN_OFFICE = "orderNumber";


    private Connection mConnection;

    public WarehouseTableGateway(Connection connection) {
        mConnection = connection;
    }

    // Get Manager by ID
    public Warehouse getWarehouse(int id)  {
        //the SQL query to execute
        String query;
        //the java.sql.Statement object used to execute the SQL query
        Statement stmt;
        //the java.sql.ResultSet representing the result of SQL query
        ResultSet rs;

        String location;
        int whId, orderNumber;

        //a Programmer object created from a row in the result of the query
        Warehouse w = null;

        query = "SELECT * FROM " + TABLE_NAME + " WHERE id = " + id;

        // This print if for debugging purposes only.
        System.out.println(query);

        try {
            stmt = this.mConnection.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                id = rs.getInt(COLUMN_ID);
                location = rs.getString(COLUMN_LOCATION);
                orderNumber = rs.getInt(COLUMN_ORDER_NUMBER);

                w = new Warehouse(id, location, orderNumber);
            }
        }
        catch (SQLException e) {
            System.out.println("Error caught:");
            System.out.println("\n" + e.getMessage());
            System.out.println("\tThrown in file " + e.getStackTrace()[0].getFileName());
            System.out.println("\tThrown on line " + e.getStackTrace()[0].getLineNumber());
        }

        // return the Warehouse
        return w;
    }

    //Called from the Model when the user wants to create a new Runner in the database
    public boolean insertWarehouse(Manager w)  {
        //the SQL query to execute
        String query;
        //the java.sql.PreparedStatement object used to execute the SQL query
        PreparedStatement stmt;

        int numRowsAffected;


        //the required SQL INSERT statement with place holders for the values to be inserted into the database
        query = "INSERT INTO " + TABLE_NAME + " (" +
                COLUMN_LOCATION + ", " +
                COLUMN_ORDER_NUMBER +

                ") VALUES (?, ?)";

        try {
            //create a PreparedStatement object to execute the query and insert the values into the query
            stmt = mConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, w.getLocation());
            stmt.setInt(2, w.getOrderNumber());

            //execute the query and make sure that one and only one row was inserted into the database
            numRowsAffected = stmt.executeUpdate();

            if (numRowsAffected == 1) {
                    //if one row was inserted, retrieve the id that was assigned to that row in the database and ret
                    //ResultSet keys = stmt.getGeneratedKeys();
                    //keys.next();

                    //try getting the ID that is returned here and send it back to the user
                    //id = keys.getInt(1);
                return true;
            }

        }
        catch (SQLException e)
        {
            System.out.println("Enter a proper error message here");
        }

        return false;
    }

}
