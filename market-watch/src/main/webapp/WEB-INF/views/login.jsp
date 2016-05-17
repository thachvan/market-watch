<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

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
			<form class="form-standard" action="/market-watch/login" method="post">
				<h2 class="form-standard-heading">Log in</h2>
				<c:if test="${message != null}">
					<label class="message">${message}</label>
				</c:if>
				<label for="username" class="sr-only">Username</label>
				<input type="text" name="username" id="username" class="form-control" placeholder="Username" autofocus value="${username}">
				<label for="password" class="sr-only">Password</label>
				<input type="password" name="password" id="password" class="form-control" placeholder="Password">
				<div class="checkbox">
					<label>
						<input type="checkbox" value="remember-me"> Remember me
					</label>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
				<br>
				<a href="<%=request.getContextPath()%>/register">Create new account</a>
			</form>
		</div> <!-- /container -->
</body>

</html>