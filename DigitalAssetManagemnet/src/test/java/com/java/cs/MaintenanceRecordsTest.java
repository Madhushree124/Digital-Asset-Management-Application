package com.java.cs;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.java.cs.model.MaintenanceRecords;

public class MaintenanceRecordsTest {
	
	@Test
	public void testEquals() {
		Date maintenance_date= Date.valueOf("2024-03-03");
		MaintenanceRecords mr1=new MaintenanceRecords(1,3,maintenance_date,"Tighten Screws",35.00);
		MaintenanceRecords mr2=new MaintenanceRecords(1,3,maintenance_date,"Tighten Screws",35.00);
		MaintenanceRecords mr3=new MaintenanceRecords(1,8,maintenance_date,"Tighten Screws",35.00);
		assertTrue(mr1.equals(mr2));
		assertFalse(mr1.equals(mr3));

	}
	@Test
	public void testHashCode() {
		Date maintenance_date= Date.valueOf("2024-03-03");
		MaintenanceRecords mr1=new MaintenanceRecords(1,3,maintenance_date,"Tighten Screws",35.00);
		MaintenanceRecords mr2=new MaintenanceRecords(1,3,maintenance_date,"Tighten Screws",35.00);
		assertEquals(mr1.hashCode(), mr2.hashCode());
	}
	
	
	@Test
	public void testToString() {
		Date maintenance_date= Date.valueOf("2024-03-03");
		MaintenanceRecords mr1=new MaintenanceRecords(1,3,maintenance_date,"Tighten Screws",35.00);
		String res="MaintenanceRecords [maintenance_id=1, asset_id=3, maintenance_date=2024-03-03, description=Tighten Screws, cost=35.0]";
		assertEquals(res, mr1.toString());
	}
	@Test
	public void testGettersAndSetters() {
		Date maintenance_date= Date.valueOf("2024-03-03");
		MaintenanceRecords mr1=new MaintenanceRecords(1,3,maintenance_date,"Tighten Screws",35.00);
		
		mr1.setMaintenance_id(1);
		mr1.setAsset_id(3);
		mr1.setMaintenance_date(maintenance_date);
		mr1.setDescription("Tighten Screws");
		mr1.setCost(35.00);
		assertEquals(1, mr1.getMaintenance_id());
		assertEquals(3, mr1.getAsset_id());
		assertEquals(maintenance_date, mr1.getMaintenance_date());
		assertEquals("Tighten Screws", mr1.getDescription());
		assertEquals(35.00, mr1.getCost(), 0);
	}

	@Test
	public void testConstructors() {
		MaintenanceRecords mr=new MaintenanceRecords();
		assertNotNull(mr);
		
		Date maintenance_date= Date.valueOf("2024-03-03");
		MaintenanceRecords mr1=new MaintenanceRecords(1,3,maintenance_date,"Tighten Screws",35.00);
		assertEquals(1, mr1.getMaintenance_id());
		assertEquals(3, mr1.getAsset_id());
		assertEquals(maintenance_date, mr1.getMaintenance_date());
		assertEquals("Tighten Screws", mr1.getDescription());
		assertEquals(35.00, mr1.getCost(), 0);

		
	}

}
