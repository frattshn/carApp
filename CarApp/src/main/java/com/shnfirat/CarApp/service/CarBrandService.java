package com.shnfirat.CarApp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.shnfirat.CarApp.dto.CarBrandCreateDTO;
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
	
	public CarBrandViewDTO addOneCar(CarBrandCreateDTO carBrandCreateDTO) {
		final CarBrand carBrand = carBrandRepository.save(new CarBrand(carBrandCreateDTO.getBrandName(), carBrandCreateDTO.getCountry()));
		return CarBrandViewDTO.of(carBrand);
	}
	
	
	
}
