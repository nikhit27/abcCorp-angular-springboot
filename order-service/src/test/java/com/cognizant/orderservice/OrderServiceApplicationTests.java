package com.cognizant.orderservice;


import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.orderservice.repository.OrderRepository;
import com.cognizant.orderservice.service.OrderService;


@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceApplicationTests {

	@Autowired
	private OrderService orderService;
	
	@MockBean
	private OrderRepository orderRepo;
	
	@Test
	void contextLoads() {
		assertEquals(1,1);
	}
	
	@Test
	void AddOrderTest() {
		fail();
	}
	
	
	@Test
	void getUsersOrdersTest() {
		fail();
	}
	
	
	
	
	
	

}
