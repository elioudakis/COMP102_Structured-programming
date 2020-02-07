package tuc.ece.cs102.customers;

import tuc.ece.cs102.shop.EnchancedSortedList;

public abstract class Customer {

	private String name;
	private String TRN; //TRN=Tax Registration Number
	private String tel;
	private String town;
	private String country;
	
	private EnchancedSortedList customerRentings;
	
	//Constructors
	public Customer() {}
	
	public Customer(String name, String TRN, String tel, String town, String country) {
		this.name=name;
		this.TRN=TRN;
		this.tel=tel;
		this.town=town;
		this.country=country;
		
		this.customerRentings=new EnchancedSortedList();
	}


	
	//Getters and setters
	
	public String getName() {
		return name;
	}

	public EnchancedSortedList getCustomerRentings() {
		return customerRentings;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTRN() {
		return TRN;
	}

	public void setTRN(String tRN) {
		TRN = tRN;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	//Other methods
	
	public abstract void print();
	
	public abstract String toString();
	
	public abstract double costCalculator(double price, double days);
}
