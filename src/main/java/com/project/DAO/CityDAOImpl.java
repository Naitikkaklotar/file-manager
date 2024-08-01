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

import com.project.model.CityVO;

@Repository
@Transactional
public class CityDAOImpl implements CityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveCity(CityVO cityVO) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(cityVO);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public List findCity() {
		List ls = new ArrayList();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from CityVO where status = true");
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public List<CityVO> findById(int id) {
		List<CityVO> ls = new ArrayList<CityVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from CityVO where status = true and id = " + id);
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public List<CityVO> getCityByState(int id) {
		List<CityVO> ls = new ArrayList<CityVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from CityVO where status = true and stateVO = " + id);
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ls;

	}

}