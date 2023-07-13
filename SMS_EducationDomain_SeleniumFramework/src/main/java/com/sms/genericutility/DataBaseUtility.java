package com.sms.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mysql.jdbc.Driver;

public class DataBaseUtility 
{
	Driver driver;
	Connection connection;
	ResultSet result;
   FileUtility fLib = new FileUtility();
   String URL;
   String USERNAME;
   String PASSWORD;
   
	 public DataBaseUtility() {
		 try {
			String filepath = fLib.getFilePathFromPropertiesFile("databaseConfigFilePath");
			URL = fLib.getDataFromProperties(filepath, "url");
			USERNAME = fLib.getDataFromProperties(filepath, "username");
			PASSWORD = fLib.getDataFromProperties(filepath, "password");
		 }
		 catch(Throwable e)
		 {
			 
		 }
	 }
	
	public void connectDB() throws SQLException {
		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeDB() throws SQLException {
		try {
		  connection.close();
		}catch (Exception e) {
		}


	}

	public ResultSet execyteQuery(String query) throws Throwable {	
			result = connection.createStatement().executeQuery(query);
			return result;		
	}
	
	public int execyteUpdate(String query) throws Throwable {
		
			int result = connection.createStatement().executeUpdate(query);
	
		return result;

	}

	public boolean executeQuerryAndVerify(String querry,int cloumnIndex,String expectedData) throws Throwable {
		boolean flag=false;
		result=connection.createStatement().executeQuery(querry);
		while(result.next()) {
			if(result.getString(cloumnIndex).equals(expectedData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expectedData+"==>Data is verified in the data base table");
			return flag;
		}else {
			System.out.println(expectedData+"==>data is not verified in the database");
			return flag;
		}
}
}
