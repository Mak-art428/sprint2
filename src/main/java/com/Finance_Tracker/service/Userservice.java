package com.Finance_Tracker.service;

import java.util.List;

import com.Finance_Tracker.User;

public interface Userservice 
{
	User createUser(User user);
	List<User> getAllUsers();
    User getUser(int u_id);
	User updateUser(int u_id,User updatedUser);
	boolean deleteUser(int u_id);
}
