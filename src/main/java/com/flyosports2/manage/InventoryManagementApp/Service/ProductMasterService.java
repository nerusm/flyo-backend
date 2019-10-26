package com.flyosports2.manage.InventoryManagementApp.Service;

import com.flyosports2.manage.InventoryManagementApp.Model.Manufacturer;
import com.flyosports2.manage.InventoryManagementApp.Model.Product;
import com.flyosports2.manage.InventoryManagementApp.Model.ProductMasterCSV;
import com.flyosports2.manage.InventoryManagementApp.Model.Sport;
import com.flyosports2.manage.InventoryManagementApp.Repository.ManufacturerRepository;
import com.flyosports2.manage.InventoryManagementApp.Repository.ProductRepository;
import com.flyosports2.manage.InventoryManagementApp.Repository.SportRepository;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMasterService {
    String csvFileName;
    List<ProductMasterCSV> productMasterCSV;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SportRepository sportRepository;
    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Autowired
    SportsService sportsService;


    public ProductMasterService() {
    }

    public void createProducts(String csvFileName) throws FileNotFoundException {
        this.csvFileName = "/home/suren/Projects/FlyO/"+csvFileName;
        this.productMasterCSV = new CsvToBeanBuilder<ProductMasterCSV>(new FileReader(this.csvFileName)).
                withType(ProductMasterCSV.class).
                build().
                parse();
        List<Product> productList = new ArrayList<>();
        Iterator<ProductMasterCSV> iterator = this.productMasterCSV.iterator();
        while (iterator.hasNext()){
            ProductMasterCSV productMasterCSV = iterator.next();
//            Product p1 = new Product("Bat","EW VK18 LEGEND", "ENGLISH WILLOW", "LEGEND","","");
                Product p = new Product(productMasterCSV.getName(), productMasterCSV.getModel(), productMasterCSV.getSubModel1(),
                        productMasterCSV.getSubModel2(),productMasterCSV.getSubModel3(),productMasterCSV.getSize());
//                productRepository.save(p);
            createNewProduct(productMasterCSV.getSport(),productMasterCSV.getManufacturer(),p);
        }
    }

    public String getCsvFileName() {
        return csvFileName;
    }

    public void setCsvFileName(String csvFileName) {
        this.csvFileName = csvFileName;
    }

    public List<ProductMasterCSV> getProductMasterCSV() {
        return productMasterCSV;
    }

    public void setProductMasterCSV(List<ProductMasterCSV> productMasterCSV) {
        this.productMasterCSV = productMasterCSV;
    }

    public void createNewProduct(String sportName, String manuName, Product product){
        Sport sport;
        List<Sport> sports = sportRepository.findBySportName(sportName);
        if(sports.size() > 0) {
            sport = sports.get(0);
        } else {
            sport = sportsService.createNewSport(sportName);
        }
        Manufacturer manufacturer;
        List<Manufacturer> manufacturers = manufacturerRepository.findManufacturerByName(manuName);
        if(manufacturers.size() > 0){
            manufacturer = manufacturers.get(0);
        } else {
            manufacturer =
                    manufacturerRepository.save(new Manufacturer(manuName));
        }
        product.setSport(sport);
        product.setManufacturer(manufacturer);
//        System.out.println("P:"+product.toString());
        productRepository.save(product);
    }


}
