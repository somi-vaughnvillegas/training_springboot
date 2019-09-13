package com.propelrr.springboot.repositories;

import com.propelrr.springboot.models.Inventory;
import com.propelrr.springboot.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findByItems( Items items);

}
