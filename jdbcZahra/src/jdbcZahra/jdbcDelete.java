package jdbcZahra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDelete {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/university?useSSL=false","root","zahra@123");
		
		Statement st= con.createStatement();
		
		
		int result =st.executeUpdate("delete from employee where id=15");
		
		System.out.println("result :" +result);
		
		con.close();
		

	}

}
