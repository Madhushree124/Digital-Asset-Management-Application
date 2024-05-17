package com.java.cs;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.java.cs.model.Reservations;

public class ReservationsTest {
	@Test
	public void testEquals() {
		Date reservation_date = Date.valueOf("2024-03-03");
		Date start_date = Date.valueOf("2024-04-03");
		Date end_date = Date.valueOf("2024-05-03");
		Reservations res1=new Reservations(1,3,4,reservation_date,start_date, end_date ,"pending");
		Reservations res2=new Reservations(1,3,4,reservation_date,start_date, end_date ,"pending");
		Reservations res3=new Reservations(1,12,4,reservation_date,start_date, end_date ,"pending");
		assertTrue(res1.equals(res2));
		assertFalse(res1.equals(res3));

	}
	
	@Test
	public void testHashCode() {
		Date reservation_date = Date.valueOf("2024-03-03");
		Date start_date = Date.valueOf("2024-04-03");
		Date end_date = Date.valueOf("2024-05-03");
		Reservations res1=new Reservations(1,3,4,reservation_date,start_date, end_date ,"pending");
		Reservations res2=new Reservations(1,3,4,reservation_date,start_date, end_date ,"pending");
		assertEquals(res1.hashCode(), res2.hashCode());

	}
	@Test
	public void testToString() {
		Date reservation_date = Date.valueOf("2024-03-03");
		Date start_date = Date.valueOf("2024-04-03");
		Date end_date = Date.valueOf("2024-05-03");
		Reservations res1=new Reservations(1,3,4,reservation_date,start_date, end_date ,"pending");
		String res="Reservations [reservation_id=1, asset_id=3, employee_id=4, reservation_date=2024-03-03, start_date=2024-04-03, end_date=2024-05-03, status=pending]";
		assertEquals(res,res1.toString());
	}
	
	@Test 
	public void testGettersAndSetters() {
		Date reservation_date = Date.valueOf("2024-03-03");
		Date start_date = Date.valueOf("2024-04-03");
		Date end_date = Date.valueOf("2024-05-03");
		Reservations res1=new Reservations(1,3,4,reservation_date,start_date, end_date ,"pending");
		res1.setReservation_id(1);
		res1.setAsset_id(3);
		res1.setEmployee_id(4);
		res1.setReservation_date(reservation_date);
		res1.setStart_date(start_date);
		res1.setEnd_date(end_date);
		res1.setStatus("pending");
		
		assertEquals(1, res1.getReservation_id());
		assertEquals(3, res1.getAsset_id());
		assertEquals(4, res1.getEmployee_id());
		assertEquals(reservation_date, res1.getReservation_date());
		assertEquals(start_date, res1.getStart_date());
		assertEquals(end_date, res1.getEnd_date());
		assertEquals("pending", res1.getStatus());
	}

	@Test
	public void testConstructors() {
		Reservations res=new Reservations();
		assertNotNull(res);

		Date reservation_date = Date.valueOf("2024-03-03");
		Date start_date = Date.valueOf("2024-04-03");
		Date end_date = Date.valueOf("2024-05-03");
		Reservations res1=new Reservations(1,3,4,reservation_date,start_date, end_date ,"pending");
		assertEquals(1, res1.getReservation_id());
		assertEquals(3, res1.getAsset_id());
		assertEquals(4, res1.getEmployee_id());
		assertEquals(reservation_date, res1.getReservation_date());
		assertEquals(start_date, res1.getStart_date());
		assertEquals(end_date, res1.getEnd_date());
		assertEquals("pending", res1.getStatus());
	}

}
