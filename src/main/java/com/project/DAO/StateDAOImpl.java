package com.project.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.StateVO;
import com.project.model.UserVO;

@Repository
@Transactional
public class StateDAOImpl implements StateDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveState(StateVO stateVO) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(stateVO);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public List<StateVO> findStates() {
		List<StateVO> ls = new ArrayList();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from StateVO where status = true");
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public List<StateVO> findById(int id) {
		List<StateVO> ls = new ArrayList<StateVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from StateVO where status = true and id = " + id);
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ls;
	}
}