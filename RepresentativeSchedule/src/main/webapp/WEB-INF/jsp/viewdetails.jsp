<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>Representative Schedule</title>
</head>
<body>
	<BR/>
	<table>
			<caption>Here are the list of details:</caption>
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
			<tbody>
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
</body>
</html>
