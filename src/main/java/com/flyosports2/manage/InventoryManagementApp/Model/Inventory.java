package com.flyosports2.manage.InventoryManagementApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    int productID;
    int quantity;

    public Inventory(int productID, int quantity) {
        this.productID = productID;
        this.quantity = quantity;
    }

    public Inventory() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", productID=" + productID +
                ", quantity=" + quantity +
                '}';
    }
}
