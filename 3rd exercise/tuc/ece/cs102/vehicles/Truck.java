package tuc.ece.cs102.vehicles;

public class Truck extends Vehicle{
	private int maxPermittedPayload;
	private float width;
	private float height;
	
	//Constructors
	public Truck() {}
	
	public Truck(String VRN, String FirmModel, int YearReleased, double Kms, float PricePerDay,int maxPermittedPayload, float width, float height) {
		super(VRN, FirmModel, YearReleased, Kms, PricePerDay);
		this.maxPermittedPayload=maxPermittedPayload;
		this.width=width;
		this.height=height;
	}

	//Setters and getters
	public int getMaxPermittedPayload() {
		return maxPermittedPayload;
	}

	public void setMaxPermittedPayload(int maxPermittedPayload) {
		this.maxPermittedPayload = maxPermittedPayload;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}


	
	//Other methods
	@Override
	public void print() {
		System.out.println("Vehicle->Truck: "+ this.toString());
		
	}

	@Override
	public String toString() {
		return " VRN: "+this.getVRN()+" Firm-Model: "+this.getFirmModel()+ " Year released: "+ this.getYearReleased()+" Kms: "+this.getKms()+" Renting price/day: "+ this.getPricePerDay()+" Maximum permitted payload:"+this.getMaxPermittedPayload()+" Width: "+this.getWidth()+" Height: "+this.getHeight();
		}
}
