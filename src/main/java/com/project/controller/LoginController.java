package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.LoginService;
import com.project.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@Autowired
	private LoginService loginService;

	@GetMapping({ "/", "login" })
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@GetMapping("admin/index")
	public ModelAndView adminIndex() {
		return new ModelAndView("admin/index");
	}

	@GetMapping("user/index")
	public ModelAndView userIndex() {
		return new ModelAndView("user/index");
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.POST, RequestMethod.GET })
	public String viewUserDetails(ModelMap model, HttpServletResponse response, HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			request.getSession().invalidate();
			request.getSession().setAttribute("tempStatus", "success");
			request.getSession().setAttribute("statusText", "Logout Successfully!");
		}
		return "login";
	}

	/*
	 * @GetMapping("admin/login") public ModelAndView findUsername() { List
	 * loginList = loginService.findUsername(); List userList =
	 * userService.findAll(); return new ModelAndView("admin/ViewUsers",
	 * "LoginVO", new LoginVO()) .addObject("loginList",
	 * loginList).addObject("userList", userList); }
	 */

}
