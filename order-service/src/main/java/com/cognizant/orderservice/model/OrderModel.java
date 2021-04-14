package com.cognizant.orderservice.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
public class OrderModel {
	private Integer orderId;
	private Integer modelId;
	private Integer orderAmount;
	private Integer userId;
	private List<OrderDetailsModel> orderDetails;
}
