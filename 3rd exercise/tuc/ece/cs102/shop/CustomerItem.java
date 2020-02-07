package tuc.ece.cs102.shop;

import tuc.ece.cs102.customers.Customer;
import tuc.ece.cs102.list.Item;


public class CustomerItem extends Item{
	private Customer c;
	
	//Constructors
	public CustomerItem() {}
	
	public CustomerItem(Customer c) {
		this.c=c;
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
	//Key for the customers is their TRN
	public Object key() {
		return c.getTRN();
	}

	@Override
	public void print() {
		c.print();	
	}
	
	public String toString() {
		return c.toString();
	}

	@Override
	public Object getData() {
		return this.c;
	}
}
