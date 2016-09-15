<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Page</title>
<script type="text/javascript">
	function validateUser() {
		var domain= SearchPage.Domain.value;
		var location= SearchPage.Location.value;
		var qualification= SearchPage.Qualification.value;
		if(domain=="---Select---" && location=="---Select---" && qualification=="---Select---"){
			alert("Please choose any one option for search!!");
			return false;
		}
	}
	
	

	</script>
</head>
<body bgcolor="#87CEEB" onload="preventBack()">
<center><h3>Search For Jobs</h3></center>
<div align="right"><a href="EditProfile.jsp">Edit Profile</a>
		<a href="ChangePassword.jsp">Change Password</a>
		<a href="./jobseekercontroller?option=viewapplied">View Applied Jobs</a>
		<a href="./jobseekercontroller?option=logout">Logout</a></div>
	
<form method="post" name="SearchPage"
		action="./jobseekercontroller?option=search"
		 onsubmit="return validateUser()">
		 
		<table>
		<tr>
		<td>${param.msg }</td>
		</tr>
<tr>
				<td>Domain of Interest 3</td>
				<td><select name="Domain">
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
				<td><select name="Location">
				<option value="---Select---">---Select---</option>
				<option>Chennai</option>
				<option>Mumbai</option>
				<option>Pune</option>
				<option>Gurgaon</option>
				<option>Dubai</option>
				<option>Cochin</option>
				<option>Hyderabad</option>
				<option>Jaipur</option>
				<option>Noida</option>
				</select></td>
			</tr>
			<tr>
				<td>Qualification</td>
				<td><select name="Qualification">
				<option value="---Select---">---Select---</option>
				<option>B.E(IT/CSE)</option>
				<option>B.E(IT/CSE/ECE)MCA</option>
				<option>B.E(IT/CSE)MCA</option>
				<option>MBA(HR and Finance)</option>
				<option>B.Sc(AnyDegree)</option>
				<option>B.Com,M.Com</option>
				<option>CA</option>
				
				
				</select></td>
			</tr>
			<tr>
				<th colspan=2><input type="submit" value="Search"  /> <input
					type="reset" value="Clear All" /></th>
			</tr>
			</table></form>
			
</body>
</html>