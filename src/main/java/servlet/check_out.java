package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet.check_in;
import db.DB;

@WebServlet("/check_out")
public class check_out extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public check_out() {
        super();
    }
    Date dataHoraAtual = new Date();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> sele = new ArrayList<>();
		Connection conn = null;
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		PreparedStatement st2 = null;

		ResultSet rs = null;
		
		String data = new SimpleDateFormat("yyyy/MM/dd").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		String data_hora = data + " " + hora;
		try {
			
			conn = DB.getConnection();
			
			
			Integer IDQuarto = Integer.parseInt(request.getParameter("IDch"));
			/*
			st = conn.prepareStatement("SELECT * FROM base_dados.cadastro WHERE (`IDQuarto` = ?)");
			st.setInt(1, IDQuarto);
			
			rs = st.executeQuery();	 
			while(rs.next()) {
				sele.add(rs.getString("IDQuarto"));
				sele.add(rs.getString("NomeCad"));
				sele.add(rs.getString("CPFcad"));
				sele.add(rs.getString("Datacad"));
				
			}
			*/
			st1 = conn.prepareStatement(
					"update tb_reserva set data_checkout = ? where id_reserva = ?;"
					);
			
			st1.setString(1, data_hora);
			st1.setInt(2, IDQuarto);
		
			st1.executeUpdate();
			/*
			st1 = conn.prepareStatement(
					"DELETE FROM cadastro WHERE IDQuarto = ?"
					);
			st1.setInt(1, Integer.parseInt(sele.get(0)));

			st1.executeUpdate();
			*/
			
			response.sendRedirect("checkOutSuc.jsp");

		
			
			
			
			}catch(SQLException e){
			e.printStackTrace();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			
		};	
		
		
		
	}

}
