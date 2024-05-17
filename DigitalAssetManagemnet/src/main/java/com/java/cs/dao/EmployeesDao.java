package com.java.cs.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.cs.model.Employees;


public interface EmployeesDao {

	List<Employees> showEmployeesDao() throws ClassNotFoundException, SQLException;
	String addEmployees(Employees employees) throws ClassNotFoundException, SQLException;
	Employees searchEmployees(int employee_id) throws ClassNotFoundException, SQLException;
	String updateEmployees(Employees employees) throws ClassNotFoundException, SQLException;
	
}
