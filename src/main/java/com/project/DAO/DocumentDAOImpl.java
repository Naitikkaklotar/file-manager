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

import com.project.model.DocumentVO;
import com.project.model.UserVO;

@Repository
@Transactional
public class DocumentDAOImpl implements DocumentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveDocument(DocumentVO documentVO) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(documentVO);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public List<DocumentVO> findByParentId(Integer id) {
		List<DocumentVO> ls = new ArrayList<DocumentVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from DocumentVO where parent_id = " + id);
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ls;
	}

}
