package cimport java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Update extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt( req.getParameter( "t1" ) );
		String code = req.getParameter( "t2" );
		String name = req.getParameter( "t3" );
		
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );

			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/movies", "root", "root");

			PreparedStatement ps = con.prepareStatement( "update country set country_iso_code = ?,country_name = ? where country_id = ?" );
			ps.setString( 1, code );
			ps.setString(2, name);
			ps.setInt( 3, id );
			ps.executeUpdate();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.write("<h3 style=color:'green'>updation Successfull</h3>");
		pw.close();
		
	}

}