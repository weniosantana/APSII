package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public check_in() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement st = null;	
		String vaz = "";
		Integer IDQuarto = null;
		String CPFCad = "";
		String NomeCad = "";
		String data = null;
		String dia = null;
		String mes = null;
		String ano = null;
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
				st = conn.prepareStatement(
						"Insert into cadastro (IDQuarto, NomeCad, CPFcad, Datacad) values (?,?,?,?)"
						);
				
				st.setInt(1, IDQuarto);
				st.setString(2, NomeCad);
				st.setString(3, CPFCad);
				st.setString(4, data);
				st.executeUpdate();
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
