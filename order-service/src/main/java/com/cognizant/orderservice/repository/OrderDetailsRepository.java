package com.cognizant.orderservice.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.ExternalEntities.entity.OrderDetailsEntity;
import com.cts.ExternalEntities.entity.OrderEntity;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Integer>{
	List<OrderDetailsEntity> findByOrder(OrderEntity order);
	
	@Transactional
	Integer deleteByOrder(OrderEntity order);
}
