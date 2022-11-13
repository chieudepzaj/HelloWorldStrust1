<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List User</title>
</head>
<body>
	<center>
		<h1>
			<a href="/HelloWorldStrust1/common/"> Return home page </a>
		</h1>
		<logic:present name="message">
		<bean:write name="message" />
	    </logic:present>
		<table border="1" cellpadding="2" cellspacing="2">
			<tr>
				<th>Username</th>
				<th>Age</th>
				<th>Email</th>
				<th>Address</th>
				<th>Password</th>
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
	</center>
</body>
</html>
