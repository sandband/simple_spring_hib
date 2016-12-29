package org.sandeep.hello.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sandeep.hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDao {
	private SessionFactory sessionFactory;

	public UserDao() {
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (Exception e) {
			return sessionFactory.openSession();
		}
	}

	public List<User> findAll() {
		return currentSession().createQuery("select u from User u", User.class)
				.getResultList();
	}
}
