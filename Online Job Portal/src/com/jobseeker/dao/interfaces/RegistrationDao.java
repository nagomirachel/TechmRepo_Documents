package com.jobseeker.dao.interfaces;

import com.jobseeker.beans.JobSeekerBean;

public interface RegistrationDao {
	public boolean register_details(JobSeekerBean jb);
	String qry="insert into jobseeker_np values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	String qry2="insert into login_np values(?,?)";
}
