package com.jobseeker.dao.interfaces;
import java.util.*;

import com.jobseeker.beans.JobsBean;

public interface SearchResultsDao {
	public List<JobsBean> display_details(JobsBean jb);
	String qry="select * from jobs_np where location=? and domain=? and qualification=?";
	String qry1="select * from jobs_np where location=? ";
	String qry2="select * from jobs_np where domain=?";
	String qry3="select * from jobs_np where qualification=?";
	String qry4="select * from jobs_np where location=? and domain=?";
	String qry5="select * from jobs_np where domain=? and qualification=?";
	String qry6="select * from jobs_np where location=? and qualification=?";


}
