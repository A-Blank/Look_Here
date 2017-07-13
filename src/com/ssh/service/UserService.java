package com.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.UserDao;
import com.ssh.entity.User;

@Service
@Transactional
public class UserService {

	@Autowired private UserDao userDao;
	
	public void addUser(User user){
		userDao.addUser(user);
	}
	
	public void deleteUser(User user){
		userDao.deleteUser(user);
	}
	
	public void updateUser(User user){
		userDao.updateUser(user);
	}
	
	public List<User> getUsers(){
		return userDao.getUsers();
	}
	
	public User getUserById(String id){
		return userDao.getUserById(id);
	}

	public boolean register(User user) {
		return userDao.register(user);
	}

	public User login(User user) {
		return userDao.login(user);	
	}
}
