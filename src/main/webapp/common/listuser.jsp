<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>List User</title>
</head>
<body>
	<%-- Getting login and error message if it's posible --%>
	<%
		String login = (String) session.getAttribute("loggin");
	%>
	<%
		if (login != null) {
	%>
	<center>
		<div class="container">
			<h1>
				<a href="/HelloWorldStrust1/common/"> Return home page </a>
			</h1>
			<h1>
				<a href="/HelloWorldStrust1/common/add-user.html"> Add new user
				</a>
			</h1>
			<logic:present name="message">
				<bean:write name="message" />
			</logic:present>
			<table class="table table-hover" border="1" cellpadding="2"
				cellspacing="2">
				<tr>
					<th>Username</th>
					<th>Age</th>
					<th>Email</th>
					<th>Address</th>
					<th>Password</th>
					<th>Action</th>
				</tr>
				<logic:iterate id="idu" name="list">
					<tr>
						<td><bean:write name="idu" property="username" /></td>
						<td><bean:write name="idu" property="age" format="#####" /></td>
						<td><bean:write name="idu" property="email" /></td>
						<td><bean:write name="idu" property="address" /></td>
						<td><bean:write name="idu" property="password" /></td>
						<td><html:link action="/edit-user.html" paramName="idu"
								paramId="username" paramProperty="username">Edit</html:link>|<html:link
								action="/delete-user.html" paramName="idu" paramId="username"
								paramProperty="username"
								onclick="return confirm('Are you sure?')">Delete</html:link></td>
					</tr>
				</logic:iterate>
			</table>
		</div>
		<html:link action="/logout.html">Logout</html:link>
	</center>
	<%
		} else {
			response.sendRedirect("login-user.html");
		}
	%>
</body>
</html>
