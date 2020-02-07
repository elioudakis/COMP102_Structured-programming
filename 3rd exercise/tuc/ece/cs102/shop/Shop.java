package tuc.ece.cs102.shop;

import java.util.Date;


import tuc.ece.cs102.customers.Customer;
import tuc.ece.cs102.customers.LegalPerson;
import tuc.ece.cs102.customers.NaturalPerson;
import tuc.ece.cs102.list.Node;
import tuc.ece.cs102.util.*;
import tuc.ece.cs102.vehicles.Bike;
import tuc.ece.cs102.vehicles.Bike_Type.BikeType;
import tuc.ece.cs102.vehicles.Car;
import tuc.ece.cs102.vehicles.Car_EnergySource;
import tuc.ece.cs102.vehicles.Car_EnergySource.carEnergy;
import tuc.ece.cs102.vehicles.Car_Type;
import tuc.ece.cs102.vehicles.Truck;
import tuc.ece.cs102.vehicles.Vehicle;



public class Shop {
	
	private static final int STARTING_CODE = 100;
	private String name;
	private String TRN;
	//TRN=Tax Registration Number
	private String place;
	
	//Vehicles
	private EnchancedSortedList vehiclesList;
	//Customers
	private EnchancedSortedList customersList;
	//Rents
	private EnchancedSortedList rentsList;
	
	//Constructors
	public Shop() {
		vehiclesList=new EnchancedSortedList();
		customersList=new EnchancedSortedList();
		rentsList=new EnchancedSortedList();
	}
	
