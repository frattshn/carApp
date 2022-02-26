package com.shnfirat.CarApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shnfirat.CarApp.model.Model;

public interface IModelRepository extends JpaRepository<Model, Long> {

}
