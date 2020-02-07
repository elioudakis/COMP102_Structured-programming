package tuc.ece.cs102.shop;

import java.util.Date;

import tuc.ece.cs102.customers.Customer;
import tuc.ece.cs102.customers.LegalPerson;
import tuc.ece.cs102.customers.NaturalPerson;
import tuc.ece.cs102.util.*;
import tuc.ece.cs102.vehicles.Bike;
import tuc.ece.cs102.vehicles.Car;
import tuc.ece.cs102.vehicles.Car_EnergySource.carEnergy;
import tuc.ece.cs102.vehicles.Bike_Type.BikeType;
import tuc.ece.cs102.vehicles.Truck;
import tuc.ece.cs102.vehicles.Vehicle;


public class Console {

	@SuppressWarnings("deprecation")//because of the dates below
	public static void main(String[] args)  {
		//Creating a new shop
		Shop shop=new Shop("Rent a vehicle Ltd", "111222333" ,"Chania Port" );
		
		//Filling the lists with a few given data
		
		//Instantiating a few vehicles
		shop.addVehicle((Vehicle)new Car("XNK5544", "Mercedes C200", 2012, 120000, 50, 5, 1800, 4, carEnergy.BATTERY));
		shop.addVehicle((Vehicle)new Car("XNA1204", "Honda Pilot", 2019, 5000, 70, 7, 3000, 5, carEnergy.DIESEL));
		shop.addVehicle((Vehicle)new Car("XNM1345", "Mercedes MiniBXS", 2018, 6000, 100, 12, 3000,4, carEnergy.DIESEL));
		shop.addVehicle((Vehicle)new Bike("XNO1706", "Yamaha YZF-R3", 2015, 60500, 45, 2, 600, BikeType.TOURING));
		shop.addVehicle((Vehicle)new Bike("XNX9901", "Kawasaki Ninja 300", 2012, 32000, 30, 2, 300, BikeType.CRUISER));
		shop.addVehicle((Vehicle)new Truck("XNA1207", "Volvo FH16", 2017, 90000, 250, 20000, 3, 4));
		shop.addVehicle((Vehicle)new Truck("XNA1208", "Scania XD1", 2018, 80000, 300, 25000, 3, 3));


		//Instantiating a few customers
		shop.addCustomer((Customer)new NaturalPerson("Nikos Arabatzis", "123456789", "3028210373", "Chania", "Greece"));
		shop.addCustomer((Customer)new NaturalPerson("Johanes Stevenson", "987456321", "4621097275", "Stockholm", "Sweden"));
		shop.addCustomer((Customer)new LegalPerson("Nick Malone", "741258963", "3536975589", "Dublin", "Ireland", 10));
		shop.addCustomer((Customer)new LegalPerson("Tim Roberg", "258963147", "3265738648", "Brussels", "Belgium", 20));
		
		//Instantiating a few rents
		shop.addNewRent("123456789", "XNK5544", new Date("2019/04/03"), new Date("2019/04/22"));
		shop.addNewRent("987456321", "XNA1204", new Date("2019/04/05"), new Date("2019/04/08"));
		shop.addNewRent("741258963", "XNO1706", new Date("2019/06/05"), new Date("2019/06/15"));
		shop.addNewRent("258963147", "XNX9901", new Date("2019/06/05"), new Date("2019/06/15"));
		shop.addNewRent("123456789", "XNA1207", new Date("2019/06/05"), new Date("2019/06/14"));
		shop.addNewRent("987456321", "XNA1208", new Date("2019/06/07"), new Date("2019/06/15"));
		shop.addNewRent("741258963", "XNK5544", new Date("2019/06/05"), new Date("2019/06/15"));
		shop.addNewRent("258963147", "XNM1345", new Date("2019/06/05"), new Date("2019/06/15"));
		
		
		/* *************************** PRINT USER MENOU AND HANDLE CHOICES ***********************/   
		int userOption = 0;
		StandardInputRead reader = new StandardInputRead();
		while (userOption!=11){ 
			 printMenu();
	         String userInput = reader.readString("What would you like to do? ");
	            if (userInput == null) {
	                continue;
	            } else {
	                try {
	                    userOption = Integer.parseInt(userInput);
	                } catch (NumberFormatException ex) {
	                    userOption = 0;
	                }
	            }

	            
	    int printChoice; 
	    String tmp, TRN, VRN;
	    Date startD, endD;
	            
		switch(userOption) {
		case 1:
			shop.newVehicle();
			reader.readString("Press any key to continue...");
			break;	
		case 2:
			tmp=reader.readString("Give the vehicle's registration number (VRN)...");
			shop.printVehicle(tmp);
			reader.readString("Press any key to continue...");
			break;
		case 3:	
			tmp=reader.readString("Give the vehicle's registration number (VRN)...");
			shop.delVehicle(tmp);
			reader.readString("Press any key to continue...");
			break;
		case 4:	
			shop.printAllVehicles();
			reader.readString("Press any key to continue...");
			break;
		case 5:	
			System.out.println("Select the category whose cars you want to print");
			System.out.println("1.Passenger");
			System.out.println("2.Passenger->Car");
			System.out.println("3.Passenger->Bike");
			System.out.println("4.Truck");
			printChoice=reader.readPositiveInt("");
			switch(printChoice) {
			case 1:
				shop.printVehiclesByCategory("tuc.ece.cs102.vehicles.Passenger");
				break;
			case 2:
				shop.printVehiclesByCategory("tuc.ece.cs102.vehicles.Car");
				break;
			case 3:
				shop.printVehiclesByCategory("tuc.ece.cs102.vehicles.Bike");
				break;
			case 4:
				shop.printVehiclesByCategory("tuc.ece.cs102.vehicles.Truck");
				break;
			default: 
		        System.out.println("User option " + userOption + " ignored...");
		        continue;	
			}
			reader.readString("Press any key to continue...");
			break;
		case 6:	
			shop.newCustomer();
			reader.readString("Press any key to continue...");
			break;
		case 7:	
			tmp=reader.readString("Give the customer's tax registration number (TRN)...");
			shop.printCustomer(tmp);
			reader.readString("Press any key to continue...");
			break;
		case 8:
			tmp=reader.readString("Give the customer's tax registration number (TRN)...");
			shop.delCustomer(tmp);
			reader.readString("Press any key to continue...");
			break;
		case 9:
			TRN=reader.readString ("Give the customer's tax registration number (TRN)...");
			VRN=reader.readString ("Give the vehicle's registration number (VRN)........");
			startD=reader.readDate("Give the starting date, in format dd/mm/yyyy........");
			endD=reader.readDate  ("Give the ending date, in format dd/mm/yyyy..........");
			shop.addNewRent(TRN, VRN, startD, endD);
			reader.readString("Press any key to continue...");
			break;
		case 10:
			System.out.println("Select the filter to print rents:");
			System.out.println("1.By vehicle");
			System.out.println("2.By customer");
			System.out.println("3.By time period");
			printChoice=reader.readPositiveInt("");
			switch (printChoice) {
			case 1:
				shop.printRentsByVehicle();
				break;
			case 2:
				shop.printRentsByCustomer();
				break;
			case 3:
				shop.printRentsByTimePeriod();
				break;
			default: 
		        System.out.println("User option " + userOption + " ignored...");
		        continue;	
			}
			reader.readString("Press any key to continue...");
			break;
			
			
        case 11:                 
        	System.out.println("Thanks for using the Car Renting Shop Console...");
            break;	                
        default:	                    
            System.out.println("User option " + userOption + " ignored...");
            continue;	
			
		} 
		}

	}
	
	public static void printMenu() {
        System.out.println("                       Vehicle Renting Shop Console                          ");
        System.out.println("=============================================================================");
       
        System.out.println("1. Register a new vehicle...................................................."); 
        System.out.println("2. Search for a vehicle......................................................");
        System.out.println("3. Delete a vehicle .........................................................");
        System.out.println("4. Print all the vehicles....................................................");
        System.out.println("5. Search for vehicles of a specific category ...............................");
        System.out.println("   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("6. Register a new customer..................................................."); 
        System.out.println("7. Search for a customer.....................................................");
        System.out.println("8. Delete a customer........................................................."); 
        System.out.println("   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");     
        System.out.println("9. Register a new rent......................................................."); 
        System.out.println("10. Print all the rents, by vehicle/customer/time period....................."); 
        
        System.out.println("11. Exit......................................................................"); 
        System.out.println("=============================================================================");        
    }

}
