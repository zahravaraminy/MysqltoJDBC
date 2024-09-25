
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.EmpDao;
public class Update extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt( req.getParameter( "t1" ) );
		String code = req.getParameter( "t2" );
		String name = req.getParameter( "t3" );
		
		EmpDao dao=new EmpDao();
		boolean isUpdated=dao.updateSalary(id, name, code);

		if(isUpdated) {
			req.setAttribute("msg", "Salary updation Successfull");
			RequestDispatcher rd=req.getRequestDispatcher("succes.jsp");
			rd.forward(req, res);
		} else {
			req.setAttribute("errorMsg", "Salary updation failed");
			RequestDispatcher rd=req.getRequestDispatcher("error.jsp");
			rd.forward(req, res);
		}
		
	}

}