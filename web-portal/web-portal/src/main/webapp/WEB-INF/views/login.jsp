<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Portal</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<link rel="stylesheet" href="/style/login-page.css">

</head>
<body>
	
	<div class="container-fluid">
		
		<div class="row no-gutter">
			
            <div class="col-md-6 d-none d-md-flex bg-image">Space for image</div>

			
			<div class="col-md-6">
				<div class="login d-flex align-items-center py-5">
					<div class="container">
						<h3 class="display-4">Login</h3>
						<br>
                		<form:form action="/pharmacy/postLogin" modelAttribute="user" method="post">
                			<div class="form-group mb-3">
                				<form:label path="username" for="username">Enter Username</form:label>
                				<form:input path="username" id="username" type="text" name="username" placeholder="Username" required="required" class="form-control border-0 shadow-sm px-4" />
                			</div>
                			<br>
                            <div class="form-group mb-3">
                            	<form:label path="password" for="password">Enter Password</form:label>
                                <form:input path="password" id="password" type="password" name="password" placeholder="Password" required="required" class="form-control border-0 shadow-sm px-4 text-primary" />
                            </div>
                            <br>
                     			<input type="submit" class="btn btn-primary">	
                		</form:form>
					</div>
				</div>
			</div>
	</div>
	</div>
</body>
</html>