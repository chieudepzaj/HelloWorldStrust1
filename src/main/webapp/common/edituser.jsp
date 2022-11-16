<%@page import="com.example.common.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/register.css">
<title>Edit User Form</title>
</head>
<body>
	<%-- Getting login and error message if it's posible --%>
	<%
		String login = (String) session.getAttribute("loggin");
	%>
	<%
		if (login != null) {
	%>
	<html:form action="/edit-user-pro" method="post">
		<%
			request.getSession().getAttribute("user");
		%>
		<div class="container">
			<h1>Edit Profile</h1>
			<p>Please fill in this form to update profile an account.</p>
			<p style="color: red;">
				<logic:present name="message">
					<bean:write name="message" />
				</logic:present>
			</p>
			<hr>

			<label for="username"><b>Username</b></label>
			<html:text name="user" property="username" readonly="true"></html:text>

			<label for="email"><b>Email</b></label>
			<html:text property="email" name="user"></html:text>

			<label for="age"><b>Age</b></label>
			<html:text property="age" name="user"></html:text>

			<label for="address"><b>Address</b></label>
			<html:text property="address" name="user"></html:text>

			<label for="password"><b>Password</b></label>
			<html:password property="password" name="user"></html:password>

			<button type="submit" class="registerbtn">Update</button>
		</div>

		<div class="container signin">
			<p>
				Return List user? <a href="/HelloWorldStrust1/common/list-user.html">Click
					here</a>.
			</p>
		</div>

	</html:form>
	<%
		} else {
			response.sendRedirect("login-user.html");
		}
	%>
</body>
</html>