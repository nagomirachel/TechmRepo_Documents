package com.jobseeker.service.impls;

import com.jobseeker.beans.LoginBean;
import com.jobseeker.model.impls.ChangePasswordModelImpl;

import com.jobseeker.model.interfaces.ChangePasswordModel;
import com.jobseeker.service.interfaces.ChangePasswordService;


public class ChangePasswordServiceImpl implements ChangePasswordService{
	public boolean changePassword(LoginBean lb) {
		
		ChangePasswordModel changepass=new ChangePasswordModelImpl();
		boolean status=changepass.changePassword(lb);
		return status;
	}
}
