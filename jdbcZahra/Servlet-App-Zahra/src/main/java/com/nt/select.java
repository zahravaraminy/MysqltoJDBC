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

import com.nt.dao.EmpDao;

public class Select extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt( req.getParameter( "t1" ) );
		
		EmpDao dao=new EmpDao();
		Country c=dao.getById(id);

		if (c==null) {
			req.setAttribute("msg", "No record found");
			RequestDispatcher rd=req.getRequestDispatcher("succes.jsp");
			rd.forward(req, res);
		} else {
			RequestDispatcher rd=req.getRequestDispatcher("display.jsp");
			rd.forward(req, res);
		}
		
		
	}
	
	

}