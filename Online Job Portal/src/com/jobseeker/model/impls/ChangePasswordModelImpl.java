package com.jobseeker.model.impls;

import com.jobseeker.beans.LoginBean;
import com.jobseeker.dao.impls.ChangePasswordDaoImpls;

import com.jobseeker.dao.interfaces.ChangePasswordDao;


import com.jobseeker.model.interfaces.ChangePasswordModel;

public class ChangePasswordModelImpl implements ChangePasswordModel{
	public boolean changePassword(LoginBean lb) {
		ChangePasswordDao changepass=new ChangePasswordDaoImpls();
		boolean status = changepass.changePassword(lb);

		return status;
	}
}
