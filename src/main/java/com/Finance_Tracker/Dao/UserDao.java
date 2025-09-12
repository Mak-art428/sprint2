package com.Finance_Tracker.Dao;

import java.util.List;
import com.Finance_Tracker.User;

public interface UserDao 
{
	User createUser(User user);
	List<User> getAllUsers();
    User getUser(int u_id);
	User updateUser(int u_id,User updatedUser);
	boolean deleteUser(int u_id);
}
