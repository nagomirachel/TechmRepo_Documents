package com.jobseeker.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.jobseeker.beans.JobSeekerBean;
import com.jobseeker.dao.interfaces.EditProfileDao;
import com.jobseeker.dao.utils.DBUtil;

public class EditProfileDaoImpl implements EditProfileDao {

	@Override
	public boolean edit_details(JobSeekerBean jb) {
		Connection con=null;
		try {
			con=DBUtil.getConnection();
			PreparedStatement pr=con.prepareStatement(qry);
			pr.setString(1, jb.getFirst_name());
			pr.setString(2, jb.getLast_name());
			pr.setString(3,jb.getMiddle_name());
			pr.setString(4, jb.getDob());
			pr.setString(5, jb.getGender());
			pr.setString(6, jb.getMarital_status());
			pr.setString(7, jb.getFirst_high_qual());
			pr.setString(8,jb.getSecond_high_qual());
			pr.setString(9,jb.getExperience());
			pr.setString(10, jb.getFirst_employer());
			/*pr.setInt(11,jb.getPeriod());
			pr.setString(12,jb.getSecond_employer());*/
			pr.setString(11,jb.getMob_no());
			pr.setString(12,jb.getPhone_no());
			pr.setString(13,jb.getCurrent_address());
			pr.setString(14,jb.getState());
			pr.setString(15,jb.getCity());
			pr.setInt(16,jb.getPincode());
			pr.setString(17,jb.getEmail_id());
			pr.setString(18,jb.getSkill1());
			pr.setString(19,jb.getSkill2());
			pr.setString(20,jb.getSkill3());
			pr.setString(21,jb.getUser_name());
			pr.executeUpdate();
			con.commit();
			return true;
		} catch (SQLException e) {
			System.out.println("EditProfileException due to "+e);

		}
		finally{

			DBUtil.closeConnection();
		}
		return false;
	}

}
