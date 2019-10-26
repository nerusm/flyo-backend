package com.flyosports2.manage.InventoryManagementApp.Model;
import com.opencsv.bean.CsvBindByName;


public class ProductMasterCSV {

    @CsvBindByName
    int id;

    @CsvBindByName
    String name;

    @CsvBindByName
    String manufacturer;

    @CsvBindByName
    String model;

    @CsvBindByName
    String subModel1;

    @CsvBindByName
    String subModel2;

    @CsvBindByName
    String subModel3;

    @CsvBindByName
    String size;

    @CsvBindByName
    String sport;

    public ProductMasterCSV() {
    }

    public ProductMasterCSV(int id, String name, String manufacturer, String model, String subModel1, String subModel2, String subModel3, String size, String sport) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.model = model;
        this.subModel1 = subModel1;
        this.subModel2 = subModel2;
        this.subModel3 = subModel3;
        this.size = size;
        this.sport = sport;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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

    @Override
    public String toString() {
        return "ProductMasterCSV{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", subModel1='" + subModel1 + '\'' +
                ", subModel2='" + subModel2 + '\'' +
                ", subModel3='" + subModel3 + '\'' +
                ", size='" + size + '\'' +
                ", sport='" + sport + '\'' +
                '}';
    }
}
