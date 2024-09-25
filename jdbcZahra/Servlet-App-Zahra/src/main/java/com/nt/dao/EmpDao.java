package com.nt.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.nt.Country;
import com.nt.utility.ConnectionFactory;

public class EmpDao {
	
	
	
	public boolean register(Country e) {
		try {
			Connection con=ConnectionFactory.getCon();
			PreparedStatement ps = con.prepareStatement( "insert into country values(?,?,?)" );
			ps.setInt( 1, e.getId() );
			ps.setString( 2, e.getCode() );
			ps.setString( 3, e.getName() );
			int result=ps.executeUpdate();
			if(result==1)
				return true;
		} catch ( Exception ex ) {
			ex.printStackTrace();
		}
		return false;
		
	}
	
	public boolean updateSalary(int id, String code, String name ) {
		try {
			Connection con=ConnectionFactory.getCon();
			PreparedStatement ps = con.prepareStatement( "update country set country_iso_code = ?,country_name = ? where country_id = ?" );
			ps.setString( 1, code );
			ps.setString(2, name);
			ps.setInt( 3, id );
			int result=ps.executeUpdate();
			if(result==1) {
				return true;
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return false;
	}
	public Country getById(int id) {
		try {
			Connection con=ConnectionFactory.getCon();
			PreparedStatement ps = con.prepareStatement( "Select * from country where country_id = ?" );
			ps.setInt( 1, id);
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				int i = rs.getInt("country_id");
				String code = rs.getString("country_iso_code");
				String name = rs.getString("country_name");
				
				Country c = new Country( i, code, name);
				return c;
			}
			else {
				return null;
			}
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Country> allRecords(){
		
		try {
			Connection con=ConnectionFactory.getCon();
			PreparedStatement ps = con.prepareStatement( "Select * from country" );
			ResultSet rs = ps.executeQuery();
			List<Country> list = new ArrayList<>();
			
			while(rs.next()) {
				int i = rs.getInt("country_id");
				String code = rs.getString("country_iso_code");
				String name = rs.getString("country_name");
				
				Country c = new Country( i, code, name);
				
				list.add(c);
			}
				
			return list;
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
		
	}

}
