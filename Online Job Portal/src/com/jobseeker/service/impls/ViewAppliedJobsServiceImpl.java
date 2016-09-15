package com.jobseeker.service.impls;

import java.util.List;

import com.jobseeker.beans.AppliedJobs;
import com.jobseeker.model.impls.ViewAppliedJobsModelImpls;
import com.jobseeker.model.interfaces.ViewAppliedJobsModel;
import com.jobseeker.service.interfaces.ViewAppliedJobsService;

public class ViewAppliedJobsServiceImpl implements ViewAppliedJobsService{
@Override
public List<AppliedJobs> viewAppliedJobs(AppliedJobs aj) {
	ViewAppliedJobsModel va=new ViewAppliedJobsModelImpls();
	List<AppliedJobs> list=va.viewAppliedJobs(aj);
	return list;
}
}
