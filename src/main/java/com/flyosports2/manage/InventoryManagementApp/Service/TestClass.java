package com.flyosports2.manage.InventoryManagementApp.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flyosports2.manage.InventoryManagementApp.Model.Product;
import com.flyosports2.manage.InventoryManagementApp.Model.ProductMasterCSV;
import com.flyosports2.manage.InventoryManagementApp.Model.Sport;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestClass {
    public static void main(String[] args) throws JsonProcessingException, FileNotFoundException {
        System.out.println("hi");
        ProductMasterService productMasterService = new ProductMasterService();
        List<ProductMasterCSV> productMasterList = productMasterService.getProductMasterCSV();
        for (int i = 0; i < productMasterList.size(); i++) {
            System.out.println(productMasterList.get(i).toString());
            System.out.println("*********************************");
        }
    }
}
