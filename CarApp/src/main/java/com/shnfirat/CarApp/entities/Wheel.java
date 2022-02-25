package com.shnfirat.CarApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name = "Wheel")
public class Wheel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String wheelName;
	
	@Column(columnDefinition = "int(2)")
	int inch;
	
}
