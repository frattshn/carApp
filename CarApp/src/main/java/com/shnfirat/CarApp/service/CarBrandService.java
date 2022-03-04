package com.shnfirat.CarApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.shnfirat.CarApp.dto.CarBrandCreateDTO;
import com.shnfirat.CarApp.dto.CarBrandUpdateDTO;
import com.shnfirat.CarApp.dto.CarBrandViewDTO;
import com.shnfirat.CarApp.exception.CarBrandNotFoundException;
import com.shnfirat.CarApp.model.CarBrand;
import com.shnfirat.CarApp.repository.ICarBrandRepository;

@Service
public class CarBrandService {

	private final ICarBrandRepository carBrandRepository;

	public CarBrandService(ICarBrandRepository carBrandRepository) {
		this.carBrandRepository = carBrandRepository;
	}

	public List<CarBrandViewDTO> getAllCars() {
		return carBrandRepository.findAll().stream().map(CarBrandViewDTO::of).collect(Collectors.toList());
	}

	public CarBrandViewDTO getOneCarById(Long id) {
		final CarBrand carBrand = carBrandRepository.findById(id).orElseThrow(() -> new CarBrandNotFoundException("Car Brand not found with this id : " + id));
		return CarBrandViewDTO.of(carBrand);
	}


	public CarBrandViewDTO updateOneUserById(Long id, CarBrandUpdateDTO carBrandUpdateDTO) {
		final CarBrand carBrand = carBrandRepository.findById(id).orElseThrow(() -> new CarBrandNotFoundException("Car Brand Not Found!"));
		carBrand.setBrandName(carBrandUpdateDTO.getBrandName());
		carBrand.setCountry(carBrandUpdateDTO.getCountry());
		
		final CarBrand updatedCarBrand = carBrandRepository.save(carBrand);
		return CarBrandViewDTO.of(updatedCarBrand);
	}
	
	public void deleteOneCarById(Long id) {
		carBrandRepository.deleteById(id);
	}
	
	public CarBrandViewDTO addOneCar(CarBrandCreateDTO carBrandCreateDTO) {
		final CarBrand carBrand = carBrandRepository.save(new CarBrand(carBrandCreateDTO.getBrandName(), carBrandCreateDTO.getCountry()));
		return CarBrandViewDTO.of(carBrand);
	}
	
	
	
}
