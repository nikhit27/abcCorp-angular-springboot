package com.cts.coloraccessoryservice.service;

import java.util.List;

import com.cts.coloraccessoryservice.model.AccessoryModel;
import com.cts.coloraccessoryservice.model.ColorDetailsModel;
import com.cts.coloraccessoryservice.model.ColorModel;

public interface ColorAccessoryService {
	
	List<AccessoryModel> getAccessories(Integer modelId);

//	List<ColorModel> getColorIds(Integer modelId);
	
	List<ColorDetailsModel> getColors(int modelId);
}
