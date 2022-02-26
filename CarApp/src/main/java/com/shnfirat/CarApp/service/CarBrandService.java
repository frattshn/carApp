package com.shnfirat.CarApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shnfirat.CarApp.exception.CarBrandNotFoundException;
import com.shnfirat.CarApp.model.CarBrand;
import com.shnfirat.CarApp.repository.ICarBrandRepository;

@Service
public class CarBrandService {

	private final ICarBrandRepository carBrandRepository;

	public CarBrandService(ICarBrandRepository carBrandRepository) {
		this.carBrandRepository = carBrandRepository;
	}

	public List<CarBrand> getAllCars() {
		return carBrandRepository.findAll();
	}

	public CarBrand getOneCarById(Long id) {
		return carBrandRepository.findById(id).orElseThrow(() -> new CarBrandNotFoundException("Car Brand not found with this id : " + id));
	}

	public void deleteOneCarById(Long id) {
		carBrandRepository.deleteById(id);
	}

	public CarBrand updateOneUserById(Long id, CarBrand newCarBrand) {
		Optional<CarBrand> car = carBrandRepository.findById(id);
		if(car.isPresent()) {
			CarBrand foundCar = car.get();
			foundCar.setBrandName(newCarBrand.getBrandName());
			foundCar.setCountry(newCarBrand.getCountry());
			carBrandRepository.save(foundCar);
			return foundCar;
		}else {
			//exception
			return null;
		}
	}

	public CarBrand addOneCar(CarBrand newCarBrand) {
		return carBrandRepository.save(newCarBrand);
	}
	
	
	
}
