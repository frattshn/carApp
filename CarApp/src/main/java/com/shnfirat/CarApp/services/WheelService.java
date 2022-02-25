package com.shnfirat.CarApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shnfirat.CarApp.entities.Wheel;
import com.shnfirat.CarApp.repository.IWheelRepository;

@Service
public class WheelService {
	
	IWheelRepository wheelRepository;
	
	public WheelService(IWheelRepository wheelRepository) {
		this.wheelRepository = wheelRepository;
	}


	public List<Wheel> getAllWheels() {
		return wheelRepository.findAll();
	}


	public Wheel getOneWheelById(Long id) {
		return wheelRepository.findById(id).orElse(null);
	}


	public Wheel updateOneWheel(Long id, Wheel newWheel) {
		Optional<Wheel> wheel = wheelRepository.findById(id);
		if(wheel.isPresent()) {
			Wheel foundWheel = wheel.get();
			foundWheel.setWheelName(newWheel.getWheelName());
			foundWheel.setInch(newWheel.getInch());
			wheelRepository.save(foundWheel);
			return foundWheel;
		}else {
			return null;
		}
	}


	public void deleteOneWheelById(Long id) {
		wheelRepository.deleteById(id);
	}


	public Wheel addOneWheel(Long id, Wheel addWheel) {
		return wheelRepository.save(addWheel);
	}

}
