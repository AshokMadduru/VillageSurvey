<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Profile</title>
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
				<a class="navbar-brand" href="/partials/adminprofile.jsp">Admin
					Profile</a>
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
				<%if (session.getAttribute("name") != null) { %>
				<a class="navbar-brand" href="/partials/logout.jsp">Logout</a>
				<%} else { %>
				<a class="navbar-brand" href="/partials/login.jsp">Login</a>
				<%} %>

			</div>
		</div>
	</div>

	<div class="text-right">
		<h3>
			<strong> <%
 	if (session.getAttribute("name") != null) {
 		out.print("Hi " + session.getAttribute("name") + " !");
 	}
 %>
			</strong>
		</h3>
	</div>
	<div class="container">

		<div id="outputLog"></div>


		<form class="form-horizontal" action="javascript:void(0);">
			<h2>Admin Profile</h2>
			<br>
			<% if (session.getAttribute("name") == null) { %>
			<div class="form-group">
				<label for="name" class="control-label col-xs-2">Name</label>
				<div class="col-xs-3">
					<input type="text" class="form-control" id="name"
						placeholder="Full Name" required>
				</div>
			</div>
			<div class="form-group">
				<label for="userName" class="control-label col-xs-2">User
					Name</label>
				<div class="col-xs-3">
					<input type="text" class="form-control" id="userName"
						placeholder="User Name" required>
				</div>
			</div>
			<%} else { %>
			<input type="hidden" id="userName"
				value=<%= session.getAttribute("userName") %>>
			<% } %>
			<div class="form-group">
				<label for="phoneNo" class="control-label col-xs-2">Phone No</label>
				<div class="col-xs-3">
					<input type="text" class="form-control" id="phoneNo"
						placeholder="Phone No" required>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="control-label col-xs-2">Password</label>
				<div class="col-xs-3">
					<input type="password" class="form-control" id="password"
						placeholder="Password" required>
				</div>
			</div>
			<div class="form-group">
				<label for="rePassword" class="control-label col-xs-2">Re-Password</label>
				<div class="col-xs-3">
					<input type="password" class="form-control" id="rePassword"
						placeholder="Re-Password" required>
				</div>
			</div>
			<br> <br>
			<h4> Address (Optional) </h4>
			<div class="form-group">
				<label for="Address 1" class="control-label col-xs-2">Address line 1</label>
				<div class="col-xs-3">
					<input type="text" class="form-control" id="address1"
						placeholder="Address 1" required>
				</div>
			</div>
			<div class="form-group">
				<label for="Address 2" class="control-label col-xs-2">Address line 2</label>
				<div class="col-xs-3">
					<input type="text" class="form-control" id="address2"
						placeholder="Address 2" required>
				</div>
			</div>
			<div class="form-group">
				<label for="city" class="control-label col-xs-2">City</label>
				<div class="col-xs-3">
					<input type="text" class="form-control" id="city"
						placeholder="City" required>
				</div>
			</div>
			<div class="form-group">
				<label for="zipcode" class="control-label col-xs-2">Zip</label>
				<div class="col-xs-3">
					<input type="text" class="form-control" id="zipcode"
						placeholder="Zip" required>
				</div>
			</div>
			<br> 
			<div class="control-label col-xs-4">
				<input id="save_admin_profile" type="button"
					<% if (session.getAttribute("name") == null) { %>
					value="Create Admin Profile" class="btn btn-primary"
					onClick="createAdminProfile();" <%} else { %>
					value="Update Admin Profile" class="btn btn-primary"
					onClick="updateAdminProfile();" <%} %>>
			</div>

		</form>
		<br>
		<!-- 		<div >
			<P>
				<input id="input_greet_generically" type="button"
					value="Test button" onclick="nothing" class="btn btn-primary">
			</P>

		</div> -->
	</div>
	<div class="text-center" id="message"></div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/admin.js"></script>
	<script src="https://apis.google.com/js/client.js?onload=init1"></script>

</body>
</html>