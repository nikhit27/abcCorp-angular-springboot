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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="accessories")
public class AccessoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "accessory_id")
	private Integer accessoryId;

	@Column(name= "accessory_name")
	private String accessoryName;
	
	@Column(name= "accessory_price")
	private Integer accessoryPrice;
	
	@Column(name= "model_id")
	private Integer modelId;

}
