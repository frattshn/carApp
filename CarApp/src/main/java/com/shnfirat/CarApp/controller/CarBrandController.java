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

import com.shnfirat.CarApp.dto.CarBrandCreateDTO;
import com.shnfirat.CarApp.dto.CarBrandUpdateDTO;
import com.shnfirat.CarApp.dto.CarBrandViewDTO;
import com.shnfirat.CarApp.service.CarBrandService;

@RestController
@RequestMapping("/cars")
public class CarBrandController {
	
	private final CarBrandService carBrandService;

	public CarBrandController(CarBrandService carBrandService) {
		this.carBrandService = carBrandService;
	}
	
	@GetMapping
	public List<CarBrandViewDTO> getAllCars(){
		return carBrandService.getAllCars();
	}
	
	@GetMapping("/{id}")
	public CarBrandViewDTO getOneCarById(@PathVariable Long id) {
		return carBrandService.getOneCarById(id);
	}
	
	@PutMapping("/{id}")
	public CarBrandViewDTO updateOneUserById(@PathVariable Long id, @RequestBody CarBrandUpdateDTO carBrandUpdateDTO) {
		return carBrandService.updateOneUserById(id, carBrandUpdateDTO);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneCarById(@PathVariable Long id) {
		carBrandService.deleteOneCarById(id);
	}
	
	@PostMapping
	public CarBrandViewDTO addOneCar(@RequestBody CarBrandCreateDTO carBrandCreateDTO) {
		return carBrandService.addOneCar(carBrandCreateDTO);
	}

}
