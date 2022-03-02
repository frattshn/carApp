package com.shnfirat.CarApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "CarBrand")
public class CarBrand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	private String brandName;
	
	private String country;

	public CarBrand(String brandName, String country) {
		this.brandName = brandName;
		this.country = country;
	}
	
	
	
	

}
