<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="css/style3.css" rel="stylesheet">

<meta charset="ISO-8859-1">
<title>CONSULTAR CHECK-IN</title>
</head>
<body>
<div class="header">
        <p class="titulo">HOTEL TRANSILVĀNIA</p>
    
         <div class="menu">
            <p><a href="index.jsp">Home</a></p>
            <p><a href="consCheck.jsp">Consultar Check-in/Out</a> </p>
            <p><a href="checkin.jsp">Check-in</a> </p>
            <p><a href="checkout.jsp">Check-out</a> </p>
        </div>
       
       
    </div>

    <div class="sobreLogin">
        <div class="sobreC">
            <div class="login">
	               <form action="/APSII/consulCheck" class="formula">
							<label>Digite o ID da reserva:</label><br>
							<input type="text" name="IDQuartoOut">
							<input class="btn" type="submit" value="CONSULTAR">		
						</form>
					 <form action="/APSII/consulCheckNQuarto" class="formula">
							<label>Consultar ID das Reservas:</label>
							<input class="btn" type="submit" value="CONSULTAR">		
						</form>
                
                
            </div>
        </div>
        
    </div>
	
	
</body>
</html>