package com.flyosports2.manage.InventoryManagementApp.Repository;

import com.flyosports2.manage.InventoryManagementApp.Model.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SupplierRespository extends CrudRepository<Supplier, Long> {

    List<Supplier> findBySupplierName(String supplierName);
    long deleteBySupplierName(String supplierName);
}
