<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>

</head>
<body bgcolor="#87CEEB">
<center><h3>Search Results</h3></center>
<c:forEach var="i" items="${requestScope.jobs}" varStatus="sno">
<form method="post" name="SearchPage"
		action="./jobseekercontroller?option=apply&&id=${i.job_id}&&title=${i.job_title}">
<table>
<tr>
				<tr><td>${sno.count}</td></tr>
			    <tr><td>${i.job_id}</td></tr>
				<tr><td>${i.job_title}</td></tr>
				<tr><td>${i.description}</td></tr>
			
<tr>
	<td><input type="submit" value="Apply"/></td>
	</tr>
	
	<tr><td><a href="Search.jsp">Go Back to Search Page</a></td></tr></table>
	</form>	</c:forEach>
</body>
</html>