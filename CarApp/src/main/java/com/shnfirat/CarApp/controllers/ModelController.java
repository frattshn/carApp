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

import com.shnfirat.CarApp.entities.Model;
import com.shnfirat.CarApp.services.ModelService;

@RestController
@RequestMapping("/models")
public class ModelController {

	private ModelService modelService;

	public ModelController(ModelService modelService) {
		this.modelService = modelService;
	}
	
	
	@GetMapping
	public List<Model> getAllModels(){
		return modelService.getAllModels();
	}
	
	@GetMapping("/{id}")
	public Model getOneModelById(@PathVariable Long id) {
		return modelService.getOneModelById(id);
	}
	
	@PutMapping("/{id}")
	public Model updateOneModelById(@PathVariable Long id, @RequestBody Model newModel) {
		return modelService.updateOneModelById(id, newModel);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneModelById(@PathVariable Long id) {
		modelService.deleteOneModelById(id);
	}
	
	@PostMapping("/add")
	public Model addOneModel(@RequestBody Model addModel) {
		return modelService.addOneModel(addModel);
	}
	
	
}
