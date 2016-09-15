package com.jobseeker.service.impls;

import com.jobseeker.beans.AppliedJobs;
import com.jobseeker.model.impls.AppliedJobModelImpl;
import com.jobseeker.model.interfaces.AppliedJobModel;
import com.jobseeker.service.interfaces.AppliedJobService;

public class AppliedJobServiceImpl implements AppliedJobService {
@Override
public String apply_Job(AppliedJobs aj) {
	AppliedJobModel aModel=new AppliedJobModelImpl();
	String msg=aModel.apply_Job(aj);
	return msg;
}
}
