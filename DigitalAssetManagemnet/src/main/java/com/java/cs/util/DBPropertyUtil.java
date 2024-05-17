package com.java.cs.util;

import java.util.ResourceBundle;

public class DBPropertyUtil {

	public static String connectionString(String propertyFile) {
		ResourceBundle rb=ResourceBundle.getBundle(propertyFile);
		return rb.getString("url");
	}
}
