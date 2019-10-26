package com.flyosports2.manage.InventoryManagementApp.Repository;

import com.flyosports2.manage.InventoryManagementApp.Model.Sport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SportRepository extends CrudRepository<Sport, Long> {

    List<Sport> findBySportName(String sportName);
    long deleteBySportName(String sportName);
    int countBySportNameNotNull();
}
