package com.project.DAO;

import java.util.List;

import com.project.model.UserVO;

public interface UserDAO {

	List findAll();

	List<UserVO> findById(int id);

	void save(UserVO userVO);

}
