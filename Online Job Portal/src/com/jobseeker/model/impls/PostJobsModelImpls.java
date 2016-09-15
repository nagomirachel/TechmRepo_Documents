package com.jobseeker.model.impls;

import com.jobseeker.beans.JobsBean;
import com.jobseeker.dao.impls.PostJobsDaoImpls;
import com.jobseeker.dao.interfaces.PostJobsDao;
import com.jobseeker.model.interfaces.PostJobsModel;


public class PostJobsModelImpls implements PostJobsModel {
	@Override
	public boolean post_jobs(JobsBean jb) {
		PostJobsDao pd=new PostJobsDaoImpls();
		boolean status=pd.post_jobs(jb);
		return status;
	}

}
