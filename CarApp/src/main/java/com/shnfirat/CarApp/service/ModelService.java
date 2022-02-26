package com.shnfirat.CarApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shnfirat.CarApp.exception.ModelNotFoundException;
import com.shnfirat.CarApp.model.Model;
import com.shnfirat.CarApp.repository.IModelRepository;

@Service
public class ModelService {
	
	private final IModelRepository modelRepository;
	
	public ModelService(IModelRepository modelRepository) {
		this.modelRepository = modelRepository;
	}


	public List<Model> getAllModels() {
		return modelRepository.findAll();
	}

	public Model getOneModelById(Long id) {
		return modelRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Model not found with this id : " + id));
	}


	public Model updateOneModelById(Long id, Model newModel) {
		Optional<Model> model = modelRepository.findById(id);
		if(model.isPresent()) {
			Model foundModel = model.get();
			foundModel.setCarBrand(newModel.getCarBrand());
			foundModel.setModelName(newModel.getModelName());
			modelRepository.save(foundModel);
			return foundModel;
		}else {
			return null;
		}
	}

	public void deleteOneModelById(Long id) {
		modelRepository.deleteById(id);
	}


	public Model addOneModel(Model addModel) {
		return modelRepository.save(addModel);
	}

}
