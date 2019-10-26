package com.flyosports2.manage.InventoryManagementApp.UIModels;

public class SupplierUI {
    String name;
    String location;


    public SupplierUI(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public SupplierUI() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
