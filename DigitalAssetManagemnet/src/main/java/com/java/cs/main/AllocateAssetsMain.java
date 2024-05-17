package com.java.cs.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.java.cs.dao.AssetManagementService;
import com.java.cs.dao.AssetManagementServiceImpl;
import com.java.cs.model.Assets;
import com.java.cs.myexceptions.AssetNotFoundException;
import com.java.cs.myexceptions.AssetNotMaintainException;


public class AllocateAssetsMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AssetManagementService assetService = new AssetManagementServiceImpl();

        System.out.println("Enter asset ID to allocate:");
        int assetId = scanner.nextInt();

        try {
            Assets assetsFound = assetService.searchAsset(assetId);
            if (assetsFound != null) {
                
                if (!assetService.checkAssetMaintenance(assetId)) {
                    throw new AssetNotMaintainException("Asset with ID " + assetId + " requires maintenance but has not been maintained for two years.");
                }
                System.out.println("Enter employee ID to allocate:");
                int employeeId = scanner.nextInt();
                System.out.println("Enter allocation date (yyyy-mm-dd):");
                String allocationDate = scanner.next();
                boolean allocated = assetService.allocateAsset(assetId, employeeId, allocationDate);
                if (allocated) {
                    System.out.println("Asset allocated successfully.");
                } else {
                    System.out.println("Failed to allocate asset.");
                }
            } else {
                throw new AssetNotFoundException("Asset with ID " + assetId + " not found.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found.");
        } catch (SQLException e) {
            System.out.println("Error executing SQL query.");
        } catch (AssetNotFoundException e) {
            System.out.println("Asset not found. " + e.getMessage());
        } catch (AssetNotMaintainException e) {
            System.out.println("Asset not maintained. " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}