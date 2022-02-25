package com.shnfirat.CarApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shnfirat.CarApp.entities.CarBrand;

public interface ICarBrandRepository extends JpaRepository<CarBrand, Long> {

}
