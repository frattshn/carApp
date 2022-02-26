package com.shnfirat.CarApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shnfirat.CarApp.model.Engine;

public interface IEngineRepository extends JpaRepository<Engine, Long> {

}
