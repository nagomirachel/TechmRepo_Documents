package com.jobseeker.dao.interfaces;

import com.jobseeker.beans.LoginBean;

public interface ChangePasswordDao {
	String cpass_qry="update login_np set password=? where user_name=? and password=?";
	String cpass_qry1="update jobseeker_np set password=? where user_name=? and password=?";
	boolean changePassword(LoginBean lb);
}
