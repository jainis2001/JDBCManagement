package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static final String URL="jdbc:mysql:///crudofjdbc";
	public static final String USERNAME="root";
	public static final String PASSWORD="Password";
	public static Connection getConnection(){
		Connection con=null;
		try{
			con= DriverManager.getConnection(URL,USERNAME,PASSWORD);
			if(con==null){
				System.err.println("Database Connection Failed!");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return  con;

	}
}
