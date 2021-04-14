package com.cts.coloraccessoryservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ExternalEntities.entity.AccessoryEntity;
import com.cts.ExternalEntities.entity.ColorDetailsEntity;
import com.cts.ExternalEntities.entity.ColorEntity;
import com.cts.coloraccessoryservice.model.AccessoryModel;
import com.cts.coloraccessoryservice.model.ColorDetailsModel;
import com.cts.coloraccessoryservice.model.ColorModel;
import com.cts.coloraccessoryservice.repository.AccessoryRepository;
import com.cts.coloraccessoryservice.repository.ColorDetailsRepository;
import com.cts.coloraccessoryservice.repository.ColorRepository;

@Service
public class ColorAccessoryServiceImpl implements ColorAccessoryService{

	@Autowired
	AccessoryRepository accessRepo;
	
	@Autowired
	ColorRepository colorRepo;
	
	@Autowired
	ColorDetailsRepository colorDetailsRepo;
	

	ModelMapper modelMapper = new ModelMapper();
		
	
	@Override
	public List<AccessoryModel> getAccessories(Integer modelId) {
		
		List<AccessoryModel> allAccessories = new ArrayList<>();
		AccessoryModel accessoryModel;
		
		List<AccessoryEntity> allAccessoriesEntity = accessRepo.findByModelId(modelId);
		
		for(AccessoryEntity itr: allAccessoriesEntity) {
			accessoryModel = modelMapper.map(itr, AccessoryModel.class);
//			accessoryModel = new AccessoryModel(
//												itr.getAccessoryId(),
//												itr.getAccessoryName(),
//												itr.getAccessoryPrice(),
//												itr.getModelId()
//								 );
			allAccessories.add(accessoryModel);
		}
		return allAccessories;
	}

	
	public List<Integer> getColorIds(Integer modelId) {
		
		List<Integer> allColorIds = new ArrayList<>();
		List<ColorEntity> allColorEntity = colorRepo.findByModelId(modelId);
		
		allColorEntity.forEach(i -> allColorIds.add(i.getColorId()));
		
		return allColorIds;
	}


	public ColorDetailsModel getColorDetails(int colorId) {
		
		Optional<ColorDetailsEntity> colorDetailsEntity = colorDetailsRepo.findById(colorId);
		
		ColorDetailsModel colorDetailsModel = modelMapper.map(colorDetailsEntity.get(), ColorDetailsModel.class);
//		ColorDetailsModel colorDetailsModel = new ColorDetailsModel(
//															colorDetailsEntity.get().getColorId(),
//															colorDetailsEntity.get().getColorName(),
//															colorDetailsEntity.get().getColorPrice()
//												  );
		
		return colorDetailsModel;
	}


	@Override
	public List<ColorDetailsModel> getColors(int modelId) {
		
		List<ColorDetailsModel> allColors = new ArrayList<>();
		List<Integer> allColorIds = getColorIds(modelId);
		
		allColorIds.forEach(i -> allColors.add(getColorDetails(i)));
		
		return allColors;
	}

}
