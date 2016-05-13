<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Market Watch - Login</title>
		
		<!-- Bootstrap core CSS -->
		<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom styles for Login and Register -->
    	<link href="<%=request.getContextPath()%>/resources/css/form.css" rel="stylesheet">
	</head>
	
	<body>
		<div class="container">
			<form class="form-front" action="<%=request.getContextPath()%>/login" method="post">
				<h2 class="form-front-heading">Log in</h2>
				<label for="inputUsername" class="sr-only">Username</label>
				<input type="text" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
				<label for="inputPassword" class="sr-only">Password</label>
				<input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
				<div class="checkbox">
					<label>
						<input type="checkbox" value="remember-me"> Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
				<br>
				<a href="<%=request.getContextPath()%>/register">Create new account</a>
			</form>
		</div> <!-- /container -->
</body>

</html>