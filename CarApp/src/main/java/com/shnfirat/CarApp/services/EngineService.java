package com.shnfirat.CarApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shnfirat.CarApp.entities.Engine;
import com.shnfirat.CarApp.repository.IEngineRepository;

@Service
public class EngineService {
	
	private IEngineRepository engineRepository;

	public EngineService(IEngineRepository engineRepository) {
		this.engineRepository = engineRepository;
	}

	public List<Engine> getAllEngines() {
		return engineRepository.findAll();
	}

	public Engine getOneEngineById(Long id) {
		return engineRepository.findById(id).orElse(null);
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
