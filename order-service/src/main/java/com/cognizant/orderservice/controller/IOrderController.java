package com.cognizant.orderservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.orderservice.model.OrderModel;

import io.swagger.annotations.Api;

@Api(value = "order controller",description = "for accessing orders  of users")
public interface IOrderController {
	
	
	public ResponseEntity<List<OrderModel>> getAllOrders();
    public ResponseEntity<Boolean> addOneOrder(@RequestBody OrderModel orderModel);
    public ResponseEntity<List<OrderModel>> getUserOrders(@PathVariable Integer userId);
    public ResponseEntity<OrderModel> getOneOrder(@PathVariable Integer orderId);
    public ResponseEntity<Boolean> deleteOrder(@PathVariable Integer orderId);
    
}
