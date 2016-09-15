package com.jobseeker.service.impls;

import com.jobseeker.beans.JobSeekerBean;
import com.jobseeker.model.impls.RegistrationModelImpl;
import com.jobseeker.model.interfaces.RegistrationModel;
import com.jobseeker.service.interfaces.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {
@Override
public boolean register_details(JobSeekerBean jb) {
	RegistrationModel registrationModel=new RegistrationModelImpl();
	boolean status=registrationModel.register_details(jb);
	return status;
}
}
