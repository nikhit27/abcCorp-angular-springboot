package com.cognizant.orderservice.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cts.ExternalEntities.entity.OrderDetailsEntity;
import com.cts.ExternalEntities.entity.OrderEntity;
import com.cognizant.orderservice.model.OrderDetailsModel;
import com.cognizant.orderservice.model.OrderModel;
import com.cognizant.orderservice.repository.OrderDetailsRepository;
import com.cognizant.orderservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepo;
	
	ModelMapper modelMapper = new ModelMapper();


	
	@Override
	public boolean addOrder(OrderModel orderModel) {
		List<OrderDetailsModel> allOrderDetailsModel = orderModel.getOrderDetails();
		
		OrderEntity orderE = new OrderEntity();
		orderE.setModelId(orderModel.getModelId());
		orderE.setOrderAmount(orderModel.getOrderAmount());		
		orderE.setUserId(orderModel.getUserId());
		
		orderE = orderRepo.saveAndFlush(orderE);
		
		OrderDetailsEntity temp ;
		for(OrderDetailsModel itr: allOrderDetailsModel) {
			temp = modelMapper.map(itr, OrderDetailsEntity.class);
//			temp = new OrderDetailsEntity();
//			temp.setAmount(itr.getAmount());
//			temp.setColorId(itr.getColorId());
//			temp.setQuantity(itr.getQuantity());
//			temp.setAccessoryId(itr.getAccessoryId());
			temp.setOrder(orderE);
			
			orderDetailsRepo.save(temp);
		}
		
		
		return true;
	}

	@Override
	public List<OrderModel> getUsersOrders(int userId) {
		
		List<OrderModel> allOrdersModel = new ArrayList<>();
		List<OrderDetailsModel> allOrderDetailsModel ;
		
		OrderDetailsModel tempOrdDetModel;
		OrderModel tempOrdModel;
		
		List<OrderEntity> allOrdersEntity = new ArrayList<>();
		
		allOrdersEntity.addAll(jdbcTemplate.query("SELECT * FROM orders WHERE user_id= "+userId+";" , 
				new BeanPropertyRowMapper<OrderEntity>(OrderEntity.class)
														)); 
		List<OrderDetailsEntity> allOrderDetailsEntity = new ArrayList<>();
		for(OrderEntity itr: allOrdersEntity) {
			allOrderDetailsEntity.clear();
			
			allOrderDetailsEntity.addAll(jdbcTemplate.query("SELECT  `order_details_id`, `order_id`, `color_id`, `accessory_id`, `quantity`, `amount` FROM order_details WHERE order_id="+itr.getOrderId()+";" , 
					new BeanPropertyRowMapper<OrderDetailsEntity>(OrderDetailsEntity.class)
					));
			
			allOrderDetailsModel = new ArrayList<>();
			for(OrderDetailsEntity itrD: allOrderDetailsEntity) {
				tempOrdDetModel  = modelMapper.map(itrD, OrderDetailsModel.class);
//				tempOrdDetModel = new OrderDetailsModel();
//				tempOrdDetModel.setAmount(itrD.getAmount());
//				tempOrdDetModel.setColorId(itrD.getColorId());
//				tempOrdDetModel.setOrderDetailsId(itrD.getOrderDetailsId());
//				tempOrdDetModel.setQuantity(itrD.getQuantity());
//				tempOrdDetModel.setAccessoryId(itrD.getAccessoryId());
				tempOrdDetModel.setOrder(null);
				
				allOrderDetailsModel.add(tempOrdDetModel);
			}

			tempOrdModel = modelMapper.map(itr, OrderModel.class);
//			tempOrdModel= new OrderModel();
//			tempOrdModel.setModelId(itr.getModelId());
//			tempOrdModel.setOrderAmount(itr.getOrderAmount());
			tempOrdModel.setOrderDetails(allOrderDetailsModel);
//			tempOrdModel.setOrderId(itr.getOrderId());
			tempOrdModel.setUserId(itr.getUserId());			
			
			allOrdersModel.add(tempOrdModel);	
		}
		
		
		
		return allOrdersModel;
	}

	@Override
	public List<OrderModel> allOrders() {
		
		List<OrderModel> allOrdersModel = new ArrayList<>();
		List<OrderDetailsModel> allOrderDetailsModel ;
		
		OrderDetailsModel tempOrdDetModel;
		OrderModel tempOrdModel;
		
		List<OrderEntity> allOrdersEntity = new ArrayList<>();
		
		allOrdersEntity.addAll(jdbcTemplate.query("SELECT * FROM orders;" , 
				new BeanPropertyRowMapper<OrderEntity>(OrderEntity.class)
														));
		
		List<OrderDetailsEntity> allOrderDetailsEntity = new ArrayList<>();
		for(OrderEntity itr: allOrdersEntity) {
			
			allOrderDetailsEntity.clear();
			
			allOrderDetailsEntity.addAll(jdbcTemplate.query("SELECT * FROM order_details WHERE order_id="+itr.getOrderId()+";" , 
					new BeanPropertyRowMapper<OrderDetailsEntity>(OrderDetailsEntity.class)
					));
			
			
			allOrderDetailsModel = new ArrayList<>();
			for(OrderDetailsEntity itrD: allOrderDetailsEntity) {
				tempOrdDetModel = modelMapper.map(itrD, OrderDetailsModel.class);
//				tempOrdDetModel = new OrderDetailsModel();
//				tempOrdDetModel.setAmount(itrD.getAmount());
//				tempOrdDetModel.setColorId(itrD.getColorId());
//				tempOrdDetModel.setOrderDetailsId(itrD.getOrderDetailsId());
//				tempOrdDetModel.setQuantity(itrD.getQuantity());
//				tempOrdDetModel.setAccessoryId(itrD.getAccessoryId());
				tempOrdDetModel.setOrder(null);
				
				allOrderDetailsModel.add(tempOrdDetModel);
			}
			
			tempOrdModel = modelMapper.map(itr, OrderModel.class);
			
//			tempOrdModel= new OrderModel();
//			tempOrdModel.setModelId(itr.getModelId());
//			tempOrdModel.setOrderAmount(itr.getOrderAmount());
			tempOrdModel.setOrderDetails(allOrderDetailsModel);
//			tempOrdModel.setOrderId(itr.getOrderId());
//			tempOrdModel.setUserId(itr.getUserId());			
			
			allOrdersModel.add(tempOrdModel);
		}
		return allOrdersModel;
	}

	
	@Override
	public OrderModel getOrder(int id) {
		OrderModel orderM = null;
		Optional<OrderEntity> orderE = orderRepo.findById(id);
		
		if(orderE.isPresent()) {
		
			List<OrderDetailsEntity> allOrderDetailsE = orderDetailsRepo.findByOrder(orderE.get());
			List<OrderDetailsModel> allOrderDetailsM = new ArrayList<>();
			
			for(OrderDetailsEntity itr: allOrderDetailsE) {
				
				OrderDetailsModel orderDetailsM  =  modelMapper.map(itr, OrderDetailsModel.class);
				
//				OrderDetailsModel orderDetailsM = new OrderDetailsModel();
//				orderDetailsM.setAmount(itr.getAmount());
//				orderDetailsM.setColorId(itr.getColorId());
//				orderDetailsM.setOrderDetailsId(itr.getOrderDetailsId());
//				orderDetailsM.setQuantity(itr.getQuantity());
//				orderDetailsM.setAccessoryId(itr.getAccessoryId());
				orderDetailsM.setOrder(null);
				
				allOrderDetailsM.add(orderDetailsM);
			}
			
			orderM = modelMapper.map(orderE.get(), OrderModel.class);
			
//			orderM = new OrderModel();
//			orderM.setModelId(orderE.get().getModelId());
//			orderM.setOrderAmount(orderE.get().getOrderAmount());
//			orderM.setOrderId(orderE.get().getOrderId());
//			orderM.setUserId(orderE.get().getUserId());
			orderM.setOrderDetails(allOrderDetailsM);
			
			return orderM;
			
		}
		
		return orderM;
	}

	@Override
	public ResponseEntity<Boolean> deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		OrderEntity orderE = new OrderEntity();
		orderE.setOrderId(orderId);
		try {	
		Integer res = orderDetailsRepo.deleteByOrder(orderE);
		orderRepo.deleteById(orderId);
		
		}
		catch(Exception e) {
//			String res = e.getMessage();
			
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		
		
	}

}
