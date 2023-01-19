package com.app.inventory.repository;



import java.util.List;

import com.app.inventory.models.JobTitle;
import com.app.inventory.models.User;
import com.app.inventory.utils.ExceptionUtil;



public interface UserRepository{
	
	List<User> getAllUser() throws ExceptionUtil;
	
	List<User> getUserByJobTitle(JobTitle jobTitle) throws ExceptionUtil;
	
	User getUserById(Integer id) throws ExceptionUtil;
	
	void deleteUserById(Integer id) throws ExceptionUtil;
	
	Integer createUser(User user) throws ExceptionUtil;
	
	void updateUser(User user) throws ExceptionUtil;
	
	User validationUser(User user) throws ExceptionUtil;

	List<User> getUserListByID();
	
}
