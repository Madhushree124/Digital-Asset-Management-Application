package com.java.cs;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.java.cs.model.AssetAllocations;

public class AssetAllocationTest {
	@Test
	public void testEquals() {
		Date allocation_date = Date.valueOf("2024-03-03");
		Date return_date = Date.valueOf("2024-04-03");
		AssetAllocations assetallocations1=new AssetAllocations(1,2,4,allocation_date,return_date);
		AssetAllocations assetallocations2=new AssetAllocations(1,2,4,allocation_date,return_date);
		AssetAllocations assetallocations3=new AssetAllocations(1,2,10,allocation_date,return_date);
		assertTrue(assetallocations1.equals(assetallocations2));
		assertFalse(assetallocations1.equals(assetallocations3));

	}
	
	@Test
	public void testHashCode() {
		Date allocation_date = Date.valueOf("2024-03-03");
		Date return_date = Date.valueOf("2024-04-03");
		AssetAllocations assetallocations1=new AssetAllocations(1,2,4,allocation_date,return_date);
		AssetAllocations assetallocations2=new AssetAllocations(1,2,4,allocation_date,return_date);

		assertEquals(assetallocations1.hashCode(), assetallocations2.hashCode());
	}
	@Test
	public void testToString() {
		Date allocation_date = Date.valueOf("2024-03-03");
		Date return_date = Date.valueOf("2024-04-03");
		AssetAllocations assetallocations1=new AssetAllocations(1,2,4,allocation_date,return_date);
		String result="AssetAllocations [allocation_id=1, asset_id=2, employee_id=4, allocation_date=2024-03-03, return_date=2024-04-03]";
		assertEquals(result, assetallocations1.toString());
	}

	@Test
	public void testGettersandSetters() {
		Date allocation_date = Date.valueOf("2024-03-03");
		Date return_date = Date.valueOf("2024-04-03");
		AssetAllocations assetallocations1=new AssetAllocations(1,2,4,allocation_date,return_date);
		
		assetallocations1.setAllocation_id(1);
		assetallocations1.setAsset_id(2);
		assetallocations1.setEmployee_id(4);
		assetallocations1.setAllocation_date(allocation_date);
		assetallocations1.setReturn_date(return_date);
		
		assertEquals(1, assetallocations1.getAllocation_id());
		assertEquals(2, assetallocations1.getAsset_id());
		assertEquals(4, assetallocations1.getEmployee_id());
		assertEquals(allocation_date, assetallocations1.getAllocation_date());
		assertEquals(return_date, assetallocations1.getReturn_date());
	}
	@Test
	public void testConstructors() {
		AssetAllocations assetallocations=new AssetAllocations();
		assertNotNull(assetallocations);
		Date allocation_date = Date.valueOf("2024-03-03");
		Date return_date = Date.valueOf("2024-04-03");
		AssetAllocations assetallocations1=new AssetAllocations(1,2,4,allocation_date,return_date);
		assertNotNull(assetallocations1);
		assertEquals(1, assetallocations1.getAllocation_id());
		assertEquals(2, assetallocations1.getAsset_id());
		assertEquals(4, assetallocations1.getEmployee_id());
		assertEquals(allocation_date, assetallocations1.getAllocation_date());
		assertEquals(return_date, assetallocations1.getReturn_date());
	}

}
