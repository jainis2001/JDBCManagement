package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection(){
		Connection con=null;
		try{
			con= DriverManager.getConnection("jdbc:mysql:///crudofjdbc","root","Patel67&");
			if(con==null){
				System.err.println("Database Connection Failed!");
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return  con;

	}
}
