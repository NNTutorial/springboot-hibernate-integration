package com.nishant.springboot.hibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nishant.springboot.hibernate.Entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;


	@Autowired	
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<User> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User getUserByID(Integer id) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where userid = :userid").setInteger("userid", id).list().get(0);
	}

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}


}
