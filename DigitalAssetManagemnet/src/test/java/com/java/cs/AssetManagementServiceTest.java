package com.java.cs;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.java.cs.dao.AssetManagementService;
import com.java.cs.dao.AssetManagementServiceImpl;
import com.java.cs.model.Assets;
import com.java.cs.myexceptions.AssetNotFoundException;
import com.java.cs.util.DBConnUtil;
import com.java.cs.util.DBPropertyUtil;

public class AssetManagementServiceTest {

	private AssetManagementService dao;

    private Connection connection;
	PreparedStatement pst;
	
    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
    	dao= new AssetManagementServiceImpl();
    	
    	String connStr=DBPropertyUtil.connectionString("db");
		connection=DBConnUtil.getConnection(connStr);
    }
    
    @Test
    public void testaddAsset() {
        
        int asset_id=28;
        String name="Laptop";
        String type="Electronics";
        int serial_number=12345;
        Date purchaseDate = Date.valueOf("2024-03-03");
        String location="Office D";
        String status="Available";
        int owner_id=1;

        
        Assets asset=new Assets(asset_id, name, type, serial_number, purchaseDate, location, status, owner_id);
        try {
            boolean isCreated = dao.addAsset(asset);
            assertTrue("Asset should be created successfully.", isCreated);
        }  catch (ClassNotFoundException e) {
            fail("ClassNotFoundException should not be thrown: " + e.getMessage());
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	


	 @Test
	    public void addAssetToMaintenance() {
	        int assetId = 1;
	        String maintenanceDate = "2023-05-01";
	        String description = "Tighten screws";
	        double cost = 100.0; 
				try {
					 boolean isAdded= dao.performMaintenance(assetId, maintenanceDate, description, cost);
					assertTrue("Asset should be added to maintenance successfully.", isAdded);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (AssetNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	       
	    }
	 
	 @Test 
	 public void addReserveAsset() {
		 int asset_id=1;
		 int employee_id=3;
		 String reservation_date="2024-02-02";
		 String start_date="2024-03-03";
		 String end_date="2024-05-05";
		 try {
			boolean isReserved=dao.reserveAsset(asset_id, employee_id, reservation_date, start_date,end_date);
			assertTrue("Asset should be added to reservations successfully",isReserved);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AssetNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
	 
	 @Test
	    public void testAssetNotFoundException() {
	        int AssetId = 999;
	        try {
	            dao.searchAsset(AssetId);
	            fail("Expected AssetNotFoundException to be thrown.");
	        } catch (AssetNotFoundException e) {
	            assertEquals("Asset with ID " + AssetId + " not found.", e.getMessage());
	        } catch (SQLException | ClassNotFoundException e) {
	            fail("Unexpected exception thrown: " + e.getMessage());
	        }
	    }

}
