package tuc.ece.cs102.carshop;
import java.util.Vector;

public class Customer {

	private String name;
	private String licenseNumber;
	private int years;
	private String country;
	private Vector<Renting>  customerRentings;

//Constructor
public Customer() {}	
	
public Customer(String nameAndSurname, String lic,int experienceYears, String countryOfOrigin){
	this.name=nameAndSurname;
	this.licenseNumber=lic;
	this.years=experienceYears;
	this.country=countryOfOrigin;
	this.customerRentings= new Vector<Renting>();
}

//Setters
public void setName(String name) {
	this.name = name;
}

public void setLicenseNumber(String licenseNumber) {
	this.licenseNumber = licenseNumber;
}

public void setYears(int years) {
	this.years = years;
}

public void setCountry(String country) {
	this.country = country;
}

public void addCustomerRenting (Renting r) {
	customerRentings.add(r);
}

//Getters

public String getName() {
	return name;
}

public String getLicenseNumber() {
	return licenseNumber;
}

public int getYears() {
	return years;
}

public String getCountry() {
	return country;
}

public Vector<Renting>  getRentings(){
	return customerRentings;
}

//Method used to print customers information
public void print() {
	System.out.println("Name: "+ this.name+ " License number:" + this.licenseNumber + " Years of experience:"+ this.years + " Country: "+ this.country);
}
	
}
