package com.shnfirat.CarApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shnfirat.CarApp.entities.Wheel;

public interface IWheelRepository extends JpaRepository<Wheel, Long> {

}
