package com.jobseeker.model.impls;

import java.util.List;

import com.jobseeker.beans.AppliedJobs;
import com.jobseeker.dao.impls.ViewAppliedJobsDaoImpl;
import com.jobseeker.dao.interfaces.ViewAppliedJobsDao;
import com.jobseeker.model.interfaces.ViewAppliedJobsModel;

public class ViewAppliedJobsModelImpls implements ViewAppliedJobsModel{
@Override
public List<AppliedJobs> viewAppliedJobs(AppliedJobs aj) {
	ViewAppliedJobsDao va=new ViewAppliedJobsDaoImpl();
	List<AppliedJobs> list=va.viewAppliedJobs(aj);
	return list;
}
}
