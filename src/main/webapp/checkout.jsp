<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CHECK-OUT</title>
    <link href="css/style3.css" rel="stylesheet">

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
				<form action='/APSII/check_out' class="formula">
					<label>Digite o ID da reserva:</label><br>
					<input type="text" name="IDch">
					<br><input class="btn" type="submit" value="CHECK-OUT"> 
					
			</form>
			
			
			 </div>
        </div>
        
    </div>
</body>
</html>