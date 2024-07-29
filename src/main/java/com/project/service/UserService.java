package com.project.service;

import java.util.List;

import com.project.model.UserVO;

public interface UserService {

	List<UserVO> findAll();

	void deleteUser(int id);

	void saveUser(UserVO userVO);

	List<UserVO> findById(int id);

}
