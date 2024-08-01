package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.DAO.CityDAO;
import com.project.model.CityVO;

@Service
@Transactional
public class CityServiceImpl implements CityService {

	@Autowired
	CityDAO cityDAO;
	
	@Override
	public List<CityVO> findCity() {
		return this.cityDAO.findCity();
	}

	@Override
	public void saveCity(CityVO cityVO) {
		this.cityDAO.saveCity(cityVO);
		
	}

	@Override
	public void deleteCity(int id) {
		List<CityVO> ls = this.cityDAO.findById(id);
		CityVO cityVO = ls.get(0);

		cityVO.setStatus(false);
		this.cityDAO.saveCity(cityVO);
	}
	
	@Override
	public List<CityVO> findByCity(int id) {
		return this.cityDAO.findById(id);
	}

	@Override
	public List<CityVO> getCityByState(int id) {
		return this.cityDAO.getCityByState(id);
	}

}