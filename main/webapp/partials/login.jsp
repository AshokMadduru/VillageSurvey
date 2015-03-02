<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
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
				<%if (session.getAttribute("name") != null) { %>
				<a class="navbar-brand" href="/partials/adminprofile.jsp">Logout</a>
				<%} else { %>
					<a class="navbar-brand" href="/partials/defaultpass.jsp">Admin
					Profile</a>
					<%} %>
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/partials/login.jsp">Login</a>

			</div>
		</div>
	</div>
	<div class="container center-login">
		<div class="well well-lg">
			<form action="javascript:void(0);">

				<div class="input-group input-group-lg">
					<span class="input-group-addon">U</span> <input id="userName"
						name="userName" value="Niranjan" type="text" class="form-control"
						placeholder="User Name" autofocus required>
				</div>
				<br />
				<div class="input-group input-group-lg">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-briefcase" aria-hidden="true"></span></img></span> <input
						id="password" name="password" type="password" value="Niranjan"
						class="form-control" placeholder="Password" required>
				</div>
				<br />
				<button id="Login" type="submit" onClick="validateCredentials();"
					class="btn btn-primary btn-lg btn-block">Login</button>
			</form>

		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/admin.js"></script>
	<script src="https://apis.google.com/js/client.js?onload=init1"></script>

</body>
</html>