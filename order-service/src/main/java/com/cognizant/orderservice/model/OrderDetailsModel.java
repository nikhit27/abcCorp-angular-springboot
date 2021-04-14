package com.cognizant.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetailsModel {
	private Integer orderDetailsId;
	private OrderModel order;
	private Integer colorId;
	private Integer accessoryId;
	private Integer quantity;
	private Integer amount;	
}
