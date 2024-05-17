package com.java.cs.model;

import java.sql.Date;
import java.util.Objects;

public class MaintenanceRecords {

	private int maintenance_id; 
	private int asset_id ;
	private Date maintenance_date ;
	private String description ;
	private double cost;
	public int getMaintenance_id() {
		return maintenance_id;
	}
	public void setMaintenance_id(int maintenance_id) {
		this.maintenance_id = maintenance_id;
	}
	public int getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}
	public Date getMaintenance_date() {
		return maintenance_date;
	}
	public void setMaintenance_date(Date maintenance_date) {
		this.maintenance_date = maintenance_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "MaintenanceRecords [maintenance_id=" + maintenance_id + ", asset_id=" + asset_id + ", maintenance_date="
				+ maintenance_date + ", description=" + description + ", cost=" + cost + "]";
	}
	public MaintenanceRecords() {
		
		// TODO Auto-generated constructor stub
	}
	public MaintenanceRecords(int maintenance_id, int asset_id, Date maintenance_date, String description,
			double cost) {
		super();
		this.maintenance_id = maintenance_id;
		this.asset_id = asset_id;
		this.maintenance_date = maintenance_date;
		this.description = description;
		this.cost = cost;
	}
	@Override
	public int hashCode() {
		return Objects.hash(asset_id, cost, description, maintenance_date, maintenance_id);
	}
	@Override
	public boolean equals(Object obj) {
	
		MaintenanceRecords mr = (MaintenanceRecords) obj;
		if(mr.getMaintenance_id()==maintenance_id
				&&mr.getAsset_id()==asset_id
				&& mr.getMaintenance_date().compareTo(maintenance_date)==0
				&& mr.getDescription()==description
				&&mr.getCost()==cost) {
			return true;
		}
		return false;
	}
	
	
	
}
