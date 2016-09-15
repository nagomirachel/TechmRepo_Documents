package com.mums.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mums.bean.UserBean;
import com.mums.dao.UserDao;
import com.mums.model.User;

@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmployee(User user) {
		userDao.addEmployee(user);
	}
	
	public List<User> listEmployeess() {
		return userDao.listEmployeess();
	}

	public User getEmployee(String cdsId) {
		return userDao.getEmployee(cdsId);
	}


	@Override
	public void addEmpnew(User user) {
		// TODO Auto-generated method stub
		userDao.addEmpnew(user);
		
	}

	@Override
	public List<User> searchEmployee(UserBean userBean) {
		// TODO Auto-generated method stub
		List<User> users =  userDao.searchEmployee(userBean);
		List<UserBean> userList = new ArrayList<UserBean>(0);
		UserBean bean = null;
		for (User user : users) {
			bean = new UserBean();
			bean.setCdsId(user.getCdsId());
			userList.add(bean);
		}
		
		//return userList; 
		return userDao.searchEmployee(userBean);
	}

	@Override
	public List<User> getAllEmpId() {
		// TODO Auto-generated method stubs
		return userDao.getAllEmpId();
	}

	@Override
	public List<User> searchUser(String documentGroupId) {
		// TODO Auto-generated method stub
		return userDao.searchEmployee(documentGroupId);
	}

	@Override
	public List<User> searchEmployee(User user) {
		// TODO Auto-generated method stub
		return userDao.searchEmployee(user);
		
	}

	/**Webservice Methods**/
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
		
	}
		@Override
		public List<UserBean> searchUser(UserBean userBean) {
			// TODO Auto-generated method stub
			List<User> users =  userDao.searchUser(userBean);
			List<UserBean> userList = new ArrayList<UserBean>(0);
			UserBean bean = null;
			for (User user : users) {
				bean = new UserBean();
				bean.setCdsId(user.getCdsId());
				bean.setFirstName(user.getFirstName());
				bean.setLastName(user.getLastName());
				userList.add(bean);
			}
			return userList; 
		
	}
		public void editUser(String cdsId, String firstName, String lastName) {
			// TODO Auto-generated method stub
			userDao.editUser(cdsId,firstName,lastName);
		}
		
		
		public void deleteUser(User user) {
			userDao.deleteUser(user);
		
			
		}


}
