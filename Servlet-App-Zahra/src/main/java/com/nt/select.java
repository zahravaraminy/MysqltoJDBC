package com.nt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Select extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt( req.getParameter( "t1" ) );
		
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );

			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/movies", "root", "root");

			PreparedStatement ps = con.prepareStatement( "Select * from country where country_id = ?" );
			ps.setInt( 1, id);
			ResultSet rs = ps.executeQuery();
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			
			if(rs.next()) {
				int i = rs.getInt("country_id");
				String code = rs.getString("country_iso_code");
				String name = rs.getString("country_name");
				
				Country c = new Country( i, code, name);
				req.setAttribute( "country", c );
				
				RequestDispatcher rd = req.getRequestDispatcher( "display.jsp" );
				rd.forward( req, res );
			}
			else {
				pw.write("<h3 style=color:'Red'>Record not found</h3>");
			}
			pw.close();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

}