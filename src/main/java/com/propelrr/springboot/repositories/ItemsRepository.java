package com.propelrr.springboot.repositories;

import com.propelrr.springboot.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long>{

    Items findBySerialId(String serialId);
    Items findByName(String name);
    Items findByDescription(String description);
    Items findByPrice(double price);

    Items findByPrice ( boolean equals );
}
