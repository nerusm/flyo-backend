package com.flyosports2.manage.InventoryManagementApp.Repository;

import com.flyosports2.manage.InventoryManagementApp.Model.Manufacturer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
    List<Manufacturer> findManufacturerByName(String name);
}
