package com.project.service;

import java.util.List;

import com.project.model.StateVO;
import com.project.model.UserVO;

public interface StateService {
	
	List<StateVO> findStates();

	void deleteState(int id);

	void saveState(StateVO stateVO);

	List<StateVO> findByState(int id);

}