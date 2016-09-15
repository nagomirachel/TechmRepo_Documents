package com.jobseeker.controller;
import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.jobseeker.beans.AppliedJobs;
import com.jobseeker.beans.JobSeekerBean;
import com.jobseeker.beans.JobsBean;
import com.jobseeker.beans.LoginBean;

import com.jobseeker.service.impls.AppliedJobServiceImpl;
import com.jobseeker.service.impls.ChangePasswordServiceImpl;
import com.jobseeker.service.impls.EditProfileServiceImpl;
import com.jobseeker.service.impls.LoginCheckServiceImpl;
import com.jobseeker.service.impls.PostJobsServiceImpls;
import com.jobseeker.service.impls.RegistrationServiceImpl;
import com.jobseeker.service.impls.SearchResultsServiceImpl;
import com.jobseeker.service.impls.ViewAppliedJobsServiceImpl;
import com.jobseeker.service.interfaces.AppliedJobService;
import com.jobseeker.service.interfaces.ChangePasswordService;
import com.jobseeker.service.interfaces.EditProfileService;
import com.jobseeker.service.interfaces.LoginCheckService;
import com.jobseeker.service.interfaces.PostJobsService;
import com.jobseeker.service.interfaces.RegistrationService;
import com.jobseeker.service.interfaces.SearchResultsService;
import com.jobseeker.service.interfaces.ViewAppliedJobsService;

