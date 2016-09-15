package com.jobseeker.dao.impls;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.jobseeker.beans.AppliedJobs;
import com.jobseeker.dao.interfaces.ViewAppliedJobsDao;
import com.jobseeker.dao.utils.DBUtil;

public class ViewAppliedJobsDaoImpl implements ViewAppliedJobsDao{
	ResultSet rs=null;
	Connection con=null;

	@Override

	public List<AppliedJobs> viewAppliedJobs(AppliedJobs aj1) {

		try {
			List<AppliedJobs> jobs=new ArrayList<AppliedJobs>();
			con=DBUtil.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, aj1.getReg_id());
			rs=ps.executeQuery();
			con.commit();
			while(rs.next()){
				System.out.println("inside dao");
				AppliedJobs aj=new AppliedJobs();
				aj.setJob_id(rs.getInt(1));
				System.out.println(aj.getJob_id());
				aj.setJob_title(rs.getString(2));
				System.out.println(aj.getJob_title());
				aj.setDomain(rs.getString(3));
				System.out.println(aj.getDomain());
				aj.setApply_date(rs.getDate(4));
				System.out.println(aj.getApply_date());
				jobs.add(aj);
			}
			return jobs;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally{

			DBUtil.closeConnection();
		}

		return null;
	}


}
