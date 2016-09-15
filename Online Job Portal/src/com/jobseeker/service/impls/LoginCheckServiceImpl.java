package com.jobseeker.service.impls;

import com.jobseeker.beans.LoginBean;
import com.jobseeker.model.impls.LoginCheckModelImpl;
import com.jobseeker.model.interfaces.LoginCheckModel;
import com.jobseeker.service.interfaces.LoginCheckService;
public class LoginCheckServiceImpl implements LoginCheckService {
public boolean validateUser(LoginBean lb) {
		
		LoginCheckModel loginModel=new LoginCheckModelImpl();
		boolean status=loginModel.validateUser(lb);
		return status;
	}

}
