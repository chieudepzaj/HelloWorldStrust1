<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h1 style="text-align: center;">
		<html:link style="color: blue;" action="/common/add-user.html">Create new User</html:link>
		<br>
	</h1>
	<h1 style="text-align: center;">
		<html:link style="color: blue;" action="/common/list-user.html">List User</html:link>
		<br>
	</h1>
</body>
</html>