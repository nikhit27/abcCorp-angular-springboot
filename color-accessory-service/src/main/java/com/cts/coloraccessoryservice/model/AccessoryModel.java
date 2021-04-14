package com.cts.coloraccessoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor 
@AllArgsConstructor

public class AccessoryModel {
	private Integer accessoryId;
	private String accessoryName;
	private Integer accessoryPrice;
	private Integer modelId;
	
}
