package tuc.ece.cs102.customers;

public class LegalPerson extends Customer{
	private int discountPercentage;
	
	//Constructors
	public LegalPerson() {}
	
	public LegalPerson(String name, String TRN, String tel, String town, String country, int discountPercentage) {
		super(name, TRN, tel, town, country);
		this.discountPercentage=discountPercentage;
	}


	//Getters and setters
	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}



	//Other methods
	
	@Override
	public void print() {
		System.out.println("Customer->Legal Person: "+ this.toString());
		
	}

	@Override
	public String toString() {
		return " Name: "+this.getName()+" TRN: "+this.getTRN()+" Tel: "+this.getTel()+" Town living: "+this.getTown()+ " Country: "+ this.getCountry()+ " Discount Percentage: "+this.getDiscountPercentage();
	}

	@Override
	public double costCalculator(double price, double days) {
		return (price*days)-(0.01*this.discountPercentage*price*days);
	}

}

