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
		
		try {
			
			conn = DB.getConnection();
			
			Integer IDQuarto = Integer.parseInt(request.getParameter("IDQuarto"));
			String NomeCad = request.getParameter("NomeCad");
			String CPFCad = request.getParameter("CPFcad");
			String dia = request.getParameter("Datacad").substring(0,2);
			String mes = request.getParameter("Datacad").substring(3, 5);
			String ano = request.getParameter("Datacad").substring(6);
			String data = ano + "-" + mes + "-" + dia;
			
			st = conn.prepareStatement(
					"Insert into cadastro (IDQuarto, NomeCad, CPFcad, Datacad) values (?,?,?,?)"
					);
			
			st.setInt(1, IDQuarto);
			st.setString(2, NomeCad);
			st.setString(3, CPFCad);
			st.setString(4, data);
			st.executeUpdate();
			response.sendRedirect("CheckSuc.jsp");  

			}catch(SQLException e){
			e.printStackTrace();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			
		};
	
		
	
	
	}

}
