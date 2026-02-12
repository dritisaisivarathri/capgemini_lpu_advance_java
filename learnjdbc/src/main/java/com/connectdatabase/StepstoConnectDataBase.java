package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StepstoConnectDataBase {
	public static void main(String[] args) {
		//LOAD THE DRIVER CLASS
		String url = "jdbc:postgresql://localhost:5433/school";
		String un = "postgres";
		String pwd = "root";
		try {
			Class.forName("org.postgresql.Driver");
			
			
			//TO ESTABLISH THE CONNECTION
			
			try {
				Connection connect = DriverManager.getConnection(url,un,pwd);
				
				String sql = "insert into student values (1,'Miller','miller@gmail.com','male')";
				System.out.println("Connection created");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Class loaded");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
