package com.cts.coloraccessoryservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.coloraccessoryservice.model.AccessoryModel;
import com.cts.coloraccessoryservice.model.ColorAccessoryModel;
import com.cts.coloraccessoryservice.model.ColorDetailsModel;

import io.swagger.annotations.Api;

@Api(value = "color-accessory controller",description = "To access colors and accessories of a model available")
public interface IColorAccessoryController {
	ResponseEntity<List<ColorDetailsModel>> getColors(@PathVariable Integer modelId);
	ResponseEntity<List<AccessoryModel>> getAccessories(@PathVariable Integer modelId);
	ResponseEntity<ColorAccessoryModel> getColorsAndAccesasories(@PathVariable Integer modelId);
}
