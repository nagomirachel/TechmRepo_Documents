package com.jobseeker.model.impls;
import com.jobseeker.model.interfaces.LoginCheckModel;
import com.jobseeker.beans.LoginBean;
import com.jobseeker.dao.impls.LoginCheckDaoImpls;
import com.jobseeker.dao.interfaces.LoginCheckDao;

public class LoginCheckModelImpl implements LoginCheckModel{
	public boolean validateUser(LoginBean lb) {
		LoginCheckDao loginDao = new LoginCheckDaoImpls();
		boolean status = loginDao.validateUser(lb);

		return status;
	}
	
}
