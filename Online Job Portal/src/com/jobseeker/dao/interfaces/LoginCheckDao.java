package com.jobseeker.dao.interfaces;



import com.jobseeker.beans.LoginBean;

public interface LoginCheckDao {

	String user_qry = "select * from login_np where user_name=? AND password=?";

	boolean validateUser(LoginBean lb);

}