	public Shop(String name, String TRN, String place) {
		this.name=name;
		this.TRN=TRN;
		this.place=place;
		vehiclesList=new EnchancedSortedList();
		customersList=new EnchancedSortedList();
		rentsList=new EnchancedSortedList();		
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

	public EnchancedSortedList getVehiclesList() {
		return vehiclesList;
	}

	public EnchancedSortedList getCustomersList() {
		return customersList;
	}

	public EnchancedSortedList getRentsList() {
		return rentsList;
	}
	
	//Methods to add new items in the three lists
	public void addVehicle(Vehicle v) {
		vehiclesList.insert(new VehicleItem(v));
	}
	
	public void addCustomer(Customer c) {
		customersList.insert(new CustomerItem(c));
	}
	
	public void addRent(Rent r) {
		rentsList.insert(new RentItem(r));
	}
	
	//Method to make a new Rent and register it in the lists
	public void addNewRent(String TRN, String VRN, Date startingDate, Date endingDate) {
		DatePeriod periodToRent;
		double totalCost;
		
		Vehicle v=this.findVehicle(VRN);
		Customer c=this.findCustomer(TRN);
		if (v==null || c==null) {
			System.out.println("Error. Undefined vehicle or customer...");
			return;
		}
	
		try {
			if(((Class.forName("tuc.ece.cs102.customers.NaturalPerson").isInstance(c))==true) && ((Class.forName("tuc.ece.cs102.vehicles.Car").isInstance(v))==true) && ((Car) v).getType()==Car_Type.CarType.PUBLIC_USAGE) {
				System.out.println("A natural person cannot rent a public usage car!");
				return;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("System message: error! ");
			//e.printStackTrace();
		}
		
		
		periodToRent=new DatePeriod(startingDate, endingDate);
		if(isVehicleFree(v, periodToRent)) {
		totalCost=c.costCalculator(v.getPricePerDay(), periodToRent.toDays());
		
		 
		int code=this.rentCodeGenerator();
		Rent r=new Rent(code, c,v,startingDate, endingDate, totalCost);
		this.addRent(r);
		c.getCustomerRentings().insert(new RentItem(r));
		v.getVehicleRentings().insert(new RentItem(r));
		}
		
	}
	
	//Method to find if the car is free to be rented
	public boolean isVehicleFree(Vehicle v, DatePeriod periodToRent) {
		Node tmp=v.getVehicleRentings().getFirst();
		if(tmp==null) {
			return true; //there are no rents, so it is available for renting
		}
		RentItem r=new RentItem();
		Rent rent=new Rent();
		DatePeriod dpAlreadyRented;
		while(tmp!=null) {
			r=(RentItem)tmp.getValue();
			rent=(Rent)r.getData();
		
			dpAlreadyRented=new DatePeriod(rent.getStartingDate(), rent.getEndingDate());
			if (periodToRent.overlaps(dpAlreadyRented)) {
				System.out.println("The vehicle is already rented for this date period!...");
				return false;
			
			}tmp=tmp.getNext();
		}
		return true;//if there are rents, but no overlaps
	}
	
	//Method to automatically produce the renting code
	public int rentCodeGenerator() {
		int currentNum, code;
		currentNum=this.getRentsList().getLength();
		code=STARTING_CODE+currentNum;
		return code;
	}
	
	//////////////////////////////////////////////Methods for the vehicles/////////////////////////////////////////////////////////////////////
	//Method to find a vehicle by VRN
	public Vehicle findVehicle (String VRN) {
		VehicleItem v=(VehicleItem) vehiclesList.searchAnItem(VRN);
		if(v!=null) {
			return (Vehicle) v.getData();
		}
		else{
			System.out.println("Error, the vehicle could not be found. ");
			return null;
		}	
	}
	
	//Method to print a vehicle by VRN
	public void printVehicle(String VRN) {
		Vehicle v=this.findVehicle(VRN);
		if(v!=null) 
			v.print();
	}
	
	//Method to delete a vehicle
	public void delVehicle(String VRN) {
		Vehicle v=this.findVehicle(VRN);
		if(v==null) {
			System.out.println("Error..");
			return;
		}
		VehicleItem vi=new VehicleItem(v);
		this.vehiclesList.delete(vi);
		
	}
	
	//Method to add a new vehicle
	public void newVehicle(){
		StandardInputRead reader=new StandardInputRead();
		
		String VRN=reader.readString("Give the vehicle's registration number(VRN): ");
		String firmModel=reader.readString("Give the vehicle's firm and model: ");
		int yearReleased=reader.readPositiveInt("Give its release year: ");
		double kms=reader.readPositiveFloat("Give its kilometers: ");
		float pricePerDay=reader.readPositiveFloat("Give its renting price per day: ");
		Vehicle v=null;
		int selection=reader.readPositiveInt("Enter 1 for registering a passenger vehicle, or 2 for a truck...");
		switch(selection) {
		case 1://Passenger
			int numOfPeople=reader.readPositiveInt("Give the maximun number of passengers...");
			int cc=reader.readPositiveInt("Give the engine cc: ");
			int i=reader.readPositiveInt("Enter 1 for registering a car, or 2 for a bike...");
			switch(i) {
				case 1://Car
					int numDoors=reader.readPositiveInt("Number of doors: ");
					Car_EnergySource.carEnergy energy = null;
					Car.printCarEnergyList();
					int j=reader.readPositiveInt("");
					switch(j) {
						case 1:
							energy=carEnergy.DIESEL;
							break;
						case 2:
							energy=carEnergy.GAS;
							break;
						case 3:
							energy=carEnergy.BATTERY;
							break;
						default: 
					        System.out.println("User option " +j+ " ignored...");	
					}
					System.out.println("Cars able to have more than 7 passengers, are marked as public usage vehicles, otherwise they remain private usage ones.");
		
			v=(Vehicle)(new Car(VRN, firmModel, yearReleased, kms, pricePerDay, numOfPeople, cc,numDoors, energy));
				break;
			
						
				case 2://Bike
					if(numOfPeople>3) {
						System.out.println("A bike cannot have more than 3 passengers. Registering aborted. Try again...");
						return;
						//break;
					}
					else {
						BikeType type = null;
						Bike.printBikeTypeList();
						int k=reader.readPositiveInt("");
						switch(k) {
						case 1:
							type=BikeType.TOURING;
							break;
						case 2:
							type=BikeType.CRUISER;
							break;
						case 3:
							type=BikeType.SPORT;
							break;
						case 4:
							type=BikeType.ON_OFF;
							break;
						}
					v=(Vehicle)(new Bike(VRN, firmModel, yearReleased, kms, pricePerDay, numOfPeople, cc, type));	
						
					}
			}break;
		case 2://Truck
			int payload=reader.readPositiveInt("Maximum permitted payload: ");
			float width=reader.readPositiveFloat("Width: ");
			float height=reader.readPositiveFloat("Height: ");
			v=(Vehicle)(new Truck(VRN, firmModel, yearReleased, kms, pricePerDay, payload, width, height));
			break;
		}
	this.addVehicle(v);
	}
	
	//Print all the vehicles
	public void printAllVehicles() {
		this.getVehiclesList().print();
	}
	
	//Print vehicles of a user-specified category
	public void printVehiclesByCategory(String category) {
		this.vehiclesList.printAllInHierarchy(category);
	}
	
//////////////////////////////////////////////Methods for the customers/////////////////////////////////////////////////////////////////////
	//Method to find a customer by TRN
	public Customer findCustomer (String TRN) {
		CustomerItem c=(CustomerItem) customersList.searchAnItem(TRN);
		if(c!=null) {
			return (Customer) c.getData();
		}
		else {
			System.out.println("Error, the customer could not be found. ");
			return null;
		}
	}
	
	//Method to print a customer by TRN
	public void printCustomer(String TRN) {
		Customer c=this.findCustomer(TRN);
		if(c!=null)
			c.print();
	}
	
	//Method to delete a customer
	public void delCustomer(String TRN) {
		Customer c=this.findCustomer(TRN);
		CustomerItem ci=new CustomerItem(c);
		this.customersList.delete(ci);
	}
	
	//Method to add a new customer
	public void newCustomer() {
		StandardInputRead reader= new StandardInputRead();
	
		String name=reader.readString("Name:");
		String TRN=reader.readString("Tax Registration Number: ");
		String tel=reader.readString("Telephone: ");
		String town=reader.readString("Town living: ");
		String country=reader.readString("Country: ");
		Customer c=null;
		int selection=reader.readPositiveInt("Enter 1 for registering a natural person, or 2 for registering a legal person...");
		switch(selection) {
		case 1:
			c=(Customer)(new NaturalPerson(name, TRN, tel, town, country));
			break;
		case 2:
			int discountPercentage=reader.readPositiveInt("Give the discount percentage...");
			c=(Customer)(new LegalPerson(name, TRN, tel, town, country, discountPercentage));
			break;
		default: 
	        System.out.println("User option " + selection + " ignored...");
		}
		this.addCustomer(c);
	}
	
//////////////////////////////////////////////Methods for the rents/////////////////////////////////////////////////////////////////////	
	//Search and print rents by vehicle
	public void printRentsByVehicle() {
		StandardInputRead reader = new StandardInputRead();
		String VRN=reader.readString("Give the vehicle's registration number (VRN):");
		Vehicle v=this.findVehicle(VRN);
		if(v!=null) {
			v.getVehicleRentings().print();
			}
	}
	
	//Search and print rents by customer
	public void printRentsByCustomer() {
		StandardInputRead reader = new StandardInputRead();
		String TRN=reader.readString("Give the customer's tax registration number (TRN):");
		Customer c=this.findCustomer(TRN);
		if(c!=null) {
			c.getCustomerRentings().print();
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
		
		RentItem r=new RentItem();
		Rent rent=new Rent();
		Node tmp=this.getRentsList().getFirst();
		if(tmp==null) {
			System.out.println("The shop has no rents registered!");
		}
		while(tmp!=null) {	
			r=(RentItem) tmp.getValue();
			rent=(Rent)r.getData();			
			//now we have the rent and we can read what we want from it
			periodRented=new DatePeriod(rent.getStartingDate(), rent.getEndingDate());
			if(periodToFind.overlaps(periodRented)==true) {
				System.out.println(rent);
				found=true;
			}
			tmp=tmp.getNext();
		}
		if (found==false) { //if no rent found for the given period
			System.out.println("No rentings found for the given date period...");
		}

	}
}
	
	

