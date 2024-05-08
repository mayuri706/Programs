package com.cadd.foodplaza.utility;
//DBUtility or DBConnection
//code for Cnnecting to mysql Database

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	//establishConnection() or getConnection
	
	public static Connection establishConnection() throws ClassNotFoundException, SQLException
	{
		String url,user,pass; 
		url="jdbc:mysql://localhost:3306/foodplaza_mayuri";
		user="root";
		pass="mayuri2811@";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection(url,user,pass);
		
		return conn;
	}

}
