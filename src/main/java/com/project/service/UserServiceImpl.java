package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.DAO.LoginDAO;
import com.project.DAO.UserDAO;
import com.project.model.LoginVO;
import com.project.model.UserVO;
import com.project.utils.Basemethods;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private LoginDAO loginDAO;

	@Override
	public List<UserVO> findAll() {
		return this.userDAO.findAll();
	}

	@Override
	public void deleteUser(int id) {
		List<UserVO> ls = this.userDAO.findById(id);
		UserVO userVO = ls.get(0);

		userVO.setStatus(false);
		this.userDAO.saveUser(userVO);
	}

	@Override
	public void saveUser(UserVO userVO) {

		System.out.println(userVO.getUsername());

		if (userVO.getId() > 0) {

			List<LoginVO> ls = this.loginDAO.findById(userVO.getLoginVO().getId());
			LoginVO loginVO = ls.get(0);
			userVO.setUsername(loginVO.getUsername());

		} else {

			LoginVO loginVO = new LoginVO();

			loginVO.setEnabled("1");
			loginVO.setUsername(userVO.getUsername());
			loginVO.setPassword("password");
			loginVO.setRole("ROLE_USER");

			this.loginDAO.save(loginVO);

			userVO.setLoginVO(loginVO);

			// SEND MAIL TO USER
			Basemethods.sendMail("Welcome to I-Repo", "You have been successfully register in i-repo.",
					userVO.getEmail());
		}

		this.userDAO.saveUser(userVO);

	}

	@Override
	public List<UserVO> findById(int id) {
		return this.userDAO.findById(id);
	}

}