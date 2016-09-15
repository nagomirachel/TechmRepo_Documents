package com.jobseeker.model.impls;

import com.jobseeker.beans.JobSeekerBean;
import com.jobseeker.dao.impls.RegistrationDaoImpls;
import com.jobseeker.dao.interfaces.RegistrationDao;
import com.jobseeker.model.interfaces.RegistrationModel;
public class RegistrationModelImpl implements RegistrationModel{
	public boolean register_details(JobSeekerBean jb) {
		RegistrationDao registrationDao=new RegistrationDaoImpls();
		boolean status = registrationDao.register_details(jb);
		return status;
	}
}
