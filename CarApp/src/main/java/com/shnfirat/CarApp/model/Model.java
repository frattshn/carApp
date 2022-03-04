package com.shnfirat.CarApp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Model")
public class Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String modelName;
	
	
	//Many model to one brand
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "carBrandId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	CarBrand carBrand;


	public Model(String modelName, CarBrand carBrand) {
		this.modelName = modelName;
		this.carBrand = carBrand;
	}
	
	
	
	
}
