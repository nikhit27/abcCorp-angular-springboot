package com.cts.training.SeriesModelService.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.cts.training.SeriesModelService.model.ModelModel;
import com.cts.training.SeriesModelService.model.SeriesModel;
import com.cts.training.SeriesModelService.service.SeriesModelService;

@CrossOrigin
@RestController
public class SeriesModelController implements ISeriesModelController{

	@Autowired
	private SeriesModelService seriesModelService;
	
	@Override
	@GetMapping("/getAllSeries")
	public ResponseEntity<List<SeriesModel>> getAllSeries() {
		List<SeriesModel> allSeries = seriesModelService.getAllSeries();
		return new ResponseEntity<List<SeriesModel>>(allSeries, HttpStatus.OK);
	}

	@Override
	@GetMapping("/getModels/{seriesId}")
	public ResponseEntity<List<ModelModel>> getModelBySeriesId(@PathVariable("seriesId") Integer seriesId) {
		List<ModelModel> allModels = seriesModelService.getModelBySeriesId(seriesId);
		return new ResponseEntity<List<ModelModel>>(allModels, HttpStatus.OK);
	}

	@Override
	@GetMapping("/getOneModel/{modelId}")
	public ResponseEntity<ModelModel> getModelById(@PathVariable("modelId") Integer modelId) {
		ModelModel res = seriesModelService.getModelById(modelId);
		return new ResponseEntity<ModelModel>(res, HttpStatus.OK);
	}

	@Override
	@GetMapping("/getAllModels")
	public ResponseEntity<List<ModelModel>> getAllModels() {
		List<ModelModel> res  = seriesModelService.getAllModels();
		return new ResponseEntity<List<ModelModel>>(res, HttpStatus.OK);
	}
	
}
