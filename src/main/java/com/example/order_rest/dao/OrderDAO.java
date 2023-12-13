package com.example.order_rest.dao;

import java.util.List;

import com.example.order_rest.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDAO extends CrudRepository<OrderEntity, Integer> {
	List<OrderEntity> findByBillAmountBetween(Double minBillAmount, Double maxBillAmount);
}