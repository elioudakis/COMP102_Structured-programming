package tuc.ece.cs102.carshop;
import java.util.Vector;

import tuc.ece.cs102.util.StandardInputRead;

public class Car {
	private String VehicleRegistrationNum;
	private String firmModel;
	private String releaseYear;
	private double fuelConsumption;
	private float kms;
	private int currentRentPrice;
	private Characteristics[] characteristic;
	private Vector<Renting>  rentings;


//Constructor 3
public Car(String VRM, String firm, String relYear, double fuel, float kilometers, int RentingPrice,Characteristics c1, Characteristics c2, Characteristics c3){
	this.VehicleRegistrationNum = VRM;
	this.firmModel=firm;
	this.releaseYear=relYear;
	this.fuelConsumption=fuel;
	this.kms=kilometers;
	this.currentRentPrice=RentingPrice;
	this.characteristic = new Characteristics[3];
	
	this.characteristic[0]=c1;
	this.characteristic[1]=c2;
	this.characteristic[2]=c3;
	
	this.rentings= new Vector<Renting>();
}

//Constructor 2
public Car(String VRM, String firm, String relYear, double fuel, float kilometers, int RentingPrice,Characteristics c1, Characteristics c2){
	this.VehicleRegistrationNum = VRM;
	this.firmModel=firm;
	this.releaseYear=relYear;
	this.fuelConsumption=fuel;
	this.kms=kilometers;
	this.currentRentPrice=RentingPrice;
	this.characteristic = new Characteristics[2];
	
	this.characteristic[0]=c1;
	this.characteristic[1]=c2;

	
	this.rentings= new Vector<Renting>();
}

//Constructor 1
public Car(String VRM, String firm, String relYear, double fuel, float kilometers, int RentingPrice,Characteristics c1){
	this.VehicleRegistrationNum = VRM;
	this.firmModel=firm;
	this.releaseYear=relYear;
	this.fuelConsumption=fuel;
	this.kms=kilometers;
	this.currentRentPrice=RentingPrice;
	this.characteristic = new Characteristics[1];
	
	this.characteristic[0]=c1;

	
	this.rentings= new Vector<Renting>();
}

//Constructor 0
public Car(String VRM, String firm, String relYear, double fuel, float kilometers, int RentingPrice){
	this.VehicleRegistrationNum = VRM;
	this.firmModel=firm;
	this.releaseYear=relYear;
	this.fuelConsumption=fuel;
	this.kms=kilometers;
	this.currentRentPrice=RentingPrice;
	
	this.rentings= new Vector<Renting>();
}

public Car() {
}

//Setters


public void setVehicleRegistrationNum(String vehicleRegistrationNum) {
	VehicleRegistrationNum = vehicleRegistrationNum;
}

public void setFirmModel(String firmModel) {
	this.firmModel = firmModel;
}

public void setReleaseYear(String releaseYear) {
	this.releaseYear = releaseYear;
}

public void setFuelConsumption(float fuelConsumption) {
	this.fuelConsumption = fuelConsumption;
}

public void setKms(float kms) {
	this.kms = kms;
}

public void setCurrentRentPrice(int currentRentPrice) {
	this.currentRentPrice = currentRentPrice;
}

public void addCarRenting(Renting r) {
	rentings.add(r);
}

public void setCharacteristics(Characteristics[] characteristic) {
	this.characteristic=characteristic;
}
//Getters

public String getVehicleRegistrationNum() {
	return VehicleRegistrationNum;
}

public String getFirmModel() {
	return firmModel;
}

public String getReleaseYear() {
	return releaseYear;
}

public double getFuelConsumption() {
	return fuelConsumption;
}

public float getKms() {
	return kms;
}

public int getCurrentRentPrice() {
	return currentRentPrice;
}

public Characteristics[] getCharacteristics() {
	return characteristic;
}

//Method used to print Car information
public void println() {
	System.out.println(" Vehicle number: "+  this.VehicleRegistrationNum  + "  Model: "+ this.firmModel );

}

public void setFuelConsumption(double fuelConsumption) {
	this.fuelConsumption = fuelConsumption;
}

//Method used in console to print the characteristics included in the enumeration
public static void printCharacteristicList() {
	System.out.println("Select one of the following characteristics:");
	System.out.println("1.Air condition");
	System.out.println("2.Diesel");
	System.out.println("3.Hybrid");
	System.out.println("4.Leather seats");
	System.out.println("5.Automatic");
	System.out.println("6.Four wheel drive (4x4)");
	System.out.println("7.Seven seats");
	System.out.println("8.Cabriolet");
}


//Method used in console to select characteristics from the enumeration
public static Characteristics selectCharacteristics() {
	int charactSelection;
	StandardInputRead reader = new StandardInputRead();
	charactSelection=reader.readPositiveInt("");
	switch (charactSelection) {//break is not needed, because of return's existence
	case 1:
		return Characteristics.AIR_CONDITION;
	case 2:
		return Characteristics.DIESEL;
	case 3:
		return Characteristics.HYBRID;
	case 4:
		return Characteristics.LEATHER_SEATS;
	case 5:
		return Characteristics.AUTOMATIC;
	case 6:
		return Characteristics.FOUR_WHEEL_DRIVE;
	case 7:
		return Characteristics.SEVEN_SEATS;
	case 8:
		return Characteristics.CABRIOLET;
	default:
		System.out.println("User selection "+ charactSelection + " ignored...");
	
	}
	return null;
	
	
}

public Vector<Renting> getRentings() {
	return rentings;
}


}