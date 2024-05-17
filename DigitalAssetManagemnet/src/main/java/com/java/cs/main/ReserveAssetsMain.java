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
import com.java.cs.myexceptions.AssetNotMaintainException;

public class ReserveAssetsMain {

	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException, AssetNotFoundException, AssetNotMaintainException {
		AssetManagementService dao=new AssetManagementServiceImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the asset id :");
		int assetId=sc.nextInt();
		Assets assetsFound = dao.searchAsset(assetId);
		
        if (assetsFound != null) {
            
            if (!dao.checkAssetMaintenance(assetId)) {
                throw new AssetNotMaintainException("Asset with ID " + assetId + " requires maintenance but has not been maintained for two years.");
            }
		
		
		System.out.println("Enter the employee id :");
		int employeeId=sc.nextInt();
		System.out.println("Enter the Reservation date :");
		String reservation_date=sc.next();
		System.out.println("Enter the start date :");
		String start_date=sc.next();
		System.out.println("enter the end date :");
		String end_date=sc.next();
		
		Date reservationDate = null;
	     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 java.util.Date utilDate = dateFormat.parse(reservation_date);
		 reservationDate= new Date(utilDate.getTime());
		 
		 Date startDate = null;
	     SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		 java.util.Date utilDate1 = dateFormat1.parse(start_date);
		 startDate= new Date(utilDate1.getTime());
		 
		 Date endDate = null;
	     SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		 java.util.Date utilDate2= dateFormat2.parse(end_date);
		 endDate= new Date(utilDate2.getTime());
		 
		 
		 
		 boolean success=dao.reserveAsset(assetId, employeeId, reservation_date, start_date, end_date);
		 
		 if(success) {
			 System.out.println("Assert reserved successfully");
		 }
		 else {
			 System.out.println("Assert not reserved");
		 }
        } else {
            throw new AssetNotFoundException("Asset with ID " + assetId + " not found.");
        }
	}
}
