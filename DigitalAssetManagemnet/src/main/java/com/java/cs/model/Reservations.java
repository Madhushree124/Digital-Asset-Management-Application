package com.java.cs.model;

import java.util.Date;
import java.util.Objects;

public class Reservations {

	private int reservation_id ; 
	private int asset_id ;
	private int employee_id;
	private Date reservation_date ;
	private Date start_date ;
	private Date end_date ;
	private String status;
	public int getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
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
	public Date getReservation_date() {
		return reservation_date;
	}
	public void setReservation_date(Date reservation_date) {
		this.reservation_date = reservation_date;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Reservations [reservation_id=" + reservation_id + ", asset_id=" + asset_id + ", employee_id="
				+ employee_id + ", reservation_date=" + reservation_date + ", start_date=" + start_date + ", end_date="
				+ end_date + ", status=" + status + "]";
	}
	
	public Reservations() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reservations(int reservation_id, int asset_id, int employee_id, Date reservation_date, Date start_date,
			Date end_date, String status) {
		super();
		this.reservation_id = reservation_id;
		this.asset_id = asset_id;
		this.employee_id = employee_id;
		this.reservation_date = reservation_date;
		this.start_date = start_date;
		this.end_date = end_date;
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(asset_id, employee_id, end_date, reservation_date, reservation_id, start_date, status);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Reservations reserve = (Reservations) obj;
		if(reserve.getReservation_id()==reservation_id
				&& reserve.getAsset_id()==asset_id
				&& reserve.getEmployee_id()==employee_id
				&& reserve.getReservation_date().compareTo(reservation_date)==0
				&& reserve.getStart_date().compareTo(start_date)==0
				&& reserve.getEnd_date().compareTo(end_date)==0
				&& reserve.getStatus()==status) {
			return true;
			
			
		}
		return false;
	}
	
	
}
