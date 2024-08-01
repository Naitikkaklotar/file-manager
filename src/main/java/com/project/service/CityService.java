package com.project.service;

import java.util.List;

import com.project.model.CityVO;

public interface CityService {

	List<CityVO> findCity();
	
	void saveCity(CityVO cityVO);

	void deleteCity(int id);
	
	List<CityVO> findByCity(int id);

	List<CityVO> getCityByState(int id);
}