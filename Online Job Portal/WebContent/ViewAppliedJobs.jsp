<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Applied Jobs</title>

</head>
<body bgcolor="#87CEEB">
<center><h3>Applied Jobs</h3></center>
<form method="post" name="ViewAppliedJobs"
		action="Search.jsp">
		<center>
<table border=1>
<tr>
<th>Job Title</th>
<th>Domain</th>
<th>Apply date</th>
</tr>

<c:forEach var="i" items="${requestScope.list}" varStatus="sno">

			    <tr><td><b>${i.job_title}</b></td>
				<td>${i.domain}</td>
				<td>${i.apply_date}</td>
				
				</tr>
</c:forEach>

	</table>
	</center>
	<br>
	<br>
	<br>
	<center>	<input type="submit" value="Back"/></center>
	</form>	

</body>
</html>