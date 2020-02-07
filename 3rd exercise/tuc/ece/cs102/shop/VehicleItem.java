package tuc.ece.cs102.shop;

import tuc.ece.cs102.list.Item;
import tuc.ece.cs102.vehicles.Vehicle;

public class VehicleItem extends Item {
	private Vehicle v;
	
	//Constructors
	public VehicleItem() {}
	
	public VehicleItem(Vehicle v) {
		this.v=v;
	}
	
	
	@Override
	public boolean equals(Item k) {
		return key().equals(k.key());
	}

	@Override
	public boolean less(Item k) {
		return ((String) key()).compareTo((String) k.key())<0;
	}

	@Override
	//Key for the vehicles is the VRN
	public Object key() {
		return v.getVRN();
	}

	@Override
	public void print() {
		v.print();	
	}
	
	public String toString() {
		return v.toString();
	}

	@Override
	public Object getData() {
		return this.v;
	}
	

}
