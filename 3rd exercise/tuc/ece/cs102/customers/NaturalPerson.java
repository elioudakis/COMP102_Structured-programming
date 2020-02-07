package tuc.ece.cs102.customers;

public class NaturalPerson extends Customer{
	
	//Constructors
	public NaturalPerson() {}
	
	public NaturalPerson(String name, String TRN, String tel, String town, String country) {
		super(name, TRN, tel, town, country);
	}
	
	//Other methods
	@Override
	public void print() {
		System.out.println("Customer->Natural Person: "+ this.toString());
		
	}

	@Override
	public String toString() {
		return " Name: "+this.getName()+" TRN: "+this.getTRN()+" Tel: "+this.getTel()+" Town living: "+this.getTown()+ " Country: "+ this.getCountry();
	}

	@Override
	public double costCalculator(double price, double days) {
		return price*days;
	}

}
