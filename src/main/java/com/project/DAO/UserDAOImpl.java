package com.project.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	public void save(UserVO uservo){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(uservo);
	}

	public List findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from UserVO where status = true");
		return q.list();
	}
	
	public List<UserVO> findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from UserVO where status = true and id = " + id);
		return q.list();
	}
	

}
