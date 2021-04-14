package com.cts.ExternalEntities.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="car_model")
@Entity
public class ModelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "model_id")
	private Integer modelId;
	
	@Column(name= "model_name")
	private String modelName;
	
	@Column(name= "model_price")
	private Integer modelPrice;
	
	@Column(name= "series_id")
	private Integer seriesId;
}
