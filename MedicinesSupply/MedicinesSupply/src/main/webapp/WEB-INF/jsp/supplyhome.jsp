<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medicine Demand</title>
</head>
<body>
<form action="/PharmacyList">
	Medicine Name :  <select name="name">
    <option value="Orthoherb">Orthoherb</option>
    <option value="Cholecalciferol">Cholecalciferol</option>
    <option value="Gaviscon">Gaviscon</option>
    <option value="Dolo-650">Dolo-650</option>
    <option value="Cyclopam">Cyclopam</option>
    <option value="Hilact">Hilact</option>
  </select><br>
	Demand Count : <input type="number" name="demand"/><br><br>
	<input type="submit"/>
</form>



</body>
</html>