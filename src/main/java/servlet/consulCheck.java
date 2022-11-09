package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;

@WebServlet("/consulCheck")
public class consulCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public consulCheck() {
        super();
    }

    String IDQ;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> sele = new ArrayList<>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int i;
		try {
			IDQ =request.getParameter("IDQuartoOut");
			conn = DB.getConnection();
		
			st = conn.prepareStatement("SELECT * FROM base_dados.cadastro WHERE (`IDQuarto` = ?)");
			st.setString(1, IDQ);
			rs = st.executeQuery();	 
				while(rs.next()) {
					sele.add(rs.getString("IDQuarto"));
					sele.add(rs.getString("NomeCad"));
					sele.add(rs.getString("CPFcad"));
					sele.add(rs.getString("Datacad"));
					
				}
			st = conn.prepareStatement("SELECT * FROM base_dados.check_out WHERE (`IDquarto` = ?)");
			st.setString(1, IDQ);
				rs = st.executeQuery();	 
					while(rs.next()) {
						sele.add(rs.getString("IDquarto"));
						sele.add(rs.getString("NomeCad"));
						sele.add(rs.getString("CPFcad"));
						sele.add(rs.getString("Checkout"));
						
					}   

				PrintWriter out = response.getWriter();
			    response.setContentType("text/html");
			    out.println("<!DOCTYPE html>");
			    out.println("<html>");
			    out.println("<head>");
			    out.println("<meta charset=\"utf-8\">");
			    out.println("<title>CONSULTA DOS HOSPEDES</title>");
			    out.println("<style>");
			    out.println("body{margin:0; background-color: #e5a54a; }.header{background-color:#e5a54a;height:100px;}.titulo{margin:auto;font-size:35px;color:white;font-weight:bold;font-family:Arial,Helvetica,sans-serif;padding-top:30px;padding-left:250px;display:inline-block;}.menu { float: right;  display: inline-block;color: white;font-weight: bold;font-family: Arial, Helvetica, sans-serif;font-size: 22px;  width: 750px; height: 95px; margin-right: 60px; padding-top: 10px;}.menup{padding-left:10px;display:inline-block;}.linha{color:white;background-color:white;height:2px;margin-top:38px;}.sobre{padding-right:250px;padding-left:250px;height:500px;background-color:#e5a54a;}.sobreLogin{padding-right:250px;padding-left:250px;height:800px;background-color:#e5a54a;}.sobreCada{padding-right:250px;padding-left:250px;height:1200px;background-color:#e5a54a;}.sobreQua{padding-right:250px;padding-left:250px;height:1200px;background-color:#e5a54a;}.sobreC{display:inline-block;width:700px;height:300px;}.tsobre{font-weight:bold;font-family:Arial,Helvetica,sans-serif;margin-top:10px;font-size:50px;}.img{margin-top:70px;height:300px;width:300px;float:right;text-align:center;border-radius:70%;}.tsobrep{display:inline-block;}.textosobre{font-size:21px;}.tHotel{color:#ffffff;}.quartos{margin-top:30px;padding-left:250px;padding-top:30px;height:400px;width:1500px;padding-right:250px;}.qInd{background-color:#e5a54a;height:100px;margin-top:10px;border-radius:10px;margin-bottom:50px;}.qIndp,.qDIndp,.qDuplop{padding-left:50px;display:inline-block;font-size:23px;}.qDIndp{padding-top:17px;}.imgqInd{display:inline-block;width:120px;height:70px;margin-top:15px;margin-left:30px;float:left;border-radius:70%;}.imgqDInd,.imgqDuplo{display:inline-block;width:120px;height:70px;margin-top:15px;margin-left:30px;float:left;border-radius:70%;}.qDInd,.qDuplo{background-color:#e5a54a;height:100px;margin-top:10px;border-radius:10px;margin-bottom:50px;}.formula{font-family:Arial,Helvetica,sans-serif;margin-top:5%;font-size:15px;margin-left:30%;padding-top:20px;padding-left:90px;width:600px;height:250px;color:rgba(131,131,131,0.938);background-color:rgb(255,255,255);border-radius:20px; padding-top: 50px;}.formulainput{margin-top:20px;margin-bottom:20px;height:30px;width:500px;border:0px;background-color:rgba(119,119,119,0.11);border-radius:20px;"
			    		+ "}.formula.bot{margin-left:35%;width:70px;height:70px;border-radius:40px;background-color:#e5a54a;color:#ffff;font-size:30px;}.infoLogin{display:inline-block;background-color:rgb(235,235,235);margin-left:20%;text-align:center;font-size:18px;padding:10px;border-radius:10px;}a{color:#ffff;text-decoration:none;}.infoLogina{text-decoration:none;color:rgba(131,131,131,0.938);}.formulaCada{display:inline-block;font-family:Arial,Helvetica,sans-serif;margin-top:25%;font-size:25px;margin-left:20%;padding-top:50px;padding-left:90px;width:900px;height:850px;color:rgba(131,131,131,0.938);background-color:rgb(255,255,255);border-radius:20px;}.formulaCadainput{font-size:15px;margin-left:18%;margin-top:50px;padding:5px;width:500px;height:30px;border:0px;background-color:rgba(119,119,119,0.11);border-radius:8px;padding-left:16px;}.formulaCada.bot{margin-left:19%;margin-right:20%;width:70px;height:70px;border-radius:40px;background-color:#e5a54a;color:#ffff;font-size:30px;}.formulaCadalabel{margin-left:38%;text-align:center;margin-bottom:60px;}.infoCadastro{display:inline-block;background-color:rgb(235,235,235);margin-left:4%;text-align:center;font-size:15px;padding:10px;border-radius:10px;}a{color:#ffff;text-decoration:none;}.infoCadastroa{text-decoration:none;color:rgba(131,131,131,0.938);}.InfQuar{display:inline-block;margin-top:100px;width:300px;height:300px;background-color:red;}.ImagemQ{display:inline-block;float:right;margin-top:100px;width:300px;height:300px;background-color:red;}.menup{text-decoration:none;}");
			    out.println("</style>");
			    out.println("</head>");
			    out.println("<body>");
			    out.println("<div class='sobreLogin'>");
			    out.println("<div class='sobreC'>");
			    out.println("<div class='login'>");
			    out.println("<form class='formula'>");
			    if(sele.size() != 0){
			    	
			    	if(sele.get(3).length()<= 10) {
				    	out.print("<h1>Dado(s) do check-in</h1>");
				    	out.println("Nº do quarto: " +  sele.get(0) + "<br>");
			    		out.println("Nome do Hóspede: " +  sele.get(1) + "<br>");
			    		out.println("CPF do Hóspede: " +  sele.get(2) + "<br>");
			    		out.println("Data do Check-in: " +  sele.get(3) + "<br>");
			    		out.println("Nº do quarto: " +  sele.get(4) + "<br>");
			    		out.println("Nome do Hóspede: " +  sele.get(5) + "<br>");
			    		out.println("CPF do Hóspede: " +  sele.get(6) + "<br>");
			    		out.println("Data do Check-in: " +  sele.get(7));
			    		
			    	}else {
			    		out.print("<h1>Dados do check-out</h1>");
			    		
			    		out.println("Nº do quarto: " +  sele.get(0) + "<br>");
			    		out.println("Nome do Hóspede: " +  sele.get(1) + "<br>");
			    		out.println("CPF do Hóspede: " +  sele.get(2) + "<br>");
			    		out.println("Data e Hora do Check-out: " +  sele.get(3));
			    		out.println("<br>");
			    		out.println("Nº do quarto: " +  sele.get(4) + "<br>");
			    		out.println("Nome do Hóspede: " +  sele.get(5) + "<br>");
			    		out.println("CPF do Hóspede: " +  sele.get(6) + "<br>");
			    		out.println("Data do Check-in: " +  sele.get(7));
				    	
			    	}
			    	
			    }else{
			    	response.sendRedirect("HospN.jsp");
			    }
			    out.println("</form>");
			    out.println("</div>");
			    out.println("</div>");
			    out.println("</div>");
			    out.println("</body>");
			    out.println("</html>");
		}catch(SQLException e){
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public String IdQuarto() {
		return IDQ;
	}
}
