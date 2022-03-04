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

import com.shnfirat.CarApp.dto.ModelCreateDTO;
import com.shnfirat.CarApp.dto.ModelUpdateDTO;
import com.shnfirat.CarApp.dto.ModelViewDTO;
import com.shnfirat.CarApp.service.ModelService;

@RestController
@RequestMapping("/models")
public class ModelController {

	private final ModelService modelService;

	public ModelController(ModelService modelService) {
		this.modelService = modelService;
	}
	
	
	@GetMapping
	public List<ModelViewDTO> getAllModels(){
		return modelService.getAllModels();
	}
	
	@GetMapping("/{id}")
	public ModelViewDTO getOneModelById(@PathVariable Long id) {
		return modelService.getOneModelById(id);
	}
	
	@PutMapping("/{id}")
	public ModelViewDTO updateOneModelById(@PathVariable Long id, @RequestBody ModelUpdateDTO modelUpdateDTO) {
		return modelService.updateOneModelById(id, modelUpdateDTO);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneModelById(@PathVariable Long id) {
		modelService.deleteOneModelById(id);
	}
	
	@PostMapping
	public ModelViewDTO addOneModel(@RequestBody ModelCreateDTO modelCreateDTO) {
		return modelService.addOneModel(modelCreateDTO);
	}
	
	
}
