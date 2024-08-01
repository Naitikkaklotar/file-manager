package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.CityVO;
import com.project.service.CityService;
import com.project.service.StateService;

@Controller
public class CityController {

	@Autowired
	private CityService cityService;
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("admin/city")
	public ModelAndView city() {
		List<CityVO> cityList = cityService.findCity();
		List stateList = stateService.findStates();
		return new ModelAndView("admin/ViewCity", "CityVO", new CityVO())
				.addObject("cityList", cityList).addObject("stateList", stateList);
	}

	@PostMapping("admin/saveCity")
	public ModelAndView saveCity(@ModelAttribute CityVO cityVO){
		this.cityService.saveCity(cityVO);
		return new ModelAndView("redirect:/admin/city", "CityVO", new CityVO());
	}

	@GetMapping("admin/deleteCity")
	public ModelAndView deleteCity(@RequestParam int id) {
		this.cityService.deleteCity(id);
		return new ModelAndView("redirect:/admin/city");
	}
	
	@GetMapping("admin/findByCity")
	public ResponseEntity<CityVO> findByCity(@RequestParam int id){
		List<CityVO> cityList = this.cityService.findByCity(id);
		return new ResponseEntity<CityVO>(cityList.get(0),HttpStatus.OK);
	}
	
	@GetMapping("admin/getCityByState")
	public ResponseEntity<List> getCityByState(@RequestParam int id){
		List<CityVO> cityList = this.cityService.getCityByState(id);
		return new ResponseEntity<List>(cityList,HttpStatus.OK);
	}
	
	
	
}