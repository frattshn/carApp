package com.shnfirat.CarApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shnfirat.CarApp.dto.ModelCreateDTO;
import com.shnfirat.CarApp.dto.ModelUpdateDTO;
import com.shnfirat.CarApp.dto.ModelViewDTO;
import com.shnfirat.CarApp.exception.CarBrandNotFoundException;
import com.shnfirat.CarApp.exception.ModelNotFoundException;
import com.shnfirat.CarApp.model.CarBrand;
import com.shnfirat.CarApp.model.Model;
import com.shnfirat.CarApp.repository.ICarBrandRepository;
import com.shnfirat.CarApp.repository.IModelRepository;

@Service
public class ModelService {
	
	private final IModelRepository modelRepository;
	private final ICarBrandRepository carBrandRepository;
	
	public ModelService(IModelRepository modelRepository, ICarBrandRepository carBrandRepository) {
		this.modelRepository = modelRepository;
		this.carBrandRepository = carBrandRepository;
	}

	public List<ModelViewDTO> getAllModels() {
		return modelRepository.findAll().stream().map(ModelViewDTO::of).collect(Collectors.toList());
	}

	public ModelViewDTO getOneModelById(Long id) {
		final Model model = modelRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Model not found with this id : " + id));
		return ModelViewDTO.of(model);
	}

	public ModelViewDTO updateOneModelById(Long id, ModelUpdateDTO modelUpdateDTO) {
		final Model model = modelRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Car Brand Not Found!"));
		model.setModelName(modelUpdateDTO.getModelName());
		
		final Model updateModel = modelRepository.save(model);
		return ModelViewDTO.of(updateModel);
	}

	public void deleteOneModelById(Long id) {
		modelRepository.deleteById(id);
	}

	public ModelViewDTO addOneModel(ModelCreateDTO modelCreateDTO) {
		final CarBrand carBrand = carBrandRepository.findById(modelCreateDTO.getCarBrandId()).orElseThrow(() -> new CarBrandNotFoundException("CarBrand not found!"));
		final Model model = modelRepository.save(new Model(modelCreateDTO.getModelName(), carBrand));
		return ModelViewDTO.of(model);
		
	}

}
