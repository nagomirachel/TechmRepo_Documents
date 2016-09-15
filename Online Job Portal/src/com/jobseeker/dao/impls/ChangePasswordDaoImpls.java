package com.jobseeker.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.jobseeker.beans.LoginBean;
import com.jobseeker.dao.interfaces.ChangePasswordDao;
import com.jobseeker.dao.utils.DBUtil;

public class ChangePasswordDaoImpls implements ChangePasswordDao{
	public boolean changePassword(LoginBean lb) {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement pr = null;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(cpass_qry);			
			ps.setString(1, lb.getCpassword());
			ps.setString(2, lb.getUserName());
			ps.setString(3, lb.getPassword());
			int i=ps.executeUpdate();
			pr = con.prepareStatement(cpass_qry1);
			pr.setString(1, lb.getCpassword());
			pr.setString(2, lb.getUserName());
			pr.setString(3, lb.getPassword());
			int j=pr.executeUpdate();
			con.commit();
			System.out.println(i+" "+j);
			System.out.println(lb.getPassword());
			System.out.println(lb.getCpassword());
			System.out.println(lb.getUserName());
			return true;

		} catch (Exception e) {
			System.out.println("Change Password: Failed Due to " + e);
		}finally{

			DBUtil.closeConnection();
		}

		return false;
	}
}
