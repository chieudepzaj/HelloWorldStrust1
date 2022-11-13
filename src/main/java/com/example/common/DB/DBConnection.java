package com.example.common.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection() throws Exception {

		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbdemo", "postgres", "anhchieu99");

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
