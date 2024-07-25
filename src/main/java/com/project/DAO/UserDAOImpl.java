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
	
	public void saveUser(UserVO userVO){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(userVO);
	}

	public List<UserVO> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from UserVO where status = true");
		return q.list();
	}
	
	public List<UserVO> findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from UserVO where status = true and id = " + id);
		return q.list();
	}
	
	@Override
	public List edit(UserVO userVO) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from UserVO where id=" + userVO.getId());

		List ls = q.list();

		return ls;
	}


	

}
