package com.cts.coloraccessoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.coloraccessoryservice.model.AccessoryModel;
import com.cts.coloraccessoryservice.model.ColorAccessoryModel;
import com.cts.coloraccessoryservice.model.ColorDetailsModel;
import com.cts.coloraccessoryservice.service.ColorAccessoryService;

@RestController
@CrossOrigin
public class ColorAccessoryController implements IColorAccessoryController{
	
	@Autowired
	ColorAccessoryService serviceObj;

	@Override
	@GetMapping("/getColors/{modelId}") 
	public ResponseEntity<List<ColorDetailsModel>> getColors(@PathVariable("modelId") Integer modelId) {
		List<ColorDetailsModel> response = serviceObj.getColors(modelId);
		return new ResponseEntity<List<ColorDetailsModel>>(response, HttpStatus.OK);
	}

	@Override
	@GetMapping("/getAccessories/{modelId}")
	public ResponseEntity<List<AccessoryModel>> getAccessories(@PathVariable("modelId") Integer modelId) {
		List<AccessoryModel> response = serviceObj.getAccessories(modelId);
		return new ResponseEntity<List<AccessoryModel>>(response, HttpStatus.OK);
	}

	@Override
	@GetMapping("/getColorAndAccessories/{modelId}")
	public ResponseEntity<ColorAccessoryModel> getColorsAndAccesasories(@PathVariable("modelId") Integer modelId) {
		List<ColorDetailsModel> responseColor = serviceObj.getColors(modelId);
		List<AccessoryModel> responseAccessory = serviceObj.getAccessories(modelId);
		ColorAccessoryModel response = new ColorAccessoryModel();
		response.setColorsList(responseColor);
		response.setAccessoriesList(responseAccessory);
		
		
		return new ResponseEntity<ColorAccessoryModel>(response, HttpStatus.OK);
	}

}
