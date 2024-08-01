
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

import com.project.model.StateVO;
import com.project.model.UserVO;
import com.project.service.StateService;
import com.project.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private StateService stateService;

	@GetMapping("admin/users")
	public ModelAndView users() {
		List<UserVO> userList = userService.findAll();
		List<StateVO> stateList = stateService.findStates();
		return new ModelAndView("admin/viewUsers", "UserVO", new UserVO()).addObject("userList", userList)
				.addObject("stateList", stateList);
	}

	@GetMapping("admin/deleteUser")
	public ModelAndView deleteUser(@RequestParam int id) {
		this.userService.deleteUser(id);
		return new ModelAndView("redirect:/admin/users");
	}

	@PostMapping("admin/saveUser")
	public ModelAndView saveUser(@ModelAttribute UserVO userVO) {
		this.userService.saveUser(userVO);
		return new ModelAndView("redirect:/admin/users", "UserVO", new UserVO());
	}

	@GetMapping("admin/findById")
	public ResponseEntity findById(@RequestParam int id) {
		List<UserVO> editList = this.userService.findById(id);
		return new ResponseEntity(editList.get(0), HttpStatus.OK);
	}

}
