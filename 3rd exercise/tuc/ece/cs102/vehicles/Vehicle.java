package tuc.ece.cs102.vehicles;

import tuc.ece.cs102.shop.EnchancedSortedList;

public abstract class Vehicle {
	private String VRN; //VRN=Vehicle Registration Number
	private String FirmModel;
	private int YearReleased;
	private double Kms;
	private float PricePerDay;
	
	private EnchancedSortedList vehicleRentings;
	
	//Constructors
	public Vehicle() {}
	
	public Vehicle(String VRN, String FirmModel, int YearReleased, double Kms, float PricePerDay) {
		this.VRN=VRN;
		this.FirmModel=FirmModel;
		this.YearReleased=YearReleased;
		this.Kms=Kms;
		this.PricePerDay=PricePerDay;
		
		this.vehicleRentings=new EnchancedSortedList();
	}


	
	//Getters and setters
	
	public String getVRN() {
		return VRN;
	}

	public EnchancedSortedList getVehicleRentings() {
		return vehicleRentings;
	}

	public void setVRM(String vRN) {
		VRN = vRN;
	}

	public String getFirmModel() {
		return FirmModel;
	}

	public void setFirmModel(String firmModel) {
		FirmModel = firmModel;
	}

	public int getYearReleased() {
		return YearReleased;
	}

	public void setYearReleased(int yearReleased) {
		YearReleased = yearReleased;
	}

	public double getKms() {
		return Kms;
	}

	public void setKms(double kms) {
		Kms = kms;
	}

	public float getPricePerDay() {
		return PricePerDay;
	}

	public void setPricePerDay(float pricePerDay) {
		PricePerDay = pricePerDay;
	}
	
	//Other methods
	
	public abstract void print();
	
	public abstract String toString();
	

}
