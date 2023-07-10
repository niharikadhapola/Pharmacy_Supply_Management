<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<link rel="stylesheet" href="/style/view-schedule-page.css">
</head>
<body>

	<div class="card-holder">
		<div class="card">
			<h3>View schedule for the next 5 days</h3>
			
			<div class="form-group mb-3">
			<form action="/pharmacy/repSchedule" method="get">
				<label>Enter Start Date</label>
				<br>
				<br>
				<input type="date" id="startDate" name="startDate" placeholder="dd/mm/yyyy" required="required" class="form-control border-0 shadow-sm px-4">
				<br>
				<input type="submit" class="btn btn-outline-primary">
			</form>
			</div>
		</div>
	</div>
</body>
</html>