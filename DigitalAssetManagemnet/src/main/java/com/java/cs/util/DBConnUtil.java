package com.java.cs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnUtil {

	public static Connection getConnection(String connString) throws SQLException, ClassNotFoundException {
		ResourceBundle rb =ResourceBundle.getBundle("db");
		String driver=rb.getString("driver");
		String user=rb.getString("user");
		String password=rb.getString("password");
		Class.forName(driver);
		Connection connection=DriverManager.getConnection(connString,user,password);
		return connection;
	}
}
