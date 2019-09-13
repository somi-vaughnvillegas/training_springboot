package com.propelrr.springboot.repositories;

import com.propelrr.springboot.models.OrderRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<OrderRes, Long> {

   // OrderRes findByQuantity (Integer quantity);
}
