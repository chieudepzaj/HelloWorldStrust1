<%-- Getting login and error message if it's posible --%>
<%
	String login = (String) session.getAttribute("loggin");
%>
<%
	if (login != null) {
%>
<jsp:forward page="/common/list-user.html"></jsp:forward>
<%
	} else {
		response.sendRedirect("login-user.html");
	}
%>