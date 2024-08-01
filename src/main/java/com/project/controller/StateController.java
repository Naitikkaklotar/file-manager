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
import com.project.model.StateVO;
import com.project.service.StateService;


@Controller
public class StateController {

	@Autowired
	StateService stateService;
	
	@GetMapping("admin/states")
	public ModelAndView states() {
		List<StateVO> stateList = stateService.findStates();
		return new ModelAndView("admin/ViewStates", "StateVO", new StateVO()).addObject("stateList", stateList);
	}
	
	@PostMapping("admin/saveState")
	public ModelAndView saveState(@ModelAttribute StateVO stateVO){
		this.stateService.saveState(stateVO);
		return new ModelAndView("redirect:/admin/states", "StateVO", new StateVO());
	}
	
	@GetMapping("admin/deleteState")
	public ModelAndView deleteState(@RequestParam int id) {
		this.stateService.deleteState(id);
		return new ModelAndView("redirect:/admin/states");
	}
	
	@GetMapping("admin/findByState")
	public ResponseEntity<StateVO> findByState(@RequestParam int id){
		List<StateVO> stateList = this.stateService.findByState(id);
		return new ResponseEntity<StateVO>(stateList.get(0),HttpStatus.OK);
	}
}