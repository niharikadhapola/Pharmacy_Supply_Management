<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>Stock Availed</title>
</head>

<body>
<table>
	<thead>
				<tr>
					<th>Pharmacy</th>
					<th>Medicine</th>
					<th>Stock Available</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pharmacyList}" var="ph"><br>
					<tr>
						<td>${ph.pharmacyName}</td>
						<td>${ph.medicineName}</td>
						<td>${ph.supplyCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>