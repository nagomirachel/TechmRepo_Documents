<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<script type="text/javascript">
	function validateUser() {
		var user;
		var pwd;
		user = LoginForm.userName.value;
		pwd = LoginForm.password.value;

		if (user == null || user == "" || user == " ") {
			alert("User Name Must Be Provided..");
			return false;
		}

		if (pwd == null || pwd == "" || pwd == " ") {
			alert("Password Must Be Provided..");
			return false;
		}

		return true;
	}

	
	function preventBack(){
		window.history.forward();}
	


</script>
<style>form{padding-left:20pt;}</style>

</head><center><h1 ><font color="Black">ManResource Consultancy</font></h1></center>
<body background="C:\JavaProgs\Online Job Portal\Job1.jpg" onload="preventBack()">
	
				
					<p align="center">
						<font size="3px" ></font><font size="5px" color="Black" >Welcome
							To MAN RESOURCE Consultancy</font><br /></p>
				 


	<form method="post" name="LoginForm"
		action="./jobseekercontroller?option=login"
		onsubmit="return validateUser()">
		
		
		
		
	<table align="left">
		<!--  <table style="margin-left: 70px" cellspacing="2">-->
		
				<tr>
			
<td><p align="justify">
<font color=#0B2161 size="3.8px" style="text-align: justify;"><br /> <br />
 <b>ManResource is a consultancy company based
at Chennai, India.<br /> <br />MAN
RESOURCE Consultancy is an ISO 9001:2008 Certified consultancy.
Over the years, we have acted as 
preferred recruitment partners to multinationals and
leading Indian businesses to emerge as the leading
recruitment brand nationally. 
This combined with our role as trusted consultants for 
Indian professionals translates into our core capability -
Building Careers, Building Organisations.ManResource  is proud of 
its long standing relationships in the industry and the fact
that 75% of its revenue comes from its existing clients, 
which is a testimonial of happy clients.</b> <br /> <br /> </font>
</p></td>
					<td>
			
			<table align="right">		
			<tr>
				<td>User Name</td>
				<td><input name="userName" /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="password"  /></td>
			</tr>

			<tr>
				<th colspan=2 ><input type="submit" value="Login" /> <input
					type="reset" value="Clear All" /></th>
			</tr>

			<tr>
				<th colspan=2>${param.msg}</th>
			</tr>
			<tr><th colspan=2>If new Register..<a href="Register.jsp" >Click Here !!</a></th></tr>
			
		</table>
		</td>
		</tr>
		<tr>
		<td align="justify">
<b><big>TERMS &amp;
CONDITIONS..</big></b>.<br> <br>
					<ul>
<li><b>To view and apply for jobs, you must register in the portal</b></li>
<li><b>You need to pay certain amount for registering with us</b></li>
<li><b>The registration amount for 30 days is Rs 1000 only</b></li>
<li><b>The registration amount for 60 days is Rs 1500 only</b></li>
<li><b>The registration amount for 90 days is Rs 2000 only</b></li>
<li><b>The DD should be taken in favour of Man Resource Consulting Firm</b></li>
</ul>
<p>You are requested to send the DD to the following address:
<br>
The Recruiter,<br>
Man Resource Consulting Firm,<br>
#10, Chenna Kesava Nagar, <br>
Electronic city, Bangalore-68.
</p>							
							
								
		</td></tr>
		</table>
	</form>


</body>
</html>