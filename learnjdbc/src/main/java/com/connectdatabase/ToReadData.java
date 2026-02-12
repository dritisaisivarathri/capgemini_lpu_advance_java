package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ToReadData {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5433/school";
		String un = "postgres";
		String pwd = "root";
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("org.postgresql.Driver");
			
				Connection connect = DriverManager.getConnection(url,un,pwd);
				//taking data from user
				String sql = "insert into student values(?,?,?,?)";
				
				//prepare statement to read input from user //dynamic 
				PreparedStatement pstm = connect.prepareStatement(sql);
				
				System.out.println("Enter Id: ");
				int id = sc.nextInt();
				pstm.setInt(1,id);
				System.out.println("Enter Name: ");
				String name = sc.next();
				pstm.setString(2, name);
				System.out.println("Enter Email: ");
				String email = sc.next();
				pstm.setString(3, email);
				System.out.println("Enter Gender: ");
				String gender = sc.next();
				pstm.setString(4, gender);
				
				pstm.execute();
				
				connect.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
	
	}

