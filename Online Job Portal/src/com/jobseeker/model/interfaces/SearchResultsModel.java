package com.jobseeker.model.interfaces;

import java.util.List;

import com.jobseeker.beans.JobsBean;

public interface SearchResultsModel {
	public List<JobsBean> display_details(JobsBean jb);
}
