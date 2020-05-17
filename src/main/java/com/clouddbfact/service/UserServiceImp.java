package com.clouddbfact.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clouddbfact.dao.UserDao;
import com.clouddbfact.model.User;

@Service
@Transactional
public class UserServiceImp implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImp.class);

	@Autowired
	UserDao userDao;

	public List<User> getUser() {
		LOGGER.info("getUser in UserServiceImp called");
		return userDao.getUser();
	}

	public User findById(int id) {
		LOGGER.info("findById in UserServiceImp called");
		return userDao.findById(id);
	}

	public void createUser(User user) {
		LOGGER.info("createUser in UserServiceImp called");
		userDao.addUser(user);
	}

	public void deleteUserById(int id) {
		LOGGER.info("deleteUserById in UserServiceImp called");
		userDao.delete(id);
	}

	@Override
	public User updatePartially(User user, int id) {
		LOGGER.info("updatePartially in UserServiceImp called");
		userDao.updateCountry(user, id);
		return userDao.findById(id);
	}

	@Override
	public User update(User user, int id) {
		LOGGER.info("update in UserServiceImp called");
		return userDao.update(user, id);
	}

}
