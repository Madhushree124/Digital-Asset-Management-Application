package com.java.cs.main;

import java.sql.SQLException;
import java.util.List;

import com.java.cs.dao.EmployeesDao;
import com.java.cs.dao.EmployeesDaoImpl;
import com.java.cs.model.Employees;

public class ShowEmployeesMain {

	public static void main(String[] args) {
		EmployeesDao dao=new EmployeesDaoImpl();
		try {
			List<Employees> employeesList=dao.showEmployeesDao();
			for(Employees employees:employeesList) {
				System.out.println(employees);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
