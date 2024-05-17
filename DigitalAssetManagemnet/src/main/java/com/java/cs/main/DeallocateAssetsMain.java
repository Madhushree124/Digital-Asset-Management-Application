package com.java.cs.main;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.java.cs.dao.AssetManagementService;
import com.java.cs.dao.AssetManagementServiceImpl;
import com.java.cs.myexceptions.AssetNotFoundException;

public class DeallocateAssetsMain {

	public static void main(String[] args) throws ParseException, java.text.ParseException,ClassNotFoundException, SQLException, AssetNotFoundException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the return date :");
		String return_date=sc.next();
		System.out.println("Enter asset id :");
		int assetId=sc.nextInt();
		System.out.println("Enter employee id :");
		int employeeId=sc.nextInt();
		Date returnDate = null;
	     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 java.util.Date utilDate = dateFormat.parse(return_date);
		 returnDate = new Date(utilDate.getTime());
		 AssetManagementService dao=new AssetManagementServiceImpl();
		 boolean success=dao.deallocateAsset(assetId, employeeId, return_date);
		    if (success) {
		        System.out.println("Asset deallocated successfully.");
		    } else {
		        System.out.println("Failed to deallocate asset.");
		    }
		
	}
}
