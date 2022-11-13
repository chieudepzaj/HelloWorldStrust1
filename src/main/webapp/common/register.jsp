<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
</head>
<body>
	<center>
		<h1>Registration Form</h1>
		<logic:present name="message">
		<bean:write name="message" />
	    </logic:present>
		<html:form action="/add-user-pro" method="post">
			<label>UserName</label>
			<html:text property="username" name="user"></html:text>
			<br>
			<label>Age</label>
			<html:text property="age" name="user"></html:text>
			<br>
			<label>Email</label>
			<html:text property="email" name="user"></html:text>
			<br>
			<label>Address</label>
			<html:text property="address" name="user"></html:text>
			<br>
			<label>Password</label>
			<html:text property="password" name="user"></html:text>
			<br>
			<html:submit>Add new User</html:submit>
		</html:form>
		<h1>
			<a href="/HelloWorldStrust1/common/"> Return home page </a>
		</h1>
		<br>
	</center>


</body>
</html>