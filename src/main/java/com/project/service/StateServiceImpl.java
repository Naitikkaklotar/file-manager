package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.DAO.StateDAO;
import com.project.model.CityVO;
import com.project.model.StateVO;
import com.project.model.UserVO;

@Service
@Transactional
public class StateServiceImpl implements StateService {

	@Autowired
	private StateDAO stateDAO;

	@Override
	public List<StateVO> findStates() {
		return this.stateDAO.findStates();
	}

	@Override
	public void saveState(StateVO stateVO) {
		this.stateDAO.saveState(stateVO);
		
	}
	
	@Override
	public void deleteState(int id) {
		List<StateVO> ls = this.stateDAO.findById(id);
		StateVO stateVO = ls.get(0);

		stateVO.setStatus(false);
		this.stateDAO.saveState(stateVO);
	}

	@Override
	public List<StateVO> findByState(int id) {
		return this.stateDAO.findById(id);
	}
}