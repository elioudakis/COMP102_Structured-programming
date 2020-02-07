package tuc.ece.cs102.vehicles;

import tuc.ece.cs102.vehicles.Car_Type.CarType;

public class Car extends Passenger {
	private int numOfDoors;
	private Car_EnergySource.carEnergy energy;
	private CarType type;
	
	//Constructors
	public Car() {}
	
	public Car(String VRN, String FirmModel, int YearReleased, double Kms, float PricePerDay, int maxNumOfPassengers, int cc,int numOfDoors, Car_EnergySource.carEnergy energy) {
		super(VRN, FirmModel, YearReleased, Kms, PricePerDay, maxNumOfPassengers, cc);
		this.numOfDoors=numOfDoors;
		this.energy=energy;
		if(maxNumOfPassengers<=7) {
			setType(Car_Type.CarType.PRIVATE_USAGE);
		}
		else {
			setType(Car_Type.CarType.PUBLIC_USAGE);
		}
	}


	
	//Getters and setters
	public int getNumOfDoors() {
		return numOfDoors;
	}

	public void setNumOfDoors(int numOfDoors) {
		this.numOfDoors = numOfDoors;
	}

	public Car_EnergySource.carEnergy getEnergy() {
		return energy;
	}

	public void setEnergy(Car_EnergySource.carEnergy energy) {
		this.energy = energy;
	}

	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		this.type = type;
	}
	
	
	//Other methods
	
	public void print() {
		System.out.println("Vehicle->Passenger->Car: "+ this.toString());
		
	}

	public String toString() {
		return " VRN: "+this.getVRN()+" Firm-Model: "+this.getFirmModel()+ " Year released: "+ this.getYearReleased()+" Kms: "+this.getKms()+" Renting price/day: "+ this.getPricePerDay()+" Maximum number of passengers: "+this.getMaxNumOfPassengers()+" Cc: "+this.getCc()+" Number of doors: " +this.getNumOfDoors()+" Energy source type: "+this.getEnergy()+ " Type of car: "+this.getType();
	}
	
	//To use in the console
	public static void printCarEnergyList() {
		System.out.println("Select one of the following energy sources:");
		System.out.println("1.Diesel");
		System.out.println("2.Gas");
		System.out.println("3.Battery");
	}
}
