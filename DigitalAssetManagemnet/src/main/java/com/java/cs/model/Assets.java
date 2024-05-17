package com.java.cs.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Assets {

	private int asset_id ;
	private String name ;
	private String type ;
	private int serial_number;
	private Date purchase_date;
	private String location;
	private String status;
	private int owner_id;
	public int getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(int serial_number) {
		this.serial_number = serial_number;
	}
	public Date getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Date purchaseDate) {
		this.purchase_date = purchaseDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	
	@Override
	public String toString() {
		return "Assets [asset_id=" + asset_id + ", name=" + name + ", type=" + type + ", serial_number=" + serial_number
				+ ", purchase_date=" + purchase_date + ", location=" + location + ", status=" + status + ", owner_id="
				+ owner_id + "]";
	}
	
	public Assets() {
		
		// TODO Auto-generated constructor stub
	}
	
	public Assets(int asset_id, String name, String type, int serial_number, Date purchase_date, String location,
			String status, int owner_id) {
		super();
		this.asset_id = asset_id;
		this.name = name;
		this.type = type;
		this.serial_number = serial_number;
		this.purchase_date = purchase_date;
		this.location = location;
		this.status = status;
		this.owner_id = owner_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(asset_id, location, name, owner_id, purchase_date, serial_number, status, type);
	}
	@Override
	public boolean equals(Object obj) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Assets asset = (Assets) obj;
		if(asset.getAsset_id()==asset_id
				&& asset.getName()==name
				&& asset.getType()==type 
				&& asset.getSerial_number()==serial_number
				&&asset.getPurchase_date().compareTo(purchase_date)==0
				&&asset.getLocation()==location
				&& asset.getStatus()==status
				&& asset.getOwner_id()==owner_id) {
			return true;
		}
		return false;
	}
	
	
	
	
	
}
