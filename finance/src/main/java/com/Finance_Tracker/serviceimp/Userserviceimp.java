package com.Finance_Tracker.serviceimp;

import java.util.List;

import com.Finance_Tracker.User;
import com.Finance_Tracker.daoimp.Userdaoimp;
import com.Finance_Tracker.service.Userservice;
import com.Finance_Tracker.Dao.UserDao;

public class Userserviceimp implements Userservice {

	UserDao userDao = new Userdaoimp();
	
	@Override
	public User createUser(User user) {
		//invoke daoimple method to save student object
		return userDao.createUser(user);
	}

	@Override
	public List<User> getAllUsers() {
	
		return userDao.getAllUsers();
	}

	@Override
	public User getUser(int u_id) {
		// TODO Auto-generated method stub
		return userDao.getUser(u_id);
	}

	@Override
	public User updateUser(int u_id, User updatedUser) {
		// TODO Auto-generated method stub
		return userDao.updateUser(u_id,updatedUser);
	}

	@Override
	public boolean deleteUser(int u_id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(u_id);
	}

}
