package com.cts.training.SeriesModelService.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.training.SeriesModelService.model.ModelModel;
import com.cts.training.SeriesModelService.model.SeriesModel;

import io.swagger.annotations.Api;

@Api(value = "series-model controller",description = "for accessing series and models of cars available")

public interface ISeriesModelController {
	
	public ResponseEntity<List<SeriesModel>> getAllSeries();
	public ResponseEntity<List<ModelModel>> getModelBySeriesId(@PathVariable Integer seriesId);
	public ResponseEntity<ModelModel> getModelById(@PathVariable Integer modelId);
	public ResponseEntity<List<ModelModel>> getAllModels();

}
