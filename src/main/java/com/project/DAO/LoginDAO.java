package com.project.DAO;

import java.util.List;

import com.project.model.LoginVO;

public interface LoginDAO {

	void save(LoginVO loginVO);

	List<LoginVO> findById(int id);

}
