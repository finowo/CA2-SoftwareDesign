package com.company;

import com.company.database.DBConnection;
import com.company.database.WarehouseTableGateway;
import com.company.database.ProductTableGateway;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Model {

    private static Model instance = null;

    public static synchronized Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }


    private List<Product> productList;
    private ProductTableGateway sGateway;
    private WarehouseTableGateway mGateway;


    private Model() {

        try {
            Connection conn = DBConnection.getInstance();
            this.sGateway = new ProductTableGateway(conn);
            this.mGateway = new WarehouseTableGateway(conn);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public List viewProduct() {
        this.productList = this.sGateway.getProduct();
        return productList;
    }

    //gets a warehouse using an ID from the database then gets all that warehouse's products
    public Warehouse viewWarehouse(int id){
        Warehouse m = mGateway.getWarehouse(id);
        m.setProductList(this.sGateway.getProductByWarehouseId(id));
        return m;
    }

    public boolean createWarehouse(Warehouse m){
        //boolean inserted = mGateway.insertWarehouse(m);
        //return inserted;
        return (mGateway.insertWarehouse(m));
    }

    public int createProduct(Product Product) {
        int createdId = this.sGateway.createProduct(Product);
        return createdId;
    }
}


