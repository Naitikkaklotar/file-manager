package com.project.DAO;

import java.util.List;

import com.project.model.UserVO;

public interface UserDAO {

	List<UserVO> findAll();

	List<UserVO> findById(int id);

	void saveUser(UserVO userVO);

}
