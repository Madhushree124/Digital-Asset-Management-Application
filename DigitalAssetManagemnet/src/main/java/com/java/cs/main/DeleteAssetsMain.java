package com.java.cs.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.cs.dao.AssetManagementService;
import com.java.cs.dao.AssetManagementServiceImpl;
import com.java.cs.myexceptions.AssetNotFoundException;


public class DeleteAssetsMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, AssetNotFoundException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter asset_id");
		int asset_id=sc.nextInt();
		
		AssetManagementService dao=new AssetManagementServiceImpl();
		 boolean success=dao.deleteAsset(asset_id);
		    if (success) {
		        System.out.println("Asset deleted successfully.");
		    } else {
		        System.out.println("Failed to deleted asset.");
		    }
		
	}
}
