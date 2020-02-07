package tuc.ece.cs102.carshop;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;


import tuc.ece.cs102.util.*;

public class CarRentingShop {

	private String name;
	private String TRN;
	//TRN=Tax Registration Number
	private String place;
	
	//Customers
	private Vector<Customer> listOfCustomers;
	//Cars
	private Vector<Car> listOfCars;
	//Rentings
	private Vector<Renting> listOfRentings;
	
	//*******Constructors
	public CarRentingShop() {
		listOfCustomers= new Vector<Customer>();
		listOfCars= new Vector<Car>();
		listOfRentings= new Vector<Renting>();
	}
	
	public CarRentingShop(String name, String TRN, String place) {
		this.name=name;
		this.TRN=TRN;
		this.place=place;
		listOfCustomers= new Vector<Customer>();
		listOfCars= new Vector<Car>();
		listOfRentings= new Vector<Renting>();
	}
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setTRN(String tRN) {
		TRN = tRN;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	
	//Getters
	public String getName() {
		return name;
	}

	public String getTRN() {
		return TRN;
	}

	public String getPlace() {
		return place;
	}

	public Vector<Customer> getListOfCustomers() {
		return listOfCustomers;
	}

	public Vector<Car> getListOfCars() {
		return listOfCars;
	}

	public Vector<Renting> getListOfRentings() {
		return listOfRentings;
	}
	
	//Adding objects methods
	public void addCustomer(Customer cu) {
		listOfCustomers.add(cu);
	}
	
	public void addCar (Car ca) {
		listOfCars.add(ca);
	}
	
	public void addRent(Renting re) {
		listOfRentings.add(re);
	}

	
	public void addNewRent(String customerLic, String carPlate, String startStr, String endStr,String discountYesNo, int discountPercent) {
		Date start, end;
		DatePeriod periodToRent;
		Car ca;
		Customer cu;
		double totalCost;
		ca=this.findCar(carPlate);
		cu=this.findCustomer(customerLic);

		if (ca!=null && cu!=null) {
			start=stringToDate(startStr);
			end=stringToDate(endStr);
			periodToRent=new DatePeriod (start,end);
				if(discountYesNo.equals("Yes")) {
					totalCost=ca.getCurrentRentPrice()*(periodToRent.toDays());
					totalCost=totalCost-((discountPercent*totalCost)/100);
				}
				else if (discountYesNo.equals("No")) {
					totalCost=ca.getCurrentRentPrice()*periodToRent.toDays();
				}
				else {
					System.out.println("User option ignored...");
					return;
				}
		int code=this.rentCodeGenerator();
		Renting r=new Renting(code, cu.getLicenseNumber(), ca.getVehicleRegistrationNum(), start, end, totalCost);
		
		this.addRent(r);
		ca.addCarRenting(r);
		cu.addCustomerRenting(r);		
		}
		else {
			System.out.println("Error: Undefined car or customer...");
		}

		
	}
	
	public void printListCars(){
             for (int i=0; i<this.listOfCars.size();i++){
        		this.listOfCars.get(i).println();
        	}
        }
	 
	//Method to find customer
	public Customer findCustomer(String licNr) {
		for(int i=0; i<this.listOfCustomers.size(); i++) {
			Customer cu=this.listOfCustomers.get(i);
			if (cu.getLicenseNumber().equals(licNr)) {
				return cu;
			}
		}
		return null;
	}

	//Method to find car
	public Car findCar(String cplate) {
		for(int i=0; i<this.listOfCars.size(); i++) {
			Car ca=this.listOfCars.get(i);
			if (ca.getVehicleRegistrationNum().equals(cplate)) {
				return ca;
			}
		}
		return null;
	}
	
	//Method to automatically produce the renting code
	public int rentCodeGenerator() {
		int currentNum,code;
		currentNum=this.listOfRentings.size();
		code=100+currentNum;
		return code;
	}
	

	//Search and print rents by car
	public void printRentsByCar() {
		StandardInputRead reader = new StandardInputRead();
		String plate=reader.readString("Give the car's plate:");
		Car ca=this.findCar(plate);
		Renting r =new Renting();
		if(ca!=null) {
			for(int i=0; i<ca.getRentings().size(); i++) {
				r=ca.getRentings().get(i);
				System.out.println(r);
			}
		}
		else {
			System.out.println("Error, the car could not be found.");
		}
	}
	
	//Search and print rents by customer	
	public void printRentsByCustomer() {
		StandardInputRead reader = new StandardInputRead();
		String licNr=reader.readString("Give the customer's license number:");
		Customer cu=this.findCustomer(licNr);                                                                                                                       
		Renting r =new Renting();
		if(cu!=null) {
			for(int i=0; i<cu.getRentings().size(); i++) {
				r=cu.getRentings().get(i);
				System.out.println(r);
			}
		}
		else {
			System.out.println("Error, the customer could not be found.");
		}
	}
	//Search and print rents by time period
	public void printRentsByTimePeriod() {
		StandardInputRead reader = new StandardInputRead();
		Date from, to;
		boolean found=false;
		DatePeriod periodToFind, periodRented;
		from=reader.readDate("Give the starting date of the date period, in format dd/mm/yyyy...");
		to=reader.readDate("Give the ending date of the date period, in format dd/mm/yyyy...");
		periodToFind=new DatePeriod(from, to);
		Renting r=new Renting();
		for(int i=0; i<listOfRentings.size(); i++) {
			r=listOfRentings.get(i);
			periodRented=new DatePeriod(r.getRendingDate(), r.getExpiryDate());
			if (periodToFind.overlaps(periodRented)==true) {
				System.out.println(r);
				found=true;
			}			
		}
		if (found==false) { //if no rent found for the given period
			System.out.println("No rentings found for the given date period...");
		}
	}

//Method to convert a string to date
public Date stringToDate(String s)  {
	Date d=null;
	DateFormat format;
	format = new SimpleDateFormat("dd/MM/yyyy");
	try {
		d = format.parse(s);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return d;
}
	
	
	
}
	

