package com.java.cs.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.cs.dao.AssetManagementService;
import com.java.cs.dao.AssetManagementServiceImpl;
import com.java.cs.model.Assets;
import com.java.cs.myexceptions.AssetNotFoundException;

public class SearchAssetsMain {
public static void main(String[] args) throws AssetNotFoundException {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter assets id :");
	int asset_id=sc.nextInt();
	AssetManagementService dao=new AssetManagementServiceImpl();
	try {
		Assets asset=dao.searchAsset(asset_id);
	
		System.out.println(asset);
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
