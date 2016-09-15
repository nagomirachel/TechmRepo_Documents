package com.jobseeker.dao.interfaces;


import com.jobseeker.beans.JobsBean;

public interface PostJobsDao {
	public boolean post_jobs(JobsBean jb);
	String query="insert into jobs_np values(?,?,?,?,?,?,?,?)";
}
