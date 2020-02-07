package tuc.ece.cs102.vehicles;

public abstract class Passenger extends Vehicle {
     private int maxNumOfPassengers;
     private int cc;
     
     //Constructors
     public Passenger() {}
     
     public Passenger(String VRM, String FirmModel, int YearReleased, double Kms, float PricePerDay, int maxNumOfPassengers, int cc) {
    	 super(VRM, FirmModel, YearReleased, Kms, PricePerDay);
    	 this.maxNumOfPassengers=maxNumOfPassengers;
    	 this.cc=cc;
     }


     
     //Getters and setters
 	public int getMaxNumOfPassengers() {
		return maxNumOfPassengers;
	}

	public void setMaxNumOfPassengers(int maxNumOfPassengers) {
		this.maxNumOfPassengers = maxNumOfPassengers;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}
     
	//Other methods
	public void print() {
		System.out.println("Vehicle->Passenger: "+ this.toString());
		
	}

	public String toString() {
		return "VRM: "+this.getVRN()+"Firm-Model: "+this.getFirmModel()+ "Year released: "+ this.getYearReleased()+"Kms: "+this.getKms()+"Renting price/day: "+ this.getPricePerDay()+"Maximum number of passengers"+this.getMaxNumOfPassengers()+"Cc: "+this.getCc();
	}
}
