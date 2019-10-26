package com.flyosports2.manage.InventoryManagementApp.Repository;

import com.flyosports2.manage.InventoryManagementApp.Model.Product;
import com.flyosports2.manage.InventoryManagementApp.Model.Sport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findBySportSportName(String sportName);
    List<Product> findByManufacturerName(String name);
    List<Product> findByName(String name);
    List<Product> findByNameAndSize(String name,String size);
    long deleteByNameAndModel(String name, String model);
    long deleteById(int id);

    int countBySportSportName(String sportName);
    /*    List<Product> findBySportName(String sportName);*/
}
