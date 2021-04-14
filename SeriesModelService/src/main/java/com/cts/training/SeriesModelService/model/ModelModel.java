package com.cts.training.SeriesModelService.model;



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

public class ModelModel {
	
	private Integer modelId;
	private String modelName;
	private Integer modelPrice;
	private Integer seriesId;

}
