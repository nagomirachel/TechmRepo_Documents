<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Jobs</title>

 <script type="text/javascript">
 function validateUser() {
     
     
     if(PostForm.jobId.value==""){
         alert("Provide the Job Id");
         PostForm.jobId.focus(true);
         return false;
         }
     else{
         var Exp=/^[0-9]+$/;
         if(!PostForm.jobId.value.match(Exp))
 {
         alert("Job Id should contain only numbers!!");
         PostForm.jobId.focus(true);
         return false;
 
 }}
     if(PostForm.jobtitle.value==""){
         alert("Provide the Job Title");
         PostForm.jobtitle.focus(true);
         return false;
         }
     if(PostForm.description.value==""){
         alert("Provide the Job Description");
         PostForm.description.focus(true);
         return false;
         }
     if(PostForm.experience.value==""){
         alert("Provide the Experience required");
         PostForm.experience.focus(true);
         return false;
         }
     else{
         var Exp=/^[0-9]+$/;
         if(!PostForm.experience.value.match(Exp))
 {
         alert("Experience should contain only numbers!!");
         PostForm.experience.focus(true);
         return false;
 
 }}
     if(PostForm.salary.value==""){
         alert("Provide the Salary");
         PostForm.salary.focus(true);
         return false;
         }
     else{
         var Exp=/^[0-9]+$/;
         if(!PostForm.salary.value.match(Exp))
 {
         alert("Salary should contain only numbers!!");
         PostForm.salary.focus(true);
         return false;
 
 }}
     if(PostForm.domain.value=="---Select---"){
         alert("Provide the domain ");
         PostForm.domain.focus(true);
         return false;
         }
     if(PostForm.location.value=="---Select---"){
         alert("Provide the location ");
         PostForm.location.focus(true);
         return false;
         }
     if(PostForm.qualification.value=="---Select---"){
         alert("Provide the Qualification ");
         PostForm.qualification.focus(true);
         return false;
         }
     
    
     return true;
 }

</script> 

</head>
<body bgcolor="#87CEEB" onload="preventBack()">
<center><h3>Post Jobs</h3></center>
<div align="right"><a href="./jobseekercontroller?option=logout">Logout</a></div>
<form method="post" name="PostForm"
		action="./jobseekercontroller?option=post"
		 onsubmit="return validateUser()">
		 <table></table>
		<table>
			<tr>
				<td>Job Id</td>
				<td><input name="jobId" /></td>
			</tr>

			<tr>
				<td>Job Title</td>
				<td><input name="jobtitle" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input name="description" /></td>
			</tr>
			<tr>
				<td>Experience</td>
				<td><input name="experience" /></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input name="salary" /></td>
			</tr>
			<tr>
				<td>Domain</td>
				<td><select name="domain">
				<option value="---Select---">---Select---</option>
				<option value="Analytics and BuisnessIntelligence">Analytics and BuisnessIntelligence</option>
				<option value="Engineering Design and RND">Engineering Design and RND</option>
				<option value="HR Recruitment and Admin">HR Recruitment and Admin</option>
				<option value="IT SOftware-DBA Datawarehousing">IT SOftware-DBA Datawarehousing</option>
				<option value="IT Software Mainframe">IT Software Mainframe</option>
				<option value="Mobile Application Development">Mobile Application Development</option>
				<option value="IT Hardware">IT Hardware</option>
				<option value="TEchnical Support">TEchnical Support</option>
				<option value="Banking and FiniancialServices">Banking and FiniancialServices</option>
				<option value="Travel,Tours and TIcketingAirlines">Travel,Tours and TIcketingAirlines</option>
				
				</select></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><select name="location">
				<option value="---Select---">---Select---</option>
				<option value="Chennai">Chennai</option>
				<option value="Mumbai">Mumbai</option>
				<option value="Pune">Pune</option>
				<option value="Gurgaon">Gurgaon</option>
				<option value="Dubai">Dubai</option>
				<option value="Cochin">Cochin</option>
				<option value="Hyderabad">Hyderabad</option>
				<option value="Jaipur">Jaipur</option>
				<option value="Noida">Noida</option>
				</select></td>
			</tr>
			<tr>
				<td>Qualification</td>
				<td><select name="qualification">
				<option value="---Select---">---Select---</option>
				<option value="B.E(IT/CSE)">B.E(IT/CSE)</option>
				<option value="B.E(IT/CSE/ECE),MCA">B.E(IT/CSE/ECE),MCA</option>
				<option value="B.E(IT/CSE),MCA">B.E(IT/CSE),MCA</option>
				<option value="MBA(HR and Finance)">MBA(HR and Finance)</option>
				<option value="B.Sc(AnyDegree)">B.Sc(AnyDegree)</option>
				<option value="B.Com,M.Com">B.Com,M.Com</option>
				<option value="CA">CA</option></select></td>
			</tr>
			
			<tr>
				<th colspan=2><input type="submit" value="Post Job"  /> <input
					type="reset" value="Clear All" /></th>
			</tr>
			</table>
			</form>
</body>
</html>