package com.jobseeker.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;



import com.jobseeker.beans.JobSeekerBean;
import com.jobseeker.dao.interfaces.RegistrationDao;
import com.jobseeker.dao.utils.DBUtil;

public class RegistrationDaoImpls implements RegistrationDao{
	@Override
	public boolean register_details(JobSeekerBean jb) {
		Connection con=null;
		try{
			con=DBUtil.getConnection();
			PreparedStatement pr=con.prepareStatement(qry);
			PreparedStatement ps=DBUtil.getConnection().prepareStatement(qry2);
			ps.setString(1,jb.getUser_name());
			ps.setString(2, jb.getPassword());
			ps.executeUpdate();
			pr.setString(1, jb.getFirst_name());
			pr.setString(2, jb.getLast_name());
			pr.setString(3,jb.getMiddle_name());
			pr.setString(4, jb.getDob());
			pr.setString(5, jb.getGender());
			pr.setString(6, jb.getMarital_status());
			pr.setString(7, jb.getFirst_high_qual());
			//pr.setString(8,jb.getSecond_high_qual());
			pr.setString(8,jb.getExperience());
			pr.setString(9, jb.getFirst_employer());
			//pr.setInt(11, jb.getPeriod());
			pr.setString(10,jb.getSecond_high_qual());
			pr.setString(11,jb.getMob_no());
			pr.setString(12,jb.getPhone_no());
			pr.setString(13,jb.getCurrent_address());
			pr.setString(14,jb.getState());
			pr.setString(15,jb.getCity());
			pr.setInt(16,jb.getPincode());
			pr.setString(17,jb.getPerm_address());
			pr.setString(18,jb.getEmail_id());
			pr.setString(19,jb.getUser_name());
			pr.setString(20,jb.getPassword());
			pr.setInt(21,jb.getDdno());
			pr.setInt(22,jb.getDdamt());
			pr.setString(23,jb.getBankname());
			pr.setString(24,jb.getBranch());
			pr.setString(25, jb.getSkill1());
			pr.setString(26, jb.getSkill2());
			pr.setString(27, jb.getSkill3());
			pr.executeUpdate();
			con.commit();
			return true;
		}
		catch (Exception e) {
			System.out.println("FailedRegisterException due to" +e.getMessage());
		}
		finally{

			DBUtil.closeConnection();
		}

		return false;
	}
}
