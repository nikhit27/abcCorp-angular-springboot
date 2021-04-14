package com.cts.training.SeriesModelService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ExternalEntities.entity.ModelEntity;
import com.cts.ExternalEntities.entity.SeriesEntity;
import com.cts.training.SeriesModelService.model.ModelModel;
import com.cts.training.SeriesModelService.model.SeriesModel;
import com.cts.training.SeriesModelService.repository.ModelRepository;
import com.cts.training.SeriesModelService.repository.SeriesRepository;




@Service
public class SeriesModelServiceImpl implements SeriesModelService{
	
	@Autowired
	SeriesRepository seriesRepo;
	
	@Autowired
	ModelRepository modelRepo;


	@Override
	public List<SeriesModel> getAllSeries() {
//		SeriesModel series;
		List<SeriesModel> allSeries = new ArrayList<>();
		
		List<SeriesEntity> allSeriesEntity = seriesRepo.findAll();
		
		ModelMapper modelMapper = new ModelMapper();
		
		for(SeriesEntity itr: allSeriesEntity) {
			SeriesModel series = modelMapper.map(itr,  SeriesModel.class);
			
//			series = new SeriesModel(
//									itr.getSeriesId(),
//									itr.getSeriesName()
//					);
			allSeries.add(series);
		}
		
		return allSeries;
	}

	@Override
	public List<ModelModel> getModelBySeriesId(Integer seriesId) {
		List<ModelModel> allModels = new ArrayList<>();
//		ModelModel model;
		ModelMapper modelMapper = new ModelMapper();
		
		List<ModelEntity> allModelEntity = modelRepo.findBySeriesId(seriesId);
		
		for(ModelEntity itr: allModelEntity) {
			ModelModel model = modelMapper.map(itr,  ModelModel.class);
			
			allModels.add(model);
		}
		return allModels;
	}

	@Override
	public ModelModel getModelById(Integer modelId) {
		ModelMapper modelMapper = new ModelMapper();
		
		Optional<ModelEntity> temp = this.modelRepo.findById(modelId);
		ModelModel res = modelMapper.map(temp.get(), ModelModel.class);
		return res;
	}

	@Override
	public List<ModelModel> getAllModels() {
		List<ModelModel> allModels = new ArrayList<>();
//		ModelModel model;
		ModelMapper modelMapper = new ModelMapper();
		
		List<ModelEntity> allModelEntity = modelRepo.findAll();
		
		for(ModelEntity itr: allModelEntity) {
			ModelModel model = modelMapper.map(itr,  ModelModel.class);
			
			allModels.add(model);
		}
		return allModels;
	}

}
