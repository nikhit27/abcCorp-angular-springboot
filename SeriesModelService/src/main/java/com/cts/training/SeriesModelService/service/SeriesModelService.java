package com.cts.training.SeriesModelService.service;

import java.util.List;

import com.cts.training.SeriesModelService.model.ModelModel;
import com.cts.training.SeriesModelService.model.SeriesModel;

public interface SeriesModelService {
	
	List<SeriesModel> getAllSeries();
	
	List<ModelModel> getModelBySeriesId(Integer seriesId);
	
	ModelModel getModelById(Integer modelId);
	
	List<ModelModel> getAllModels();

}
