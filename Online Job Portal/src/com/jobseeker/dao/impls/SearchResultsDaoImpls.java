package com.jobseeker.dao.impls;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import com.jobseeker.beans.JobsBean;
import com.jobseeker.dao.interfaces.SearchResultsDao;
import com.jobseeker.dao.utils.DBUtil;


public class SearchResultsDaoImpls implements SearchResultsDao {
	ResultSet rs=null;
	Connection con=null;
	List<JobsBean> jobs=null;

	public List<JobsBean> display_details(JobsBean jb1) {
		try{
			jobs=new ArrayList<JobsBean>();
			if(!jb1.getLocation().equals("---Select---")&&!jb1.getDomain().equals("---Select---")&&!jb1.getQualification().equals("---Select---")){
				con=DBUtil.getConnection();
				PreparedStatement pr1=con.prepareStatement(qry);
				pr1.setString(1, jb1.getLocation());
				pr1.setString(2, jb1.getDomain());
				pr1.setString(3, jb1.getQualification());
				rs=pr1.executeQuery();
				while(rs.next()){
					JobsBean jbBean=new JobsBean();
					jbBean.setJob_id(rs.getInt(1));
					jbBean.setJob_title(rs.getString(8));
					jbBean.setDescription(rs.getString(3));
					jobs.add(jbBean);
				}
			}
			else if(!jb1.getLocation().equals("---Select---")&&jb1.getDomain().equals("---Select---")&&jb1.getQualification().equals("---Select---")){
				con=DBUtil.getConnection();
				PreparedStatement pr1=con.prepareStatement(qry1);
				pr1.setString(1, jb1.getLocation());

				rs=pr1.executeQuery();
				while(rs.next()){
					JobsBean jbBean=new JobsBean();
					jbBean.setJob_id(rs.getInt(1));
					jbBean.setJob_title(rs.getString(8));
					jbBean.setDescription(rs.getString(3));
					jobs.add(jbBean);
				}
			}
			else if(jb1.getLocation().equals("---Select---")&&!jb1.getDomain().equals("---Select---")&&jb1.getQualification().equals("---Select---")){
				con=DBUtil.getConnection();
				PreparedStatement pr1=con.prepareStatement(qry2);
				pr1.setString(1, jb1.getDomain());
				System.out.println(jb1.getDomain());
				rs=pr1.executeQuery();
				while(rs.next()){
					JobsBean jbBean=new JobsBean();
					jbBean.setJob_id(rs.getInt(1));
					jbBean.setJob_title(rs.getString(8));
					jbBean.setDescription(rs.getString(3));
					jobs.add(jbBean);
				}
			}
			else if(jb1.getLocation().equals("---Select---")&&jb1.getDomain().equals("---Select---")&&!jb1.getQualification().equals("---Select---")){
				con=DBUtil.getConnection();
				PreparedStatement pr1=con.prepareStatement(qry3);


				pr1.setString(1, jb1.getQualification());
				rs=pr1.executeQuery();
				while(rs.next()){
					JobsBean jbBean=new JobsBean();
					jbBean.setJob_id(rs.getInt(1));
					jbBean.setJob_title(rs.getString(8));
					jbBean.setDescription(rs.getString(3));
					jobs.add(jbBean);
				}
			}
			else if(!jb1.getLocation().equals("---Select---")&&!jb1.getDomain().equals("---Select---")&&jb1.getQualification().equals("---Select---")){
				con=DBUtil.getConnection();
				PreparedStatement pr1=con.prepareStatement(qry4);
				pr1.setString(1, jb1.getLocation());
				pr1.setString(2, jb1.getDomain());

				rs=pr1.executeQuery();
				while(rs.next()){
					JobsBean jbBean=new JobsBean();
					jbBean.setJob_id(rs.getInt(1));
					jbBean.setJob_title(rs.getString(8));
					jbBean.setDescription(rs.getString(3));
					jobs.add(jbBean);
				}
			}
			else if(jb1.getLocation().equals("---Select---")&&!jb1.getDomain().equals("---Select---")&&!jb1.getQualification().equals("---Select---")){
				con=DBUtil.getConnection();
				PreparedStatement pr1=con.prepareStatement(qry5);

				pr1.setString(1, jb1.getDomain());
				pr1.setString(2, jb1.getQualification());
				rs=pr1.executeQuery();
				while(rs.next()){
					JobsBean jbBean=new JobsBean();
					jbBean.setJob_id(rs.getInt(1));
					jbBean.setJob_title(rs.getString(8));
					jbBean.setDescription(rs.getString(3));
					jobs.add(jbBean);
				}
			}
			else if(!jb1.getLocation().equals("---Select---")&&jb1.getDomain().equals("---Select---")&&!jb1.getQualification().equals("---Select---")){
				con=DBUtil.getConnection();
				PreparedStatement pr1=con.prepareStatement(qry6);
				pr1.setString(1, jb1.getLocation());

				pr1.setString(2, jb1.getQualification());
				rs=pr1.executeQuery();
				while(rs.next()){
					JobsBean jbBean=new JobsBean();
					jbBean.setJob_id(rs.getInt(1));
					jbBean.setJob_title(rs.getString(8));
					jbBean.setDescription(rs.getString(3));
					jobs.add(jbBean);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{

			DBUtil.closeConnection();
		}

		return jobs;
	}
}
