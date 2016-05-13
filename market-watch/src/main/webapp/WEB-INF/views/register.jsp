<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Market Watch - Register</title>
		
		<!-- Bootstrap core CSS -->
		<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom styles for Login and Register -->
    	<link href="<%=request.getContextPath()%>/resources/css/form.css" rel="stylesheet">
	</head>
	
	<body>
		<div class="container">
			<form class="form-front" action="<%=request.getContextPath()%>/register" method="post">
				<h2 class="form-front-heading">Register</h2>
				<label for="inputName" class="sr-only">Name</label>
				<input type="text" id="inputName" class="form-control" placeholder="Name" required autofocus>
				<label for="inputUsername" class="sr-only">Username</label>
				<input type="text" id="inputUsername" class="form-control" placeholder="Username">
				<label for="inputPassword" class="sr-only">Password</label>
				<input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
			</form>
		</div> <!-- /container -->
</body>

</html>