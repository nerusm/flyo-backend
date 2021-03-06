package com.flyosports2.manage.InventoryManagementApp.UIModels;

public class ProductUI {
    String name;
    String model;
    String subModel1;
    String subModel2;
    String subModel3;
    String size;
    String sport;
    String manufacturer;
    int quantity;
    int id;

    public ProductUI(int id, String name, String model, String subModel1, String subModel2, String subModel3, String size, String sport, String manufacturer, int quantity) {
        this.name = name;
        this.model = model;
        this.subModel1 = subModel1;
        this.subModel2 = subModel2;
        this.subModel3 = subModel3;
        this.size = size;
        this.sport = sport;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.id = id;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
