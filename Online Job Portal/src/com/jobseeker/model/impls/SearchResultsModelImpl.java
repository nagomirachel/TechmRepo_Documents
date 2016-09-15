package com.jobseeker.model.impls;

import java.util.List;

import com.jobseeker.beans.JobsBean;
import com.jobseeker.dao.interfaces.SearchResultsDao;

import com.jobseeker.dao.impls.SearchResultsDaoImpls;
import com.jobseeker.model.interfaces.SearchResultsModel;
public class SearchResultsModelImpl implements SearchResultsModel {
	public List<JobsBean> display_details(JobsBean jb){
		SearchResultsDao srModel=new SearchResultsDaoImpls();
		List<JobsBean> employees = srModel.display_details(jb);
		return employees;
	}
}
