package com.cts.coloraccessoryservice.model;

import java.util.List;

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
public class ColorAccessoryModel {
	private List<ColorDetailsModel> colorsList;
	private List<AccessoryModel> accessoriesList;
}
