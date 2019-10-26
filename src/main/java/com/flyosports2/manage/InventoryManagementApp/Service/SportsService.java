package com.flyosports2.manage.InventoryManagementApp.Service;

import com.flyosports2.manage.InventoryManagementApp.Model.Manufacturer;
import com.flyosports2.manage.InventoryManagementApp.Model.Product;
import com.flyosports2.manage.InventoryManagementApp.Model.Sport;
import com.flyosports2.manage.InventoryManagementApp.Repository.ManufacturerRepository;
import com.flyosports2.manage.InventoryManagementApp.Repository.ProductRepository;
import com.flyosports2.manage.InventoryManagementApp.Repository.SportRepository;
import com.flyosports2.manage.InventoryManagementApp.Repository.SupplierRespository;
import com.flyosports2.manage.InventoryManagementApp.UIModels.CheckedItems;
import com.flyosports2.manage.InventoryManagementApp.UIModels.ProductUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class SportsService {

    @Autowired
    SportRepository sportRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Autowired
    SupplierRespository supplierRespository;

    public List<Sport> getAllSports(){
        return (List<Sport>) sportRepository.findAll();
    }

    public Sport getSportByName(String name){
        return sportRepository.findBySportName(name).get(0);
    }

    public void createNewSport(Sport sport){
        sportRepository.save(sport);
    }

    public Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Iterable<Product> getAllProductsByManfacturere(String name) {
        return productRepository.findByManufacturerName(name);
    }


    public void deleteSport(CheckedItems[] checkedItems){
        for (int i = 0; i < checkedItems.length; i++) {
            long s = sportRepository.deleteBySportName(checkedItems[i].getValue());
        }
    }

    public void deleteSupplier(CheckedItems[] checkedItems){
        for (int i = 0; i < checkedItems.length; i++) {
            long s = supplierRespository.deleteBySupplierName(checkedItems[i].getValue());
        }
    }

    public void deleteProducts(CheckedItems[] checkedItems){
        for (int i = 0; i < checkedItems.length; i++) {
            long s = productRepository.deleteById(Integer.parseInt(checkedItems[i].getValue()));
            System.out.println("Product Deleted: "+s);
        }
    }

    public Iterable<Product> getAllProductsByName(String name) {
        return productRepository.findByName(name);
    }

    public Iterable<Product> getAllProductsByNameAndSize(String name, String size) {
        return productRepository.findByNameAndSize(name,size);
    }


    public List<Product> getProductsBySport(String name){
        return productRepository.findBySportSportName(name);
//        return null;
    }

    public Sport createNewSport(String name){
        List<Sport> sportList = (List<Sport>) sportRepository.findAll();
        int newID = sportList.size()+1;
        Sport sport = new Sport(newID,name);
        sportRepository.save(sport);
        return sport;
    }

    public void createNewProduct(String sportName, String manuName, Product product){
        Sport sport = sportRepository.findBySportName(sportName).get(0);
        Manufacturer manufacturer = manufacturerRepository.findManufacturerByName(manuName).get(0);
        product.setSport(sport);
        product.setManufacturer(manufacturer);
        System.out.println("P:"+product.toString());
        productRepository.save(product);
    }

    public void deleteProduct(String name, String model){
        productRepository.deleteByNameAndModel(name, model);
    }
    public void deleteProduct(int id) { productRepository.deleteById(id); }
    public List<ProductUI> getAllProductsUI(){
        Iterable<Product> productList = productRepository.findAll();
        List<ProductUI> productUIList = new ArrayList<>();

        Iterator<Product> iterator = productList.iterator();

        while (iterator.hasNext()){
            Product product = iterator.next();
            productUIList.add(
              new ProductUI(product.getId(), product.getName(), product.getModel(), product.getSubModel1(),
                      product.getSubModel2(), product.getSubModel3(), product.getSize(), product.getSport().getSportName(),
                      product.getManufacturer().getName(),0   )
            );
        }
        return productUIList;

    }

}
