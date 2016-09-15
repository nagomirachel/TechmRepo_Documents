package com.jobseeker.model.impls;

import com.jobseeker.beans.AppliedJobs;
import com.jobseeker.dao.impls.AppliedJobDaoImpl;
import com.jobseeker.dao.interfaces.AppliedJobDao;
import com.jobseeker.model.interfaces.AppliedJobModel;

public class AppliedJobModelImpl implements AppliedJobModel {
@Override
public String apply_Job(AppliedJobs aj) {
	AppliedJobDao aDao=new AppliedJobDaoImpl();
	String msg=aDao.apply_Job(aj);
	return msg;
}
}
