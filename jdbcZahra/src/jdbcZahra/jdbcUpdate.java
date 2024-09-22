package jdbcZahra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university?useSSL=false","root","zahra@123");
		
		Statement st= con.createStatement();
		
		int result =st.executeUpdate("update employee set salary=1000 where id=12");
		
		System.out.println("Result: " +result);
		
		con.close();
	}

}
