package com.shnfirat.CarApp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shnfirat.CarApp.entities.Wheel;
import com.shnfirat.CarApp.services.WheelService;

@RestController
@RequestMapping("/wheels")
public class WheelController {

	private WheelService wheelService;

	public WheelController(WheelService wheelService) {
		this.wheelService = wheelService;
	}
	
	@GetMapping
	public List<Wheel> getAllWheels(){
		return wheelService.getAllWheels();
	}
	
	@GetMapping("/{id}")
	public Wheel getOneWheelById(@PathVariable Long id) {
		return wheelService.getOneWheelById(id);
	}
	
	@PutMapping("/{id}")
	public Wheel updateOneWheel(@PathVariable Long id, @RequestBody Wheel newWheel) {
		return wheelService.updateOneWheel(id, newWheel);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneWheelById(@PathVariable Long id) {
		wheelService.deleteOneWheelById(id);
	}
	
	@PostMapping("/add")
	public Wheel addOneWheel(@PathVariable Long id, @RequestBody Wheel addWheel) {
		return wheelService.addOneWheel(id, addWheel);
	}
}
