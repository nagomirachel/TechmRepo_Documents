package com.jobseeker.service.impls;

import java.util.List;

import com.jobseeker.beans.JobsBean;
import com.jobseeker.model.impls.SearchResultsModelImpl;
import com.jobseeker.model.interfaces.SearchResultsModel;
import com.jobseeker.service.interfaces.SearchResultsService;

public class SearchResultsServiceImpl implements SearchResultsService {
	@Override
	public List<JobsBean> display_details(JobsBean jb) {
		SearchResultsModel srModel=new SearchResultsModelImpl();
		List<JobsBean> employees = srModel.display_details(jb);
		return employees;
	}

}
