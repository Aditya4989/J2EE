<%@page import="com.jspiders.springmvc.pojo.StudentPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="NavBar.jsp" />
<%
StudentPojo pojo = (StudentPojo) request.getAttribute("student");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<style type="text/css">
#data{
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
}
#data td,th {
	border: 1px solid black;
	text-align: center;
}

</style>
</head>
<body>
	<div align="center">
		<form action="./search" method="post">
			<fieldset>
				<legend>Search Student Details</legend>
				<table>
					<tr>
						<td>Enter id</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" value="SEARCH">
			</fieldset>
		</form>
		<%
		if (msg != null) {
		%>
		<h4><%=msg%>
		</h4>
		<%
		}
		%>
		<%
		if (pojo != null) {
		%>
		<table id="data">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Address</th>
			</tr>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getEmail()%></td>
				<td><%=pojo.getMobile()%></td>
				<td><%=pojo.getAddress()%></td>
			</tr>
		</table>
		<%
		}
		%>
	</div>
	</body>
</html>