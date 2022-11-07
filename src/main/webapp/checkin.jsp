<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="style2.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>CHECK-IN</title>
</head>
<body>

<div class="header">
        <p class="titulo">HOTEL TRANSILVÂNIA</p>
    
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
	                <form action="/APSII/check_in" class="formula">
	                 <div class="daRe">
						<label>Digite o numero do quarto:</label>
						<input type="text" name="IDQuarto">
					</div>
					<div class="daRe">
						<label>Digite o nome completo:</label>
						<input type="text" name="NomeCad">
					</div>
					<div class="daRe">
						<label>Digite o CPF (Apenas numeros)</label>
						<input type="text" name="CPFcad">
					</div>
					<div class="daRe">
						<label>Data do Check-in</label>
						<input type="text" name="Datacad">
						<input class="btn" type="submit" value="Check-in">		
					</div>
	
		</form>

                
                
            </div>
        </div>
        
    </div>
	
</body>
</html>