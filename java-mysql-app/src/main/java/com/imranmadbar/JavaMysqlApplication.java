package com.imranmadbar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JavaMysqlApplication {

	public static void main(String[] args) {
        System.out.println("JavaMysqlApplication starting.");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arif_travel_agencydb", "root",
					"root");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM arif_travel_agencydb.location_tbl");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			
			con.close();
			
			  Thread.sleep(15000);
			  
			  
		} catch (Exception e) {
			System.out.println(e);
		}
		
        System.out.println("JavaMysqlApplication Close");
	}
	
	

}
