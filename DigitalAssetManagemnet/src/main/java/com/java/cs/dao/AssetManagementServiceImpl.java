package com.java.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.cs.model.Assets;
import com.java.cs.myexceptions.AssetNotFoundException;
import com.java.cs.util.DBConnUtil;
import com.java.cs.util.DBPropertyUtil;

public class AssetManagementServiceImpl implements AssetManagementService {

	Connection connection;
	PreparedStatement pst;
	
	@Override
	public boolean addAsset(Assets asset) throws ClassNotFoundException, SQLException {
		
		String connStr=DBPropertyUtil.connectionString("db");
		connection=DBConnUtil.getConnection(connStr);
		
		String cmd="Insert into assets (asset_id,name,type,serial_number,purchase_date,location,status,owner_id)"
				+ " values(?,?,?,?,?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, asset.getAsset_id());
		pst.setString(2,asset.getName());
		pst.setString(3,asset.getType());
		pst.setInt(4, asset.getSerial_number());
        pst.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
		pst.setString(6, asset.getLocation());
		pst.setString(7, asset.getStatus());
		pst.setInt(8, asset.getOwner_id());
		int rowsInserted = pst.executeUpdate();

        return rowsInserted > 0; 
	}
	
	@Override
	public boolean UpdateAsset(Assets asset) throws ClassNotFoundException, SQLException, AssetNotFoundException {
		try {

		Assets assetsfound=searchAsset(asset.getAsset_id());
		if(assetsfound!=null) {

		String connStr=DBPropertyUtil.connectionString("db");
		connection=DBConnUtil.getConnection(connStr);
		String cmd="Update assets set name=?,type=?,serial_number=?,purchase_date=?,location=?,status=?,owner_id=? where asset_id=?";
		pst=connection.prepareStatement(cmd);
		pst.setString(1, asset.getName());
		pst.setString(2,asset.getType());
		pst.setInt(3, asset.getSerial_number());
		pst.setDate(4, new java.sql.Date(asset.getPurchase_date().getTime()));
		pst.setString(5, asset.getLocation());
		pst.setString(6, asset.getStatus());
		pst.setInt(7, asset.getOwner_id());
		pst.setInt(8, asset.getAsset_id());
		int rowUpdated=pst.executeUpdate();
		return rowUpdated>0;
		}
		else {
			throw new AssetNotFoundException("Asset is not found");
			
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public Assets searchAsset(int asset_id) throws ClassNotFoundException, SQLException, AssetNotFoundException {
		
		String connStr=DBPropertyUtil.connectionString("db");
		connection=DBConnUtil.getConnection(connStr);
		String cmd="Select * from assets where asset_id=?";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, asset_id);
		ResultSet rs=pst.executeQuery();
		Assets asset=null;
		if(rs.next()) {
			asset=new Assets();
			asset.setAsset_id(rs.getInt("asset_id"));
			asset.setName(rs.getString("name"));
			asset.setType(rs.getString("type"));
			asset.setSerial_number(rs.getInt("serial_number"));
			asset.setPurchase_date(rs.getDate("purchase_date"));
			asset.setLocation(rs.getString("location"));
			asset.setStatus(rs.getString("status"));
			asset.setOwner_id(rs.getInt("owner_id"));
		
		}else {
            throw new AssetNotFoundException("Asset with ID " + asset_id + " not found.");
        }
		
		return asset;
	}
	
	
	@Override
	public boolean deleteAsset(int asset_id) throws ClassNotFoundException, SQLException, AssetNotFoundException {
		Assets assetsfound=searchAsset(asset_id);
		if(assetsfound!=null) {
			String connStr=DBPropertyUtil.connectionString("db");
			connection=DBConnUtil.getConnection(connStr);
			String cmd="delete from assets where asset_id=?";
			pst=connection.prepareStatement(cmd);
			pst.setInt(1, asset_id);
			int rowsDeleted=pst.executeUpdate();
			return rowsDeleted>0;
		}
		else {
            throw new AssetNotFoundException("Asset with ID " + asset_id + " not found.");
        }
		
		
	}

	@Override
	public boolean allocateAsset(int assetId, int employeeId, String allocationDate) throws ClassNotFoundException, SQLException, AssetNotFoundException {
		Assets assetsfound=searchAsset(assetId);
		if(assetsfound!=null) {
		String connStr=DBPropertyUtil.connectionString("db");
		connection=DBConnUtil.getConnection(connStr);
		String cmd="Insert into asset_allocations(asset_id,employee_id,allocation_date) values(?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, assetId);
		pst.setInt(2, employeeId);
		pst.setString(3, allocationDate);
		int rowInserted=pst.executeUpdate();
		
		return rowInserted>0;
		}
		else {
            throw new AssetNotFoundException("Asset with ID " + assetId + " not found.");
        }
	}

	@Override
	public boolean deallocateAsset(int assetId, int employeeId, String returnDate) throws ClassNotFoundException, SQLException, AssetNotFoundException {
		Assets assetsfound=searchAsset(assetId);
		if(assetsfound!=null) {
		String connStr=DBPropertyUtil.connectionString("db");
		connection=DBConnUtil.getConnection(connStr);
		String cmd="Update asset_allocations set return_date=? where asset_id=? and employee_id=?";
		pst=connection.prepareStatement(cmd);
		pst.setString(1, returnDate);
		pst.setInt(2, assetId);
		pst.setInt(3, employeeId);
		int rowsDeallocated=pst.executeUpdate();
		
		return rowsDeallocated>0;
	    }
	    else {
        throw new AssetNotFoundException("Asset with ID " + assetId + " not found.");
        }
	}

	@Override
	public boolean performMaintenance(int assetId, String maintenanceDate, String description, double cost) throws ClassNotFoundException, SQLException, AssetNotFoundException {
		Assets assetsfound=searchAsset(assetId);
		if(assetsfound!=null) {
		String connStr=DBPropertyUtil.connectionString("db");
		connection=DBConnUtil.getConnection(connStr);
		String cmd="Insert into  maintenance_records( asset_id, maintenance_date, description, cost) values (?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, assetId);
		pst.setString(2, maintenanceDate);
		pst.setString(3, description);
		pst.setDouble(4, cost);
		int rowInserted=pst.executeUpdate();
		
		return rowInserted>0;
		}
	    else {
        throw new AssetNotFoundException("Asset with ID " + assetId + " not found.");
        }
	}

	@Override
	public boolean reserveAsset(int assetId, int employeeId, String reservationDate, String startDate, String endDate) throws ClassNotFoundException, SQLException, AssetNotFoundException {
		Assets assetsfound=searchAsset(assetId);
		if(assetsfound!=null) {
		String connStr=DBPropertyUtil.connectionString("db");
		connection=DBConnUtil.getConnection(connStr);
		String cmd="Insert into reservations ( asset_id, employee_id, reservation_date, start_date, end_date, status) "
				+ "values (?,?,?,?,?,'pending')";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, assetId);
		pst.setInt(2, employeeId);
		pst.setString(3, reservationDate);
		pst.setString(4, startDate);
		pst.setString(5, endDate);
		int rowInserted=pst.executeUpdate();
		
		return rowInserted>0;
	    }
        else {
        throw new AssetNotFoundException("Asset with ID " + assetId + " not found.");
        }
	}

	@Override
	public boolean withdrawReservation(int reservationId) throws ClassNotFoundException, SQLException {
		String connStr=DBPropertyUtil.connectionString("db");
		connection=DBConnUtil.getConnection(connStr);
		String cmd="Update reservations set status='cancelled' where reservation_id=?";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, reservationId);
		
		int rowUpdated=pst.executeUpdate();
		return rowUpdated>0;
		
	}

	@Override
	public boolean checkAssetMaintenance(int assetId) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			String connStr=DBPropertyUtil.connectionString("db");
			connection=DBConnUtil.getConnection(connStr);
	        
	        String cmd = "SELECT COUNT(*) FROM maintenance_records WHERE asset_id = ? AND maintenance_date >= DATE_SUB(CURDATE(), INTERVAL 2 YEAR)";
	        pst = connection.prepareStatement(cmd);
	        pst.setInt(1, assetId);
	        ResultSet rs = pst.executeQuery();

	        // If there are maintenance records within the last two years, set isMaintained to true
	        if (rs.next()) {
	            int count = rs.getInt(1);
	            if (count > 0) {
	                return true;
	            }
	        }
	        else{
	        	return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}

	
	
	
}
