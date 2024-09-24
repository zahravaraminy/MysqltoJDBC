package com.nt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SelectAll extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );

			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/movies", "root", "root");

			PreparedStatement ps = con.prepareStatement( "Select * from country" );
			ResultSet rs = ps.executeQuery();
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			List<Country> list = new ArrayList<>();
			
			while(rs.next()) {
				int i = rs.getInt("country_id");
				String code = rs.getString("country_iso_code");
				String name = rs.getString("country_name");
				
				Country c = new Country( i, code, name);
				
				list.add(c);
			}
				
			req.setAttribute( "list", list );
			RequestDispatcher rd = req.getRequestDispatcher( "displayAll.jsp" );
			rd.forward( req, res );
			pw.close();
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		
		
	}

}