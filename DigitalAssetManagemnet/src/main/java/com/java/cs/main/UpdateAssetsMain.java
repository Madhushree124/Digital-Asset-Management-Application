package com.java.cs.main;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.java.cs.dao.AssetManagementService;
import com.java.cs.dao.AssetManagementServiceImpl;
import com.java.cs.model.Assets;
import com.java.cs.myexceptions.AssetNotFoundException;

public class UpdateAssetsMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, AssetNotFoundException {
		Scanner sc=new Scanner(System.in);
		int asset_id ,serial_number,owner_id;
		String name,type,location,status;
		String  purchase_date;
		
		System.out.println("Enter name :");
		name=sc.next();
		System.out.println("Enter the type :");
		type=sc.next();
		System.out.println("Enter the serial number");
		serial_number=sc.nextInt();
		sc.nextLine();
	    System.out.println("Enter a purchased date :");
	    purchase_date=sc.nextLine();
		System.out.println("Enter the location");
		location=sc.nextLine();
		System.out.println("Enter the status");
		status=sc.nextLine();
		System.out.println("Enter the owner id :");
		owner_id=sc.nextInt();
		System.out.println("Enter a asset id : ");
		asset_id=sc.nextInt();
		
		Date purchaseDate = null;
	     try {
	         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	         java.util.Date utilDate = dateFormat.parse(purchase_date);
	         purchaseDate = new Date(utilDate.getTime()); 
	     } catch (ParseException e) {
	         System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
	         return; 
	     }

		Assets asset = new Assets();
	    asset.setName(name);
	    asset.setType(type);
	    asset.setSerial_number(serial_number);
	    asset.setPurchase_date(purchaseDate);
	    asset.setLocation(location);
	    asset.setStatus(status);
	    asset.setOwner_id(owner_id);
	    asset.setAsset_id(asset_id);
	    
	    AssetManagementService dao = new AssetManagementServiceImpl();
	    boolean success=dao.UpdateAsset(asset);
	    if (success) {
	        System.out.println("Asset updated successfully.");
	    } else {
	        System.out.println("Failed to updated asset.");
	    }
	  
		
	}
}
