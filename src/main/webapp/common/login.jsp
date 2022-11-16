<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/register.css">

<title>Login Form</title>
</head>
<body>
	<%-- Getting login and error message if it's posible --%>
	<%
		String login = (String) session.getAttribute("loggin");
	%>
	<%
		if (login == null || "".equals(login)) {
	%>
	<html:form action="/login-user-pro" method="post">
		<div class="container">
			<h1>Login</h1>
			<p>Please fill in this form to login.</p>
			<p style="color: red;">
				<logic:present name="message">
					<bean:write name="message" />
				</logic:present>
			</p>
			<hr>

			<label for="username"><b>Username</b></label> 
			<input type="text" placeholder="Enter Username" name="username" required> 
			
			<label for="password"><b>Password</b></label> 
			<input type="password" placeholder="Enter Password" name="password" required>

			<button type="submit" class="registerbtn">Login</button>
		</div>

		<div class="container signin">
			<p>
				If you do not have an account, <a
					href="/HelloWorldStrust1/common/add-user.html">Register</a>.
			</p>
		</div>
	</html:form>
	<%
		} else {
			response.sendRedirect("/HelloWorldStrust1/common/list-user.html");
		}
	%>
</body>
</html>