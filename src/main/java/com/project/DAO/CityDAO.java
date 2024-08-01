package com.project.DAO;

import java.util.List;

import com.project.model.CityVO;

public interface CityDAO {

	List findCity();

	void saveCity(CityVO cityVO);

	List<CityVO> findById(int id);

	List<CityVO> getCityByState(int id);

}