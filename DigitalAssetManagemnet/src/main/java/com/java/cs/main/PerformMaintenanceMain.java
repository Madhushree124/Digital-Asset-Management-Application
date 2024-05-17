package com.java.cs.main;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.java.cs.dao.AssetManagementService;
import com.java.cs.dao.AssetManagementServiceImpl;
import com.java.cs.myexceptions.AssetNotFoundException;

public class PerformMaintenanceMain {

	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException, AssetNotFoundException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the asset id :");
		int assetId=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the maintenance date :");
		String maintenance_date=sc.nextLine();
		
		System.out.println("Enter the description :");
		String description=sc.nextLine();
	
		System.out.println("Enter cost :");
		double cost=sc.nextDouble();
		
		Date maintenanceDate = null;
	     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 java.util.Date utilDate = dateFormat.parse(maintenance_date);
		 maintenanceDate = new Date(utilDate.getTime());
		 
		 AssetManagementService dao=new AssetManagementServiceImpl();
		 boolean success = dao.performMaintenance(assetId, maintenance_date, description, cost);
		 if (success) {
		        System.out.println("Maintenance activity successfully recorded.");
		    } else {
		        System.out.println("Failed to record maintenance activity.");
		    }
		 
	}
}
