package com.java.cs.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.cs.dao.EmployeesDao;
import com.java.cs.dao.EmployeesDaoImpl;
import com.java.cs.model.Employees;

public class AddEmployeesMain {

	public static void main(String[] args) {
		
		Employees employees=new Employees();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee id :");
		employees.setEmployee_id(sc.nextInt());
		System.out.println("Enter name :");
		employees.setName(sc.next());
		System.out.println("Enter dept:");
		employees.setDepartment(sc.next());
		System.out.println("Enter email :");
		employees.setEmail(sc.next());
		System.out.println("Enter password :");
		employees.setPassword(sc.next());
		
		EmployeesDao dao=new EmployeesDaoImpl();
		
		try {
			System.out.println(dao.addEmployees(employees));
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
