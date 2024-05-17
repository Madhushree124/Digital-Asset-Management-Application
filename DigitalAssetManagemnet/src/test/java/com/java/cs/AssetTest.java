package com.java.cs;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.java.cs.model.Assets;

public class AssetTest {
	@Test 
	public void testEquals() {
		Date purchaseDate = Date.valueOf("2024-03-03");
        Assets asset1 = new Assets(1, "Table", "Furniture", 123455, purchaseDate, "Office B", "In use", 3);
        Assets asset2 = new Assets(1, "Table", "Furniture", 123455, purchaseDate, "Office B", "In use", 3);
        Assets asset3 = new Assets(1, "Table", "Furniture", 1235, purchaseDate, "Office B", "In use", 3);

        assertTrue(asset1.equals(asset2));
        assertFalse(asset1.equals(asset3));
	}
	@Test
	public void testHashCode() {
		Date purchaseDate = Date.valueOf("2024-03-03");
        Assets asset1 = new Assets(1, "Table", "Furniture", 123455, purchaseDate, "Office B", "In use", 3);
        Assets asset2 = new Assets(1, "Table", "Furniture", 123455, purchaseDate, "Office B", "In use", 3);
        assertEquals(asset1.hashCode(),asset2.hashCode());
	
	
	}
	
	
	@Test
	public void testToString() {
		Date purchaseDate = Date.valueOf("2024-03-03");
        Assets asset1 = new Assets(1, "Table", "Furniture", 123455, purchaseDate, "Office B", "In use", 3);
        	   
        String result="Assets [asset_id=1, name=Table, type=Furniture, serial_number=123455,"
        		+ " purchase_date=2024-03-03, location=Office B, status=In use, owner_id=3]";
        assertEquals(result,asset1.toString() );

	}
	@Test
	public void testGettersAndSetters(){
		Assets asset=new Assets();
		Date purchaseDate = Date.valueOf("2024-03-03");

		asset.setAsset_id(2);
		asset.setName("Table");
		asset.setType("Furniture");
		asset.setSerial_number(123456);
		asset.setPurchase_date(purchaseDate);
		asset.setLocation("Office B");
		asset.setStatus("In use");
		asset.setOwner_id(3);
		
		assertEquals(2, asset.getAsset_id());
		assertEquals("Table",asset.getName());
        assertEquals("Furniture",asset.getType());
        assertEquals(123456,asset.getSerial_number());
        assertEquals(purchaseDate,asset.getPurchase_date());
        assertEquals("Office B", asset.getLocation());
        assertEquals("In use", asset.getStatus());
        assertEquals(3, asset.getOwner_id());
	}

	@Test
	public void testConstructors() {
		Assets asset=new Assets();
		assertNotNull(asset);
		Date purchaseDate = Date.valueOf("2024-03-03");
        Assets asset1 = new Assets(1, "Table", "Furniture", 123455, purchaseDate, "Office B", "In use", 3);
        assertNotNull(asset1);
        assertEquals(1,asset1.getAsset_id());
        assertEquals("Table",asset1.getName());
        assertEquals("Furniture",asset1.getType());
        assertEquals(123455,asset1.getSerial_number());
        assertEquals(purchaseDate,asset1.getPurchase_date());
        assertEquals("Office B", asset1.getLocation());
        assertEquals("In use", asset1.getStatus());
        assertEquals(3, asset1.getOwner_id());
		
		
        
	}

}
