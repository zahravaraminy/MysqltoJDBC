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

import com.nt.dao.EmpDao;
public class SelectAll extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmpDao dao=new EmpDao();
		List<Country> list=dao.allRecords();
		req.setAttribute( "list", list );
		RequestDispatcher rd = req.getRequestDispatcher( "displayAll.jsp" );
		rd.forward( req, res );
		
		
	}

}