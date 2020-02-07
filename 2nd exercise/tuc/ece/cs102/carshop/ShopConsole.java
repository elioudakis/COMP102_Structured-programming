package tuc.ece.cs102.carshop;

import tuc.ece.cs102.util.*;
public class ShopConsole {

	public static void main(String[] args){
		
		//Creating a new shop
		CarRentingShop shop=new CarRentingShop("Rent a car-John", "123456789" ,"Chania Port" );
		
		//Filling the list with a few given data
		shop.addCar(new Car("XNK5544", "Ford Fiesta", "2012", 6.4, 120000, 33, Characteristics.AIR_CONDITION, Characteristics.DIESEL));
		shop.addCar(new Car("XNA1204", "Opel Corsa", "2015", 4.7, 80000, 45, Characteristics.AIR_CONDITION, Characteristics.DIESEL, Characteristics.LEATHER_SEATS));
		shop.addCar(new Car("XNO1706", "Nissan Micra", "2015", 5, 60500, 45, Characteristics.DIESEL, Characteristics.CABRIOLET, Characteristics.LEATHER_SEATS));
		shop.addCar(new Car("XNX9901", "Lancia Ypsilon", "2012", 3.5, 32000, 30, Characteristics.AIR_CONDITION, Characteristics.DIESEL, Characteristics.AUTOMATIC));
		shop.addCar(new Car("XNA1207", "Toyota Yaris", "2017", 2.7, 17000, 50, Characteristics.AIR_CONDITION, Characteristics.HYBRID, Characteristics.AUTOMATIC));
		shop.addCar(new Car("XNA1208", "Nissan Quashqai", "2015", 6.8, 80000, 60, Characteristics.SEVEN_SEATS, Characteristics.DIESEL, Characteristics.FOUR_WHEEL_DRIVE));
		shop.addCar(new Car("XNA1209", "Ford Mustang", "2015", 4.7, 80000, 45, Characteristics.AIR_CONDITION, Characteristics.AUTOMATIC, Characteristics.LEATHER_SEATS));
		shop.addCar(new Car("XNH1210", "Opel Corsa", "2018", 3.6, 500, 80, Characteristics.AUTOMATIC, Characteristics.AIR_CONDITION, Characteristics.LEATHER_SEATS));
		shop.addCar(new Car("HKZ1211", "Toyota Aygo", "2018", 3.2, 6000, 45, Characteristics.AIR_CONDITION, Characteristics.DIESEL, Characteristics.AUTOMATIC));
		shop.addCar(new Car("MHO1212", "Audi A3", "2015", 6.1, 33000, 58, Characteristics.AIR_CONDITION, Characteristics.AUTOMATIC, Characteristics.LEATHER_SEATS));
		
		shop.addCustomer(new Customer("Nikos Arabatzis", "RPS442", 3, "Greece"));
		shop.addCustomer(new Customer("Johanes Stevenson", "RFF839", 12, "Sweden"));
		shop.addCustomer(new Customer("Katerina Mpampinioti", "HK6689", 2, "Greece"));
		shop.addCustomer(new Customer("Marilena Karopoulou", "PK0967", 5, "Greece"));
		shop.addCustomer(new Customer("Nick Malone", "JFK8FR", 14, "Ireland"));
		shop.addCustomer(new Customer("Tim Roberg", "HJK31F", 9, "Belgium"));
		shop.addCustomer(new Customer("Mario Marcelano", "ITF934", 3, "Italy"));
		shop.addCustomer(new Customer("Mantalena Paliarini", "ITJ798", 3, "Italy"));
		shop.addCustomer(new Customer("Klaus Regling", "DEF987", 18, "Germany"));
		shop.addCustomer(new Customer("Manousos Manousakis", "GR0912", 20, "Greece"));
	
		shop.addNewRent("RPS442", "XNX9901", "03/04/2019", "22/04/2019", "No",  0);
		shop.addNewRent("RFF839", "XNA1207", "05/04/2019", "08/04/2019", "No",  0);
		shop.addNewRent("HK6689", "XNA1208", "05/06/2019", "15/06/2019", "No",  0);
		shop.addNewRent("PK0967", "XNA1209", "05/06/2019", "15/06/2019", "No",  0);
		shop.addNewRent("JFK8FR", "XNH1210", "05/06/2019", "14/06/2019", "No",  0);
		shop.addNewRent("HJK31F", "HKZ1211", "07/06/2019", "15/06/2019", "No",  0);
		shop.addNewRent("ITF934", "MHO1212", "05/06/2019", "15/06/2019", "Yes", 20);
		shop.addNewRent("RPS442", "XNX9901", "03/05/2019", "19/05/2019", "Yes", 20);
		shop.addNewRent("PK0967", "XNA1207", "07/07/2019", "12/07/2019", "Yes", 10);
		shop.addNewRent("PK0967", "XNX9901", "07/06/2019", "15/06/2019", "Yes", 20);
	

		
		/* *************************** PRINT USER MENOU AND HANDLE CHOICES ***********************/   
		int userOption = 0;
		StandardInputRead reader = new StandardInputRead();
		while (userOption!=6){ 
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
		String custName, custLicNr,  custCountry, carPlate, carModel, carYear,discountYesNo, startStr, endStr;
		int custYears, carPrice, numOfCharacteristics,printChoice,discountPercent = 0;
		double carFuel;
		float carKm;
		Characteristics ch1, ch2, ch3;
		switch (userOption) {
		case 1:
			carPlate=reader.readString("Give the Vehicle Registration Number(VRM):");
			carModel=reader.readString("Give the car's model:");
			carYear=reader.readString("Give the car's release year:");
			carFuel=reader.readPositiveFloat("Give the car's fuel consumption per 100Kms:");
			carKm=reader.readPositiveFloat("Give the car's kilometers:");
			carPrice=reader.readPositiveInt("Give the car's renting price per day:");
			numOfCharacteristics=reader.readPositiveInt("How many characteristics do you want to register (0-3)");
			switch (numOfCharacteristics) {
			case 0:
				shop.addCar(new Car(carPlate, carModel, carYear, carFuel, carKm, carPrice));
				break;
			case 1:
				Car.printCharacteristicList();
				ch1=Car.selectCharacteristics();
				shop.addCar(new Car(carPlate, carModel, carYear, carFuel, carKm, carPrice, ch1));
				break;
			case 2:
				Car.printCharacteristicList();
				ch1=Car.selectCharacteristics();
				Car.printCharacteristicList();
				ch2=Car.selectCharacteristics();
				shop.addCar(new Car(carPlate, carModel, carYear, carFuel, carKm, carPrice, ch1,ch2));
				break;
			case 3:
				Car.printCharacteristicList();
				ch1=Car.selectCharacteristics();
				Car.printCharacteristicList();
				ch2=Car.selectCharacteristics();		
				Car.printCharacteristicList();
				ch3=Car.selectCharacteristics();
				shop.addCar(new Car(carPlate, carModel, carYear, carFuel, carKm, carPrice, ch1,ch2,ch3));
				break;
			default:
				System.out.println("User selection " + numOfCharacteristics + " ignored...");
				break;
			}
			break;
			
		case 2:	
			System.out.println("List of cars:");
			shop.printListCars();
			reader.readString("Press any key to continue...");
			break;
		case 3:
			custName=reader.readString("Give customer's name and surname");
			custLicNr=reader.readString("Give the customer's license number:");
			custYears=reader.readPositiveInt("Give the customer's years of experience:");
			custCountry=reader.readString("Give the customer's country:");
			shop.addCustomer(new Customer(custName, custLicNr, custYears, custCountry));
			reader.readString("Press any key to continue...");
			break;
		case 4:
			custLicNr=reader.readString("Give the customer's license number");
			carPlate=reader.readString("Give the car's plate number:");
			startStr=reader.readString("Give the starting date in format dd/mm/yyyy:");
			endStr=reader.readString("Give the ending date in format dd/mm/yyyy:");
			discountYesNo=reader.readString("Do you want a discount? Enter Yes or No");
			if(discountYesNo.equals("Yes")) {
				discountPercent=reader.readPositiveInt("Give the discount percent:");
			}
			shop.addNewRent(custLicNr, carPlate, startStr, endStr, discountYesNo, discountPercent);

			
			break;
		case 5:
			System.out.println("Select the filter to print rents:");
			System.out.println("1.By car");
			System.out.println("2.By customer");
			System.out.println("3.By time period");
			printChoice=reader.readPositiveInt("");
			switch (printChoice) {
			case 1:
				shop.printRentsByCar();
				break;
			case 2:
				shop.printRentsByCustomer();
				break;
			case 3:
				shop.printRentsByTimePeriod();
				break;
			}
			break;
			
			
        case 6:                 
        	System.out.println("Thanks for using the Car Renting Shop Console...");
            break;	                
        default:	                    
            System.out.println("User option " + userOption + " ignored...");
            continue;	
			
		}
		
	
		}
	}	
		
		public static void printMenu() {
	        System.out.println("                 Car Renting Shop Console");
	        System.out.println("=======================================================");
	        System.out.println("1. Add a new car..................................");
	        System.out.println("2. Print cars .............................");
	        System.out.println("3. Add a new customer..............................");
	        System.out.println("4. New rent.................................");
	        System.out.println("5. Print rents..............................");
	        System.out.println("6. Exit................................................"); 
	        System.out.println("=======================================================");        
	    }
}


