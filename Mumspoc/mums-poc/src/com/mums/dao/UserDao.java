package com.mums.dao;

import java.util.List;

import com.mums.bean.UserBean;
import com.mums.model.User;

/**
 * @author Dinesh Rajput
 *
 */
public interface UserDao {
	
	public void addEmployee(User user);

	public List<User> listEmployeess();
	
	public User getEmployee(String cdsId);
	
	public void deleteEmployee(User user);

	public void addEmp(String cdsId, String firstName, String lastName);

	public void addEmp(User user);

	public void addEmpnew(User user);
	
	public List<User> searchEmployee(UserBean userBean);

	public List<User> getAllEmpId();

	public List<User> searchEmployee(String cdsId);

	public List<User> searchEmployee(User user);
	
	
	//Webservice
	public void addUser(User user);

	public List<User> searchUser(UserBean userBean);
	
	public void editUser(String cdsId,String firstName,String lastName);

	public void deleteUser(User user);



}
