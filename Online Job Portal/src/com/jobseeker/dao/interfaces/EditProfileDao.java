package com.jobseeker.dao.interfaces;

import com.jobseeker.beans.JobSeekerBean;

public interface EditProfileDao {
	public boolean edit_details(JobSeekerBean jb);
	String qry="update jobseeker_np set first_name=?,last_name=?,middle_name=?,dob=?,gender=?,marital_status=?,first_high_qual=?,second_qual=?,experience=?,first_employer=?,mob_no=?,phone_no=?,Current_address=?,state=?,city=?,pincode=?,email_id=?,skill1=?,skill2=?,skill3=? where user_name=?";
}
