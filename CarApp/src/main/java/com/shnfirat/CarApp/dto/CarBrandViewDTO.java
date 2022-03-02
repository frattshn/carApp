package com.shnfirat.CarApp.dto;

import java.io.Serializable;

import com.shnfirat.CarApp.model.CarBrand;

import lombok.Data;

@Data
public class CarBrandViewDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String brandName;
	
	private String country;

	public CarBrandViewDTO(String brandName, String country) {
		this.brandName = brandName;
		this.country = country;
	}
	
	public static CarBrandViewDTO of(CarBrand carBrand) {
		return new CarBrandViewDTO(carBrand.getBrandName(), carBrand.getCountry());
	}
	
}
