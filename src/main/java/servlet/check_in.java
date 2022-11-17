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

/**
 * Servlet implementation class check_in
 */
@WebServlet("/check_in")
public class check_in extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String id_reserva = "";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public check_in() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String idreserva() {
		return id_reserva;
	}
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement st = null;	
		PreparedStatement st1 = null;	
		ResultSet rs = null;
		String vaz = "";
		Integer IDQuarto = null;
		String CPFCad = "";
		String NomeCad = "";
		String data = null;
		String dia = null;
		String mes = null;
		String ano = null;
		List<Integer> sele = new ArrayList<>();
		List<String> sele1 = new ArrayList<>();
		List<String> sele2 = new ArrayList<>();
		
		try {
			
			conn = DB.getConnection();
			if(request.getParameter("IDQuarto")=="" || request.getParameter("NomeCad") == "" || request.getParameter("CPFcad")=="" || request.getParameter("Datacad")=="") {
			}else {	
			IDQuarto = Integer.parseInt(request.getParameter("IDQuarto"));
			NomeCad = request.getParameter("NomeCad");
			CPFCad = request.getParameter("CPFcad");
			if(request.getParameter("Datacad")!="") {
			dia = request.getParameter("Datacad").substring(0,2);
			mes = request.getParameter("Datacad").substring(3, 5);
			ano = request.getParameter("Datacad").substring(6);
			data = ano + "-" + mes + "-" + dia;}
			}
			if(request.getParameter("IDQuarto").equals(vaz) || request.getParameter("NomeCad").equals(vaz)|| request.getParameter("CPFcad").equals(vaz) || request.getParameter("Datacad").equals(vaz) ) {
				response.sendRedirect("PrenCheck.jsp");
			}else {
				
				st1 = conn.prepareStatement("SELECT * FROM hotel.tb_quarto WHERE (`num_quarto` = ?); ");
				st1.setInt(1, IDQuarto);
				rs = st1.executeQuery();	 
				int rows = 0;
				while(rs.next()) {
					sele.add(rs.getInt("num_quarto"));
					rows ++;
				}
				
				
				if(rows == 0) {
				st1 = conn.prepareStatement(
						"insert into tb_quarto (num_quarto) values (?);"
						);
				st1.setInt(1, IDQuarto);
				st1.executeUpdate();

				}
				
				st1 = conn.prepareStatement("SELECT * FROM hotel.tb_hospede WHERE (`cpf` = ?); ");
				st1.setString(1, CPFCad);
				rs = st1.executeQuery();	 
				int rows1 = 0;
				while(rs.next()) {
					sele1.add(rs.getString("cpf"));
					sele1.add(rs.getString("nome"));
					rows1 ++;
				}
				
				if(rows1 == 0) {
					st1 = conn.prepareStatement(
							"insert into tb_hospede (cpf, nome) values (?,?);"
							);
					st1.setString(1, CPFCad);
					st1.setString(2, NomeCad);
					st1.executeUpdate();

					}
				
				
				st = conn.prepareStatement(
						"insert into tb_reserva (cpf, num_quarto, data_checkin) values (?,?,?);"
						);
				
				st.setString(1, CPFCad);
				st.setInt(2, IDQuarto);
				st.setString(3, data);
				st.executeUpdate();
				
				st1 = conn.prepareStatement("SELECT * FROM hotel.tb_reserva WHERE (`cpf` = ?); ");
				st1.setString(1, CPFCad);
				rs = st1.executeQuery();	
				while(rs.next()) {
					sele2.add(rs.getString("id_reserva"));
					sele2.add(rs.getString("cpf"));
					sele2.add(rs.getString("num_quarto"));
					sele2.add(rs.getString("data_checkin"));
					sele2.add(rs.getString("data_checkout"));
					

				}
				
				
				response.sendRedirect("CheckSuc.jsp");

				
			}
			}catch(SQLException e){
			e.printStackTrace();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			
		};
		
		
		
	
	
	}

	
	
	
	
	
}
