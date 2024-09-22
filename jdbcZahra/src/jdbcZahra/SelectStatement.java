package jdbcZahra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/university?useSSL=false","root","zahra@123");
			
			PreparedStatement ps=con.prepareStatement("Select * from employee");
			ResultSet rs= ps.executeQuery();
			
	           while(rs.next()) {
				
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int salary =rs.getInt("salary");
				
				System.out.println(id +" "+name+" "+salary);
				
			}

	}

}
