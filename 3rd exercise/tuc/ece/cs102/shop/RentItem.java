package tuc.ece.cs102.shop;

import tuc.ece.cs102.list.Item;


public class RentItem extends Item {
	private Rent r;
	
	//Constructors
	public RentItem() {}
	
	public RentItem(Rent r) {
		this.r=r;
	}
	
	
	@Override
	public boolean equals(Item k) {
		return key().equals(k.key());
	}

	@Override
	public boolean less(Item k) {
		return ((Integer) key()).compareTo((Integer) k.key())<0;
	}

	@Override
	//Key for the rents is their code
	public Object key() {
		return r.getCode();
	}

	@Override
	public void print() {
		r.print();	
	}
	
	public String toString() {
		return r.toString();
	}

	@Override
	public Object getData() {
		return this.r;
	}
}
