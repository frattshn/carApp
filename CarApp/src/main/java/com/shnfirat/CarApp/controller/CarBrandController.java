package com.shnfirat.CarApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shnfirat.CarApp.model.CarBrand;
import com.shnfirat.CarApp.service.CarBrandService;

@RestController
@RequestMapping("/cars")
public class CarBrandController {
	
	private final CarBrandService carBrandService;

	public CarBrandController(CarBrandService carBrandService) {
		this.carBrandService = carBrandService;
	}
	
	@GetMapping
	public List<CarBrand> getAllCars(){
		return carBrandService.getAllCars();
	}
	
	@GetMapping("/{id}")
	public CarBrand getOneCarById(@PathVariable Long id) {
		return carBrandService.getOneCarById(id);
	}
	
	@PutMapping("/{id}")
	public CarBrand updateOneUserById(@PathVariable Long id, @RequestBody CarBrand newCarBrand) {
		return carBrandService.updateOneUserById(id, newCarBrand);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneCarById(@PathVariable Long id) {
		carBrandService.deleteOneCarById(id);
	}
	
	@PostMapping("/add")
	public CarBrand addOneCar(@RequestBody CarBrand newCarBrand) {
		return carBrandService.addOneCar(newCarBrand);
	}

}
