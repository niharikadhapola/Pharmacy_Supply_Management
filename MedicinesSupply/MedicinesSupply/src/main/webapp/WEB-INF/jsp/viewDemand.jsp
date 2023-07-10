<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="style/viewDemand-style.css">
    <title>View Demand</title>
</head>
<body>
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand" href="#" style="margin-left: 20px;">
          <img src="https://images.vexels.com/media/users/3/136559/isolated/preview/624dd0a951a1e8a118215b1b24a0da59-pharmacy-logo-by-vexels.png" width="30" height="30" class="d-inline-block align-top" alt="">
          Genesis MedLabs
        </a>
        <a href="Home.html"><button type="button float-right" style="margin-right: 20px;" class="btn btn-outline-light">Home</button></a>
    </nav>
      <br>
    <div class="container">
        <div class="row">
            <div class="col-lg-1"></div>
            <div class="card" style="width: 50rem; margin-top:50px">
            <div class="card-title"></div>
                <table>
                    <tr class="odd">
                        
                        <td class="quantity">
                            <form action="/SupplyAvailed">
                            	<label for="med" style="float:left">Enter Medicine Name: </label>
                            	<select id="med" name="name">
    								<option value="Orthoherb">Orthoherb</option>
    								<option value="Cholecalciferol">Cholecalciferol</option>
    								<option value="Gaviscon">Gaviscon</option>
    								<option value="Dolo-650">Dolo-650</option>
    								<option value="Cyclopam">Cyclopam</option>
    								<option value="Hilact">Hilact</option>
  								</select><br><br>
  								<label for="demCount" style="float:left">Enter Demand Count: </label>
                                <input type="number" id="demCount" class="rounded-pill shadow-sm border-0 demand-input" name="demand">
                                <br>
                                <input type="submit" class="btn btn-outline-light rounded-pill submit-btn" style="float:right;background-color:#add8e6;">
                            </form>
                            
                        </td>
                    </tr>
                    
                </table>
               
            </div>
        </div>
    </div>
 
</body>
</html>