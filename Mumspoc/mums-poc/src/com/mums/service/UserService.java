package com.mums.service;

import java.util.List;

import com.mums.bean.UserBean;
import com.mums.model.User;


public interface UserService {
	
	public void addEmployee(User user);

	public List<User> listEmployeess();
	
	public User getEmployee(String cdsId);

	public void addEmpnew(User user);
	
	public List<User> getAllEmpId();
	
	public List<User> searchEmployee(UserBean userBean);

	public List<User> searchUser(String documentGroupId);

	public List<User> searchEmployee(User user);
	
	//Webservice
	public void addUser(User user);

	public List<UserBean> searchUser(UserBean userBean);
	
	public void editUser(String cdsId,String firstName,String lastName);

	public void deleteUser(User user);
}
