package com.jobseeker.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jobseeker.beans.JobsBean;
import com.jobseeker.dao.interfaces.PostJobsDao;
import com.jobseeker.dao.utils.DBUtil;

public class PostJobsDaoImpls implements PostJobsDao{
	Connection con=null;
	@Override
	public boolean post_jobs(JobsBean jb) {

		try{
			con=DBUtil.getConnection();
			PreparedStatement pr=con.prepareStatement(query);
			pr.setInt(1, jb.getJob_id());
			pr.setInt(2,jb.getExperience());
			pr.setString(3, jb.getDescription());
			pr.setString(4,jb.getLocation());
			pr.setString(5,jb.getQualification());
			pr.setDouble(6, jb.getSalary());
			pr.setString(7, jb.getDomain());
			pr.setString(8,jb.getJob_title());
			int i=pr.executeUpdate();
			con.commit();
			if(i!=0){
				return true;
			}
		}
		catch (Exception e) {
			System.out.println("Post JobException "+e);
		}
		finally{

			DBUtil.closeConnection();
		}

		return false;
	}

}
