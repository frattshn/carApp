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

import com.shnfirat.CarApp.model.Engine;
import com.shnfirat.CarApp.service.EngineService;

@RestController
@RequestMapping("/engines")
public class EngineController {

	private final EngineService engineService;

	public EngineController(EngineService engineService) {
		this.engineService = engineService;
	}
	
	@GetMapping
	public List<Engine> getAllEngines(){
		return engineService.getAllEngines();
	}
	
	@GetMapping("/{id}")
	public Engine getOneEngineById(@PathVariable Long id) {
		return engineService.getOneEngineById(id);
	}
	
	@PutMapping("{id}")
	public Engine updateOneEngineById(@PathVariable Long id, @RequestBody Engine newEngine) {
		return engineService.updateOneEngineById(id, newEngine);
	}
	
	@DeleteMapping("{id}")
	public void deleteOneEngineById(@PathVariable Long id) {
		engineService.deleteOneEngineById(id);
	}
	
	@PostMapping("/add")
	public Engine addOneEngine(@RequestBody Engine addEngine) {
		return engineService.addOneEngine(addEngine);
	}
}
