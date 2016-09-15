package com.jobseeker.service.impls;

import com.jobseeker.beans.JobsBean;
import com.jobseeker.model.impls.PostJobsModelImpls;
import com.jobseeker.model.interfaces.PostJobsModel;
import com.jobseeker.service.interfaces.PostJobsService;

public class PostJobsServiceImpls implements PostJobsService{
	@Override
	public boolean post_jobs(JobsBean jb) {
		PostJobsModel pm=new PostJobsModelImpls();
		boolean status=pm.post_jobs(jb);
		return status;
	}
}
