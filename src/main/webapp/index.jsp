<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/hotel.css" rel="stylesheet">
    <title>HOME - HOTEL TRANSILV�NIA</title>
</head>

<body>
    <header>
        <p class="titulo">HOTEL TRANSILV�NIA</p>

        <div class="menu">
            <p><a href="index.jsp">Home</a></p>
            <p><a href="consCheck.jsp">Consultar Check-in/Out</a> </p>
            <p><a href="checkin.jsp">Check-in</a> </p>
            <p><a href="checkout.jsp">Check-out</a> </p>
        </div>

        <div class="linha">
            <p></p>
        </div>
    </header>
    <div class="sobre">
        <div class="sobreC">
            <div class="tsobre">
                <p class="tHotel">Hotel</p>
                <p class="tTrans">Transilv�nia</p>
            </div>
            <p class="textosobre">O Hotel Transilv�nia classificado com 5 estrelas, devidamente localizado no Viaduto 31
                de Mar�o, Liberdade - SP 01517-100.
                O Hotel de luxo apreseta diversas op��es de quartos e suites para quem est� procurando um lugar pra
                passar as f�rias ou a trabalho.
                Atualmente temos um total de 30 quartos e 35 suites.<br><br>
                Tamb�m apresentamos v�rias op��es de lazer e entretenimento como piscinas para toda a familia de
                diversos tamanhos
                e profundidade para que todos possam tirar um bom proveito, com monitoramente de salva-vidas para a
                seguran�a e cuidados de todos
            </p>
        </div>
        <div class="img">
            <img src="img/hotel.jpg" alt="" class="imgHotel">
        </div>
    </div>
    <div class="quartos">

        <div class="agrup">
            <div class="tipoQuarto">
                <img src="img/qInd.jpg" alt="" class="imgqInd">
                <p>Quarto individual - quarto para uma s� pessoa, com uma cama individual. Dependendo do requinte do
                    hotel, <br>a �rea do quarto poder� variar entre 8 e 14 metros quadrados</p>
            </div>
            <div class="tipoQuarto">
                <img src="img/qDInd.jpg" alt="" class="imgqDInd">
                <p>Quarto duplo para uso individual - quarto para uma pessoa com duas camas</p>
            </div>

            <div class="tipoQuarto">
                <img src="img/qDuplo.jpg" alt="" class="imgqDuplo">
                <p>Quarto duplo - quarto para duas pessoa, com duas camas. Dependendo do requinte do hotel, <br>a �rea
                    do quarto poder� variar entre 8 e 14 metros quadrados</p>
            </div>
        </div>
    </div>
</body>

</html>