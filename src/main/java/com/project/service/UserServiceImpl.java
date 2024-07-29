package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.DAO.UserDAO;
import com.project.model.UserVO;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

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
	public void saveUser(UserVO userVO){
		this.userDAO.saveUser(userVO);
	}


	@Override
	public List<UserVO> findById(int id) {
		return this.userDAO.findById(id);
	}
	
}