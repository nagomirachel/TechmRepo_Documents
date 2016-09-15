package com.jobseeker.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jobseeker.beans.LoginBean;
import com.jobseeker.dao.interfaces.LoginCheckDao;
import com.jobseeker.dao.utils.DBUtil;

public class LoginCheckDaoImpls implements LoginCheckDao {
	public boolean validateUser(LoginBean lb) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(user_qry);
			ps.setString(1, lb.getUserName());
			ps.setString(2, lb.getPassword());
			rs = ps.executeQuery();
			con.commit();
			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("LoginCheckDao: Failed Due to " + e);
		}finally{

			DBUtil.closeConnection();
		}

		return false;
	}


}
