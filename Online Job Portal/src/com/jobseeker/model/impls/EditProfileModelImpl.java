package com.jobseeker.model.impls;

import com.jobseeker.beans.JobSeekerBean;
import com.jobseeker.dao.impls.EditProfileDaoImpl;
import com.jobseeker.dao.interfaces.EditProfileDao;
import com.jobseeker.model.interfaces.EditProfileModel;

public class EditProfileModelImpl implements EditProfileModel {
	@Override
	public boolean edit_details(JobSeekerBean jb) {
		EditProfileDao editprofileDao=new EditProfileDaoImpl();
		boolean status = editprofileDao.edit_details(jb);
		return status;
		
	}

}
