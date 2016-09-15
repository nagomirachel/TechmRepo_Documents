package com.jobseeker.service.impls;

import com.jobseeker.beans.JobSeekerBean;
import com.jobseeker.model.impls.EditProfileModelImpl;
import com.jobseeker.model.interfaces.EditProfileModel;
import com.jobseeker.service.interfaces.EditProfileService;

public class EditProfileServiceImpl implements EditProfileService  {
	@Override
	public boolean edit_details(JobSeekerBean jb) {

		EditProfileModel editModel=new EditProfileModelImpl();
		boolean status=editModel.edit_details(jb);
		return status;
			
		
	}

}
