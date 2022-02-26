package com.shnfirat.CarApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shnfirat.CarApp.exception.EngineNotFoundException;
import com.shnfirat.CarApp.model.Engine;
import com.shnfirat.CarApp.repository.IEngineRepository;

@Service
public class EngineService {
	
	private final IEngineRepository engineRepository;

	public EngineService(IEngineRepository engineRepository) {
		this.engineRepository = engineRepository;
	}

	public List<Engine> getAllEngines() {
		return engineRepository.findAll();
	}

	public Engine getOneEngineById(Long id) {
		return engineRepository.findById(id).orElseThrow(() -> new EngineNotFoundException("Engine not found with this id : " + id));
	}

	public Engine updateOneEngineById(Long id, Engine newEngine) {
		Optional<Engine> engine = engineRepository.findById(id);
		if(engine.isPresent()) {
			Engine foundEngine = engine.get();
			foundEngine.setEngineName(newEngine.getEngineName());
			foundEngine.setEnginePower(newEngine.getEnginePower());
			engineRepository.save(foundEngine);
			return foundEngine;
		}else {
			return null;			
		}
	}

	public void deleteOneEngineById(Long id) {
		engineRepository.deleteById(id);
	}

	public Engine addOneEngine(Engine addEngine) {
		return engineRepository.save(addEngine);
	}
	
	
	
}
