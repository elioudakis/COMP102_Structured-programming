package tuc.ece.cs102.carshop;
import java.util.Date;



public class Renting {
	private int code;
	private String rentCustomerLicense;
	private String rentedCarPlate;
	private double cost;
	private String rendingStr;
	private String expiryStr;
	boolean discount;
	int discountPercentage;
	
	private Date rendingDate;
	private Date expiryDate;

	
//Constructors
public Renting () {
} 

public Renting(int cod, String lic, String plate, Date startDate ,Date endDate, double cost) {
	this.code=cod;
	this.rentCustomerLicense=lic;
	this.rentedCarPlate=plate;
	this.cost=cost;
	this.rendingDate=startDate;
	this.expiryDate=endDate;
}

//Getters

public int getCode() {
	return code;
}

public Date getRendingDate() {
	return rendingDate;
}

public Date getExpiryDate() {
	return expiryDate;
}

public String getRentCustomerLicense() {
	return rentCustomerLicense;
}

public String getRentedCarPlate() {
	return rentedCarPlate;
}

public String getRendingStr() {
	return rendingStr;
}

public String getExpiryStr() {
	return expiryStr;
}

public double getCost() {
	return cost;
}

public int getDiscountPercentage() {
	return discountPercentage;
}


//Setters

public void setCode(int code) {
	this.code = code;
}

public void setRentCustomerLicense(String rentCustomerLicense) {
	this.rentCustomerLicense = rentCustomerLicense;
}

public void setRentedCarPlate(String rentedCarPlate) {
	this.rentedCarPlate = rentedCarPlate;
}

public void setRendingStr(String rendingStr) {
	this.rendingStr = rendingStr;
}

public void setExpiryStr(String expiryStr) {
	this.expiryStr = expiryStr;
}

public void setCost(double cost) {
	this.cost = cost;
}

public boolean isDiscount() {
	return discount;
}

public void setDiscount(boolean discount) {
	this.discount = discount;
}

public void setDiscountPercentage(int discountPercentage) {
	this.discountPercentage = discountPercentage;
}

public void setRendingDate(Date rendingDate) {
	this.rendingDate = rendingDate;
}

public void setExpiryDate(Date expiryDate) {
	this.expiryDate = expiryDate;
}

//Method to get the renting period as a string
public String getRentingPeriod(){
	String result = "";
	result += " From: ";
	result += this.rendingDate.toString();
	
	result += " Until: ";
	result += this.expiryDate.toString();
	
	return result;		
}


public String toString() {
	return (" Code: " + this.code+ " Customer: "+ this.rentCustomerLicense + " Car:"+ this.rentedCarPlate + getRentingPeriod() + " Cost: "+ this.cost);
}
}


