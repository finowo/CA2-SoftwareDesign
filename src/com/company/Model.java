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
    private List<Warehouse> warehouseList;
    private ProductTableGateway pGateway;
    private WarehouseTableGateway wGateway;


    private Model() {
        try {
            Connection conn = DBConnection.getInstance();
            this.pGateway = new ProductTableGateway(conn);
            this.wGateway = new WarehouseTableGateway(conn);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List viewProduct() {
        this.productList = this.pGateway.getProduct();
        return productList;
    }

    public Warehouse viewWarehouse(int id) {
        Warehouse w = this.wGateway.getWarehouse(id);
        return w;
    }

    public Warehouse viewWarehouseWithProducts(int id){
        Warehouse w = wGateway.getWarehouse(id);
        w.setProductList(this.pGateway.getProductByStoreId(id));
        return w;
    }

    public boolean createWarehouse(Warehouse w) {
        //boolean inserted = mGateway.insertWarehouse(m); return inserted;
        return (wGateway.insertWarehouse(w));
    }

    public int createProduct(Product Product) {
       int createdId = this.pGateway.addProduct(Product);
       return createdId;
    }

    public boolean editProduct(int id, double price) {
        return (pGateway.editProduct(id, price));
    }

    public boolean deleteProduct(int id)
    {
        return (pGateway.deleteProduct(id));
    }
}
