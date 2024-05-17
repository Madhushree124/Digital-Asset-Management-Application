package com.java.cs;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.cs.model.Employees;

public class EmployeesTest {
	
	@Test
	public void testEquals() {
		Employees employees1=new Employees(2,"Madhu","IT","madhu@gmail.com","pass123");
		Employees employees2=new Employees(2,"Madhu","IT","madhu@gmail.com","pass123");
		Employees employees3=new Employees(2,"Madhu","IT","madhu@gmail.com","pass");
		assertTrue(employees1.equals(employees2));
		assertFalse(employees1.equals(employees3));
	}
	@Test
	public void testHashCode() {
		Employees employees1=new Employees(2,"Madhu","IT","madhu@gmail.com","pass123");
		Employees employees2=new Employees(2,"Madhu","IT","madhu@gmail.com","pass123");
 
		assertEquals(employees1.hashCode(),employees2.hashCode());

	}
	@Test 
	public void testToString() {
		Employees employees1=new Employees(2,"Madhu","IT","madhu@gmail.com","pass123");
        String result="Employees [employee_id=2, name=Madhu, department=IT, email=madhu@gmail.com, password=pass123]";
        assertEquals(result, employees1.toString());
	}
		
	
	@Test
	public void testGettersandSetters() {
		Employees employees=new Employees();
		employees.setEmployee_id(2);
		employees.setName("Madhu");
		employees.setDepartment("IT");
		employees.setEmail("madhu@gmail.com");
		employees.setPassword("pass123");
		assertEquals(2, employees.getEmployee_id());
		assertEquals("Madhu", employees.getName());
		assertEquals("IT",employees.getDepartment());
		assertEquals("madhu@gmail.com",employees.getEmail());
		assertEquals( "pass123", employees.getPassword());
		
	}

	@Test
	public void testConstructors() {
		Employees employees=new Employees();
		assertNotNull(employees);
		Employees employees1=new Employees(2,"Madhu","IT","madhu@gmail.com","pass123");
		assertNotNull(employees1);
		assertEquals(2, employees1.getEmployee_id());
		assertEquals("Madhu", employees1.getName());
		assertEquals("IT",employees1.getDepartment());
		assertEquals("madhu@gmail.com",employees1.getEmail());
		assertEquals( "pass123", employees1.getPassword());
	}
	
	

}