public class jobseekercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		HttpSession session = request.getSession(true);
		if (option.equals("login")) {

			LoginCheckService loginService = new LoginCheckServiceImpl();

			LoginBean lb = new LoginBean();
			lb.setUserName(request.getParameter("userName"));
			lb.setPassword(request.getParameter("password"));
			System.out.println(lb.getUserName());
			System.out.println(lb.getPassword());
			if (lb.getUserName().equals("admin") && lb.getPassword().equals("password")) {

				response.sendRedirect("PostJob.jsp");
			}
			else{
				boolean status = loginService.validateUser(lb);

				if (status) {
					session.setAttribute("userName", lb.getUserName());
					RequestDispatcher rd = request
					.getRequestDispatcher("./Search.jsp");
					rd.forward(request, response);
				}
				else {
					RequestDispatcher rd = request
					.getRequestDispatcher("./LoginPage.jsp?msg=Invalid UserName/Password");
					rd.forward(request, response);

				}
			}


		}
		if (option.equals("register")){
			Random rand=new Random();
			String regId=request.getParameter("date")+request.getParameter("month")+String.valueOf(rand.nextInt(1000));
			RegistrationService reService=new RegistrationServiceImpl();
			JobSeekerBean jBean=new JobSeekerBean();
			jBean.setFirst_name(request.getParameter("firstName"));
			jBean.setMiddle_name(request.getParameter("middleName"));
			jBean.setSkill1(request.getParameter("skill1"));
			jBean.setSkill2(request.getParameter("skill2"));
			jBean.setSkill3(request.getParameter("skill3"));
			jBean.setLast_name(request.getParameter("lastName"));
			jBean.setDob(request.getParameter("date")+request.getParameter("month")+request.getParameter("year"));
			jBean.setGender(request.getParameter("gender"));
			jBean.setMarital_status(request.getParameter("m_status"));
			jBean.setFirst_high_qual(request.getParameter("first_qual"));
			jBean.setExperience(request.getParameter("experience"));
			jBean.setFirst_employer(request.getParameter("first_emp"));

			jBean.setSecond_high_qual((request.getParameter("second_qual")));
			jBean.setMob_no(request.getParameter("mob_no"));
			jBean.setPhone_no(request.getParameter("ph_no"));
			jBean.setCurrent_address(request.getParameter("line1")+request.getParameter("line2")+request.getParameter("line3"));
			jBean.setState(request.getParameter("state"));
			jBean.setCity(request.getParameter("city"));
			jBean.setPincode(Integer.parseInt(request.getParameter("pincode")));
			jBean.setPerm_address(request.getParameter("p_line1")+request.getParameter("p_line2")+request.getParameter("p_line3"));
			jBean.setState(request.getParameter("p_state"));
			jBean.setCity(request.getParameter("p_city"));
			jBean.setPincode(Integer.parseInt(request.getParameter("p_pincode")));
			jBean.setEmail_id(request.getParameter("email"));
			jBean.setDdno(Integer.parseInt(request.getParameter("ddno")));
			jBean.setDdamt(Integer.parseInt(request.getParameter("ddamt")));
			jBean.setBankname(request.getParameter("bankname"));
			jBean.setBranch(request.getParameter("branch"));
			jBean.setPassword(request.getParameter("pass"));
			jBean.setUser_name(regId);
			session.setAttribute("reg_id", regId);
			boolean status=reService.register_details(jBean);

			if (status) {

				RequestDispatcher rd = request.getRequestDispatcher("./RegisteredSuccessfully.jsp?msg=Your username is "+regId+" ");
				rd.forward(request, response);
			} else {

				RequestDispatcher rd = request
				.getRequestDispatcher("./LoginPage.jsp?msg=Registration Unsuccessfull..");
				rd.forward(request, response);
			}
		}
		if (option.equals("search")){
			JobsBean jb=new JobsBean();
			jb.setDomain(request.getParameter("Domain"));
			session.setAttribute("domain", request.getParameter("Domain"));
			jb.setLocation(request.getParameter("Location"));
			jb.setQualification(request.getParameter("Qualification"));
			String username=(String)session.getAttribute("userName");
			session.setAttribute("username", username);
			SearchResultsService Service = new SearchResultsServiceImpl();
			List<JobsBean> jobs = Service.display_details(jb);
			request.setAttribute("jobs", jobs);

			if (jobs != null) {
				RequestDispatcher rd = request.getRequestDispatcher("/SearchResults.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/SearchResults.jsp?msg=No Jobs for your search criteria !");
				rd.forward(request, response);
			}
		}
		if(option.equals("apply")){
			AppliedJobs aj=new AppliedJobs();
			aj.setJob_id(Integer.parseInt(request.getParameter("id")));
			aj.setJob_title(request.getParameter("title"));
			aj.setReg_id((String) session.getAttribute("username"));
			aj.setDomain((String) session.getAttribute("domain"));
			String username=(String)session.getAttribute("userName");
			session.setAttribute("username", username);

			AppliedJobService aService=new AppliedJobServiceImpl();
			String message=aService.apply_Job(aj);


			RequestDispatcher rd=request.getRequestDispatcher("/AppliedSuccessfully.jsp?msg="+message+"");
			rd.forward(request, response);
		}


		if(option.equals("edit")){
			JobSeekerBean jBean=new JobSeekerBean();
			String username=(String)session.getAttribute("userName");
			session.setAttribute("username", username);
			jBean.setFirst_name(request.getParameter("firstName"));
			jBean.setMiddle_name(request.getParameter("middleName"));
			jBean.setSkill1(request.getParameter("skill1"));
			jBean.setSkill2(request.getParameter("skill2"));
			jBean.setSkill3(request.getParameter("skill3"));
			jBean.setLast_name(request.getParameter("lastName"));
			jBean.setDob(request.getParameter("date")+request.getParameter("month")+request.getParameter("year"));
			jBean.setGender(request.getParameter("gender"));
			jBean.setMarital_status(request.getParameter("m_status"));
			jBean.setFirst_high_qual(request.getParameter("first_qual"));
			jBean.setSecond_high_qual(request.getParameter("second_qual"));
			jBean.setExperience(request.getParameter("experience"));
			jBean.setFirst_employer(request.getParameter("first_emp"));
			//jBean.setPeriod(100);
			//	jBean.setSecond_employer(request.getParameter("second_emp"));
			jBean.setMob_no(request.getParameter("mob_no"));
			jBean.setPhone_no(request.getParameter("ph_no"));
			jBean.setCurrent_address(request.getParameter("line1")+request.getParameter("line2")+request.getParameter("line3"));
			jBean.setState(request.getParameter("state"));
			jBean.setCity(request.getParameter("city"));
			jBean.setPincode(Integer.parseInt(request.getParameter("pincode")));
			jBean.setEmail_id(request.getParameter("email"));
			jBean.setUser_name(username);
			EditProfileService eps=new EditProfileServiceImpl();
			boolean status=eps.edit_details(jBean);

			if (status) {

				RequestDispatcher rd = request.getRequestDispatcher("./Search.jsp?msg=Updated successfully!!");
				rd.forward(request, response);
			} else {

				RequestDispatcher rd = request
				.getRequestDispatcher("./Search.jsp?msg=Updation Unsuccessfull");
				rd.forward(request, response);
			}
		}

		if(option.equals("changepassword")){
			LoginBean lBean=new LoginBean();
			lBean.setPassword(request.getParameter("opass"));
			System.out.println(lBean.getPassword());
			lBean.setCpassword(request.getParameter("cpass"));
			System.out.println(lBean.getCpassword());

			lBean.setUserName((String) session.getAttribute("userName"));
			System.out.println(lBean.getUserName());

			ChangePasswordService changepass=new ChangePasswordServiceImpl();
			boolean status = changepass.changePassword(lBean);

			if (status) {

				RequestDispatcher rd = request.getRequestDispatcher("./LoginPage.jsp?msg=Changed Password Succesfully!! Login with new Username and Password");
				rd.forward(request, response);
			} else {

				RequestDispatcher rd = request
				.getRequestDispatcher("./LoginPage.jsp?msg=Password change unsuccessfull");
				rd.forward(request, response);
			}

		}
		if(option.equals("viewapplied")){
			ViewAppliedJobsService va=new ViewAppliedJobsServiceImpl();
			AppliedJobs aj=new AppliedJobs();
			aj.setReg_id((String)session.getAttribute("userName"));
			System.out.println("controller: "+aj.getReg_id());
			List<AppliedJobs> list=va.viewAppliedJobs(aj);
			request.setAttribute("list", list);

			if(list!=null){
				RequestDispatcher rd = request.getRequestDispatcher("/ViewAppliedJobs.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("/Search.jsp?msg=No jobs applied!!");
				rd.forward(request, response);
			}
		}
		if(option.equals("post")){
			JobsBean jb=new JobsBean();
			jb.setJob_id(Integer.parseInt(request.getParameter("jobId")));
			jb.setJob_title(request.getParameter("jobtitle"));
			jb.setDescription(request.getParameter("description"));
			jb.setExperience(Integer.parseInt(request.getParameter("experience")));
			jb.setSalary(Integer.parseInt(request.getParameter("salary")));
			jb.setDomain(request.getParameter("domain"));
			jb.setLocation(request.getParameter("location"));
			jb.setQualification(request.getParameter("qualification"));
			PostJobsService ps=new PostJobsServiceImpls();
			boolean status=ps.post_jobs(jb);


			if(status){
				RequestDispatcher rd = request.getRequestDispatcher("./PostedSuccessfully.jsp?msg= Posted Jobs Successfully!!1");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request
				.getRequestDispatcher("./PostedSuccessfully.jsp?msg=Posting Jobs Unsuccessfully!!");
				rd.forward(request, response);

			}

		}
		if(option.equals("logout")){
			session.invalidate();
			RequestDispatcher rd=request.getRequestDispatcher("/LoginPage.jsp?msg=Logged out successfully !!");
			rd.forward(request, response);	
		}
	}


}
