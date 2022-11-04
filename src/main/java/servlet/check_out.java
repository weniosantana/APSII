package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;

@WebServlet("/check_out")
public class check_out extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public check_out() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> sele = new ArrayList<>();
		Connection conn = null;
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		ResultSet rs = null;

		try {
			
			conn = DB.getConnection();
			
			Integer IDQuarto = Integer.parseInt(request.getParameter("IDch"));
			
			st = conn.prepareStatement("SELECT * FROM base_dados.cadastro WHERE (`IDQuarto` = ?)");
			st.setInt(1, IDQuarto);
			
			st1 = conn.prepareStatement(
						"Delete from 'base_dados'.'cadastro' WHERE ('IDQuarto' = '?')"
						);
				
			st1.setInt(1, IDQuarto);
			
				
			

			}catch(SQLException e){
			e.printStackTrace();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			
		};	
		
		
		
	}

}
