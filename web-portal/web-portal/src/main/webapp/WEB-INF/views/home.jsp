<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="/style/home-page.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">


</head>

<body>
<div class="main-container">
<%@ include file="fragments/header.jsp" %>
	<div class="split left">
  <div class="centered">
    <img src="" alt="View Schedule Image">
    <h2>View Schedule</h2>
    <a href="/pharmacy/viewSchedule"><button class="btn btn-outline-primary">View Schedule</button></a>
  </div>
</div>

<div class="split right">
  <div class="centered">
    <img src="" alt="Place Demand Image">
    <h2>Place Demand</h2>
    <a href=""><button class="btn btn-outline-primary">Place Demand</button></a>
  </div>
</div>
</div>

</body>
</html>