package com.flyosports2.manage.InventoryManagementApp.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String name;
//    String manufacturer;
    String model;
    String subModel1;
    String subModel2;
    String subModel3;
    String size;
//    String sport;
    Date lastPurchased;
    String lastPurchasedFromSupplier;

    String udpatedBy;
    Date updatedDate;

    //    int quantity;

    public String getSubModel1() {
        return subModel1;
    }

    public void setSubModel1(String subModel1) {
        this.subModel1 = subModel1;
    }

    public String getSubModel2() {
        return subModel2;
    }

    public void setSubModel2(String subModel2) {
        this.subModel2 = subModel2;
    }

    public String getSubModel3() {
        return subModel3;
    }

    public void setSubModel3(String subModel3) {
        this.subModel3 = subModel3;
    }

/*    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }*/

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @ManyToOne
    @JoinTable(name = "PRODUCT_SPORT1", joinColumns = @JoinColumn(name = "PRODUCT"), inverseJoinColumns = @JoinColumn(name = "SPORT_ID"))
    Sport sport;

    @ManyToOne
    @JoinTable(name = "PRODUCT_MANUFACTURER", joinColumns = @JoinColumn(name = "MANUFACTURER"), inverseJoinColumns = @JoinColumn(name = "MANUFACTURER_ID"))
    Manufacturer manufacturer;

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Product(String name, String model, String subModel1, String subModel2, String subModel3, String size) {
        this.name = name;
        this.model = model;
        this.size = size;
        this.subModel1 = subModel1;
        this.subModel2 = subModel2;
        this.subModel3 = subModel3;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", sport=" + sport +
                '}';
    }
}
