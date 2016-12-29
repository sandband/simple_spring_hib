package org.sandeep.hello.service;

import java.util.List;

import org.sandeep.hello.dao.UserDao;
import org.sandeep.hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private UserDao userDao;

	public UserService() {
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<User> getAllUsers()
	{
		return userDao.findAll();
	}
}
