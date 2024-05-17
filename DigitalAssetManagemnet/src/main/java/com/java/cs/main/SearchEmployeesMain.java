package com.java.cs.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.cs.dao.EmployeesDao;
import com.java.cs.dao.EmployeesDaoImpl;
import com.java.cs.model.Employees;

public class SearchEmployeesMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter emp id :");
		int employee_id=sc.nextInt();
		EmployeesDao dao=new EmployeesDaoImpl();
		try {
			Employees employees=dao.searchEmployees(employee_id);
			
				System.out.println(employees);
		
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
