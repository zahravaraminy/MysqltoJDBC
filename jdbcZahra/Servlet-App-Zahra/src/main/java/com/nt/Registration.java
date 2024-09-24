package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt( req.getParameter( "t1" ) );
		String code = req.getParameter( "t2" );
		String name = req.getParameter( "t3" );

		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );

			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/movies", "root", "root");

			PreparedStatement ps = con.prepareStatement( "insert into country values(?,?,?)" );
			ps.setInt( 1, id );
			ps.setString( 2, code );
			ps.setString( 3, name );
			ps.executeUpdate();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.write("<h3 style=color:'green'>Registration Successfull</h3>");
		pw.close();
	}
	
	

}
