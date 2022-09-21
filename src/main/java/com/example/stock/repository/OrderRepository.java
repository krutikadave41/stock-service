package com.example.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	

}
