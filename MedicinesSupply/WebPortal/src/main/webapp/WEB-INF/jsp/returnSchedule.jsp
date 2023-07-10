<!DOCTYPE html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet" href="style/viewSchedule-style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>View Schedule</title>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#" style="margin-left: 20px;"> <img
			src="https://images.vexels.com/media/users/3/136559/isolated/preview/624dd0a951a1e8a118215b1b24a0da59-pharmacy-logo-by-vexels.png"
			width="30" height="30" class="d-inline-block align-top" alt="">
			Genesis MedLabs
		</a> <form action="/Home"><button type="button float-right"
				style="margin-right: 20px;" class="btn btn-outline-light">Home</button></form>
	</nav>
	<br>
	<!--Return Schedule Here-->
	<div class="container" style="text-align:center;">
		<table class="table " style="color:white;">
			<thead>
				<tr>
					<th>Rep Name</th>
					<th>Doctor's Name</th>
					<th>Treating Ailment</th>
					<th>Medicine</th>
					<th>Slot</th>
					<th>Date</th>
					<th>Doctor Contact#</th>
				</tr>
			</thead>
			<tbody >
				<c:forEach items="${details}" var="detail">
					<tr>
						<td>${detail.name}</td>
						<td>${detail.doc}</td>
						<td>${detail.ailment}</td>
						<td>${detail.meds}</td>
						<td>${detail.slot}</td>
						<td>${detail.date}</td>
						<td>${detail.number}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/viewDemand"><button type="button" class="btn btn-outline-success">Place Demand</button></a>
	</div>
</body>
</html>
