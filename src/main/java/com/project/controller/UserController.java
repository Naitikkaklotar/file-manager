
package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.UserVO;
import com.project.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("admin/users")
	public ModelAndView users() {
		List<UserVO> userList = this.userService.findAll();
		return new ModelAndView("admin/viewUsers", "UserVO", new UserVO()).addObject("userList", userList);
	}

	@GetMapping("admin/deleteUser")
	public ModelAndView deleteUser(@RequestParam int id) {
		this.userService.deleteUser(id);
		return new ModelAndView("redirect:/admin/users");
	}
	
	@PostMapping("admin/saveUser")
	public ModelAndView saveUser(@ModelAttribute UserVO userVO) {
		this.userService.saveUser(userVO);
		
		return new ModelAndView("redirect:/admin/users","UserVO", new UserVO());
	}
	
	@GetMapping("admin/editUser")
	public ModelAndView Edit(@ModelAttribute UserVO userVO, @RequestParam int id){
		
		userVO.setId(id);
		List editList = this.userService.edit(userVO);
		
		return new ModelAndView("admin/viewUsers","UserVO",editList.get(0));
	}



}
