package com.shnfirat.CarApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CarBrand")
public class CarBrand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String brandName;
	
	String country;

	public CarBrand(String brandName, String country) {
		this.brandName = brandName;
		this.country = country;
	}
	
	
	
	

}
