package com.jobseeker.dao.interfaces;

import java.util.List;

import com.jobseeker.beans.AppliedJobs;

public interface ViewAppliedJobsDao {
	List<AppliedJobs> viewAppliedJobs(AppliedJobs aj);
	String query="select job_id,job_title,domain,apply_date from appliedjobs_np where reg_id=?";
}
