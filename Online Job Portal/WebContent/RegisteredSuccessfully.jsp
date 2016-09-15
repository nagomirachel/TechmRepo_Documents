<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Status Page</title>

</head>
<body bgcolor="#87CEEB" onload="preventBack()">
<center><br><br><br><br><br><br><br><br>
<table>
<tr ><td colspan=5><h3>Registered Successfully !!</h3></td></tr>
<tr>
<th colspan=5>${param.msg}</th>
</tr>
<tr><td colspan=5><a href="LoginPage.jsp">Login with your credentials</a></td></tr>
</table>
</center>
</body>
</html>