package com.java.cs;

import java.sql.Date;

import com.java.cs.model.AssetAllocations;
import com.java.cs.model.Assets;
import com.java.cs.model.Employees;
import com.java.cs.model.MaintenanceRecords;
import com.java.cs.model.Reservations;

public class App {

  public static void main(String[] args) {
	  Date reservation_date = Date.valueOf("2024-03-03");
		Date start_date = Date.valueOf("2024-04-03");
		Date end_date = Date.valueOf("2024-05-03");
		Reservations res1=new Reservations(1,3,4,reservation_date,start_date, end_date ,"pending");
	System.out.println(res1);

  }

}
