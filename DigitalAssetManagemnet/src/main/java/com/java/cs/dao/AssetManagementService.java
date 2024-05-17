package com.java.cs.dao;

import java.sql.SQLException;

import com.java.cs.model.Assets;
import com.java.cs.myexceptions.AssetNotFoundException;

public interface AssetManagementService {

	 boolean addAsset(Assets asset) throws ClassNotFoundException, SQLException ;
	 boolean UpdateAsset(Assets asset) throws ClassNotFoundException, SQLException, AssetNotFoundException;
	 Assets searchAsset(int asset_id) throws ClassNotFoundException, SQLException, AssetNotFoundException;
	 boolean deleteAsset(int asset_id) throws ClassNotFoundException, SQLException, AssetNotFoundException;
	 boolean allocateAsset(int assetId, int employeeId, String allocationDate) throws ClassNotFoundException, SQLException, AssetNotFoundException;
	 boolean deallocateAsset(int assetId, int employeeId, String returnDate) throws ClassNotFoundException, SQLException, AssetNotFoundException;
	 boolean performMaintenance(int assetId, String maintenanceDate,String description, double cost) throws ClassNotFoundException, SQLException, AssetNotFoundException;
	 boolean reserveAsset(int assetId, int employeeId, String reservationDate, String startDate, String endDate) throws ClassNotFoundException, SQLException, AssetNotFoundException;
	 boolean withdrawReservation(int reservationId) throws ClassNotFoundException, SQLException;
	 boolean checkAssetMaintenance(int assetId) throws ClassNotFoundException ;

}
