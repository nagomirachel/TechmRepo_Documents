package com.jobseeker.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jobseeker.beans.AppliedJobs;
import com.jobseeker.dao.interfaces.AppliedJobDao;
import com.jobseeker.dao.utils.DBUtil;

public class AppliedJobDaoImpl implements AppliedJobDao{
	Connection connection=null;
	String msg;
	@Override
	public String apply_Job(AppliedJobs aj) {
		boolean domain_Status=domain_Check(aj);
		System.out.println(domain_Status);
		if(domain_Status){
			boolean total_Status=checkCount(aj);
			if(total_Status){
				boolean id_Status=Job_Id_Check(aj);
				System.out.println(id_Status);
				if(id_Status){
					try {
						connection=DBUtil.getConnection();
						PreparedStatement pr=connection.prepareStatement("insert into appliedjobs_np(reg_id,job_id,domain,apply_date,job_title) values(?,?,?,TO_DATE((select sysdate from dual),'yyyy-mm-dd'),?)");
						pr.setString(1, aj.getReg_id());
						pr.setInt(2, aj.getJob_id());
						pr.setString(3, aj.getDomain());
						pr.setString(4,aj.getJob_title());
						pr.executeUpdate();
						connection.commit();
						msg="You have applied this job Successfully";
						return msg;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else{
					msg="You have applied this job already";
					return msg;
				}
			}
			else{
				msg="You Have applied 10 times already today";
				return msg;
			}
		}
		else{
			msg="You are Not allowed to apply this Domain.To change your domain go to Edit Profile Option";
			return msg;
		}
		return msg;
	}
	@Override
	public boolean checkCount(AppliedJobs aj) { 
		try {
			PreparedStatement st=DBUtil.getConnection().prepareStatement("select count(*) from appliedjobs_np where reg_id=?and apply_date=TO_DATE((select sysdate from dual),'yyyy-mm-dd')");
			st.setString(1, aj.getReg_id());
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)<5){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean domain_Check(AppliedJobs aj) {
		try {
			PreparedStatement pr=DBUtil.getConnection().prepareStatement("select count(*) from jobseeker_np where user_name=? and (skill1=? or skill2=? or skill3=?)");
			pr.setString(1, aj.getReg_id());
			pr.setString(2, aj.getDomain());
			pr.setString(3, aj.getDomain());
			pr.setString(4, aj.getDomain());
			ResultSet rs=pr.executeQuery();

			if(rs.next()){
				if(rs.getInt(1)==1){
					return true;
				}
				else{

					return false;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean Job_Id_Check(AppliedJobs aj) {

		try {

			PreparedStatement pr=DBUtil.getConnection().prepareStatement("select count(*) from appliedjobs_np where reg_id=? and job_id=? ");
			pr.setString(1, aj.getReg_id());
			pr.setInt(2,aj.getJob_id());
			ResultSet rs=pr.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1));
				if(rs.getInt(1)==0){
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{

			DBUtil.closeConnection();
		}

		return false;
	}

}
