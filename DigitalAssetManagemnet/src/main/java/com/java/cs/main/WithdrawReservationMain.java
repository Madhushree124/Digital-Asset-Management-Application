package com.java.cs.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.cs.dao.AssetManagementService;
import com.java.cs.dao.AssetManagementServiceImpl;

public class WithdrawReservationMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the reservation id :");
		int reservationId=sc.nextInt();
		
		AssetManagementService dao=new AssetManagementServiceImpl();
		
		boolean success=dao.withdrawReservation(reservationId);
		
		if(success) {
			 System.out.println("Reservation withdrawn successfully");
		 }
		 else {
			 System.out.println("Reservation not withdrawn");
		 }
	}
}
