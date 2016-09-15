package com.jobseeker.dao.interfaces;

import com.jobseeker.beans.AppliedJobs;

public interface AppliedJobDao {
	public String apply_Job(AppliedJobs aj);
	public boolean checkCount(AppliedJobs aj);
	public boolean Job_Id_Check(AppliedJobs aj);
	public boolean domain_Check(AppliedJobs aj);
}
