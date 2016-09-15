package com.jobseeker.service.interfaces;
import com.jobseeker.beans.LoginBean;
public interface LoginCheckService {
	boolean validateUser(LoginBean lb);
	
}
