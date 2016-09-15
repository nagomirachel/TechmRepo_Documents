<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>


</head>
<body bgcolor="#87CEEB">
<center>
<h3>Change Password</h3>
<form method="post" name="ChangePasswordPage"
		action="./jobseekercontroller?option=changepassword"
		onsubmit="return validateUser()" >
<table>
<tr><td>Enter old password</td>
			<td><input type="password" name="opass"/></td>
			</tr>
				<tr>
			<td>Enter new password</td>
			<td><input type="password" name="cpass"/></td>
			</tr>
			<tr>
				<th colspan=2><input type="submit" value="ResetPassword"  /> <input
					type="reset" value="Clear All" /></th>
			</tr>
			
</table>
</form>
</center>
</body>
</html>