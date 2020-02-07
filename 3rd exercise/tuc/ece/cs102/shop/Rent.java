package tuc.ece.cs102.shop;

import java.util.Date;

import tuc.ece.cs102.customers.Customer;
import tuc.ece.cs102.vehicles.Vehicle;

public class Rent {
	private int code;
	private Customer renter;
	private Vehicle vehicleToRent;
	private Date startingDate;
	private Date endingDate;
	private double totalCost;
	
	//Constructors
	public Rent() {}
	
	public Rent(int code, Customer renter, Vehicle vehicleToRent, Date startingDate, Date endingDate, double totalCost) {
		this.code=code;
		this.renter=renter;
		this.vehicleToRent=vehicleToRent;
		this.startingDate=startingDate;
		this.endingDate=endingDate;
		this.totalCost=totalCost;
	}


	
	//Getters and setters
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Customer getRenter() {
		return renter;
	}

	public void setRenter(Customer renter) {
		this.renter = renter;
	}

	public Vehicle getVehicleToRent() {
		return vehicleToRent;
	}

	public void setVehicleToRent(Vehicle vehicleToRent) {
		this.vehicleToRent = vehicleToRent;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	
	//Method to get the renting period as a string
	public String getRentingPeriod(){
		String result = "";
		result += " From: ";
		result += this.startingDate.toString();
		
		result += " Until: ";
		result += this.endingDate.toString();
		
		return result;		
	}
	
	public String toString() {
		return (" Code: " + this.code+ "**** Customer: "+ this.getRenter().toString() + "**** Car:"+ this.getVehicleToRent().toString() + getRentingPeriod() + "**** Cost: "+ this.totalCost);
	}

	public void print() {
		System.out.println("Rent: "+ this.toString());
		
	}
}
