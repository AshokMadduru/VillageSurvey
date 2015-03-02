<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Survey</title>
<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
<meta content="utf-8" http-equiv="encoding">
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Home</a>
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/partials/instructions.jsp">Instructions</a>
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/partials/survey.jsp">Survey</a>
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<%
					if (session.getAttribute("name") != null) {
				%>
				<a class="navbar-brand" href="/partials/adminprofile.jsp">Admin
					Profile</a>
				<%
					} else {
				%>
				<a class="navbar-brand" href="/partials/defaultpass.jsp">Admin
					Profile</a>
				<%
					}
				%>
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<%
					if (session.getAttribute("name") != null) {
				%>
				<a class="navbar-brand" href="/partials/logout.jsp">Logout</a>
				<%
					} else {
				%>
				<a class="navbar-brand" href="/partials/login.jsp">Login</a>
				<%
					}
				%>
			</div>
		</div>
	</div>
	<%
		if (session.getAttribute("name") != null) {
	%>
	<div class="text-right">
		<h3>
			<strong> <%
 	out.print("Hi " + session.getAttribute("name") + " !");
 %>
			</strong>
		</h3>
	</div>
	<h3 class="text-center">
		<strong>Under Construction !!!</strong>
	</h3>
	<%
		} else {
			
	%>
	<h3 class="text-center">
		<strong>You should Login or Create Admin Profile first</strong>
	</h3>
	<%
		}
	%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/admin.js"></script>
	<script src="https://apis.google.com/js/client.js?onload=init1"></script>

</body>
</html>