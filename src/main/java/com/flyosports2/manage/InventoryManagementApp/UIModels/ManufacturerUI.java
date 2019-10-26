package com.flyosports2.manage.InventoryManagementApp.UIModels;

public class ManufacturerUI {
    private String name;

    public ManufacturerUI(String name) {
        this.name = name;
    }

    public ManufacturerUI() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ManufacturerUI{" +
                "name='" + name + '\'' +
                '}';
    }
}
