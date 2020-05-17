package com.clouddbfact.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clouddbfact.model.User;

@Repository
public class UserDaoImp implements UserDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImp.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(User user) {
		LOGGER.info("addUser of UserDaoImp called");
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	public List<User> getUser() {
		LOGGER.info("getUser of UserDaoImp called");
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<User> list = session.createCriteria(User.class).list();
		return list;
	}

	public User findById(int id) {
		LOGGER.info("findById of UserDaoImp called");
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

	public User update(User val, int id) {
		LOGGER.info("update of UserDaoImp called");
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		user.setCountry(val.getCountry());
		user.setName(val.getName());
		session.update(user);
		return user;
	}

	public void delete(int id) {
		LOGGER.info("delete of UserDaoImp called");
		Session session = sessionFactory.getCurrentSession();
		User user = findById(id);
		session.delete(user);
	}

	@Override
	public User updateCountry(User val, int id) {
		LOGGER.info("updateCountry of UserDaoImp called");
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, id);
		user.setCountry(val.getCountry());
		return user;
	}

}
