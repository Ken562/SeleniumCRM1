package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection Con;
	public void getDatabaseConeection(String url, String username, String password) throws SQLException {
		try {
        Driver driver=new Driver();
        DriverManager.registerDriver(driver);
        Con = DriverManager.getConnection(url,username,password );
		}
		catch(Exception e) {
			
		}
	}
	public void getDatabaseConeection() throws SQLException {
		try {
        Driver driver=new Driver();
        DriverManager.registerDriver(driver);
        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root" );
		}
		catch(Exception e) {
			
		}
	}
	
	public void closeConnection() throws SQLException {
		try {
		Con.close();
		}
		catch(Exception e) {}
	}
	public ResultSet SelectQuery(String Query) throws Exception {
		ResultSet result=null;
		try {
		Statement stat = Con.createStatement();
		 result = stat.executeQuery(Query);
		}
		catch(Exception e) {
			
		}
		
		 return  result;
		
	}
	public int ExecuteNonSelectQuery(String Query) throws Exception {
		
		int result=0;
		try {
		Statement stat = Con.createStatement();
		 result = stat.executeUpdate(Query);
		}
		catch(Exception e) {
			
		}
		
		 return  result;
		
	}
	
}
