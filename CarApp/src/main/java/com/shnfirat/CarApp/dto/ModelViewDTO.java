package com.shnfirat.CarApp.dto;

import java.io.Serializable;

import com.shnfirat.CarApp.model.Model;

import lombok.Data;

@Data
public class ModelViewDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String modelName;
	
	Long carBrandId;

	public ModelViewDTO(String modelName, Long carBrandId) {
		this.modelName = modelName;
		this.carBrandId = carBrandId;
	}
	
	public static ModelViewDTO of (Model model) {
		return new ModelViewDTO(model.getModelName(), model.getCarBrand().getId());
	}
	
	
	
}
