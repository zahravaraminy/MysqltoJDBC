package jdbcZahra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcSelect {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/university?useSSL=false","root","zahra@123");
		
		Statement st=con.createStatement();
		
		ResultSet rs= st.executeQuery("select * from employee");
		
		
		while(rs.next()) {
			
			int id=rs.getInt("id");
			String name=rs.getString("name");
			int salary =rs.getInt("salary");
			
			System.out.println(id +" "+name+" "+salary);
			
		}
		
		con.close();
		
		
		
	}

}
