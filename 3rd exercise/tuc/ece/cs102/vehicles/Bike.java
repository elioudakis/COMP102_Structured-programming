package tuc.ece.cs102.vehicles;

public class Bike extends Passenger{
	private Bike_Type.BikeType type;

	//Constructors
	public Bike() {}
	
	public Bike(String VRN, String FirmModel, int YearReleased, double Kms, float PricePerDay, int maxNumOfPassengers, int cc, Bike_Type.BikeType type) throws IllegalArgumentException{
		super(VRN, FirmModel, YearReleased, Kms, PricePerDay,maxNumOfPassengers, cc);
		if(maxNumOfPassengers<=3) {
			this.type=type;
		}
		else {
			System.out.println("The number of passengers for a bike cannot exceed 3. The bike you wanted to register will be deleted. Try again...");
			throw new IllegalArgumentException("System message: invalid num of Passengers...");
			//the exception will stop the constructor if the num of passengers is greater than 3
		}
	}


	
	//Getter and Setter
	public Bike_Type.BikeType getType() {
		return type;
	}

	public void setType(Bike_Type.BikeType type) {
		this.type = type;
	}
	
	//Other methods
	public void print() {
		System.out.println("Vehicle->Passenger->Bike: "+ this.toString());
		
	}

	public String toString() {
		return " VRN: "+this.getVRN()+" Firm-Model: "+this.getFirmModel()+ " Year released: "+ this.getYearReleased()+" Kms: "+this.getKms()+" Renting price/day: "+ this.getPricePerDay()+" Maximum number of passengers"+this.getMaxNumOfPassengers()+" Cc: "+this.getCc()+" Bike type: "+this.getType();
	}
	
	//To use in the console
	public static void printBikeTypeList() {
		System.out.println("Select one of the following bike types:");
		System.out.println("1.Touring");
		System.out.println("2.Cruiser");
		System.out.println("3.Sport");
		System.out.println("4.On-off");
	}
}
