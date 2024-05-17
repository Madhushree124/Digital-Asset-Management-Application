package com.java.cs.model;

import java.sql.Date;
import java.util.Objects;

public class AssetAllocations {

	private int allocation_id; 
	private int asset_id;
	private int employee_id ;
	private Date allocation_date ;
	private Date return_date ;
	public int getAllocation_id() {
		return allocation_id;
	}
	public void setAllocation_id(int allocation_id) {
		this.allocation_id = allocation_id;
	}
	public int getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public Date getAllocation_date() {
		return allocation_date;
	}
	public void setAllocation_date(Date allocation_date) {
		this.allocation_date = allocation_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	@Override
	public String toString() {
		return "AssetAllocations [allocation_id=" + allocation_id + ", asset_id=" + asset_id + ", employee_id="
				+ employee_id + ", allocation_date=" + allocation_date + ", return_date=" + return_date + "]";
	}
	public AssetAllocations() {
		
		// TODO Auto-generated constructor stub
	}
	public AssetAllocations(int allocation_id, int asset_id, int employee_id, Date allocation_date, Date return_date) {
		super();
		this.allocation_id = allocation_id;
		this.asset_id = asset_id;
		this.employee_id = employee_id;
		this.allocation_date = allocation_date;
		this.return_date = return_date;
	}
	@Override
	public int hashCode() {
		return Objects.hash(allocation_date, allocation_id, asset_id, employee_id, return_date);
	}
	@Override
	public boolean equals(Object obj) {
		
		AssetAllocations asset = (AssetAllocations) obj;
		if(asset.getAllocation_id()==allocation_id
				&& asset.getAsset_id()==asset_id
				&& asset.getEmployee_id()==employee_id
				&& asset.getAllocation_date().compareTo(allocation_date)==0
				&&asset.getReturn_date().compareTo(return_date)==0) {
			return true;
		}
		return false;
	}
	
	
}
