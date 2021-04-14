package com.cts.ExternalEntities.entity;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Entity
@Table(name="orders")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "order_id")
	private Integer orderId;
	
	@Column(name= "user_id")
	private Integer userId;
	
	@Column(name= "model_id")
	private Integer modelId;
	
	@Column(name= "order_amount")
	private Integer orderAmount;
	
	@OneToMany(mappedBy = "order")
	private List<OrderDetailsEntity> orderDetails;
}
