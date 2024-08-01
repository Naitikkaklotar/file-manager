package com.project.DAO;

import java.util.List;

import com.project.model.CityVO;
import com.project.model.StateVO;

public interface StateDAO {

	List<StateVO> findStates();
	
	void saveState(StateVO stateVO);
	
	List<StateVO> findById(int id);


}