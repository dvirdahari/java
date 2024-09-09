package application;

import java.io.Serializable;
import java.util.ArrayList;


@SuppressWarnings("serial")
public  class Office implements Serializable {
	
	private ArrayList<Partment> allPartment;
	private ArrayList<Rent> allRents;
	
	
	public Office() {
	this.allPartment = new ArrayList<Partment>();
	this.allRents = new ArrayList<Rent>();
	}
	
	public ArrayList<Partment> getAllPartment() {
		return allPartment;
	}

	public void addPartment(Partment partment) {
		allPartment.add(partment);
	}
	
	public ArrayList<Rent> getAllRents() {
		return allRents;
	}
	
	public void addRent(Partment rent) {
		allRents.add((Rent) rent);
	}
	
	@Override
	public String toString() {
		return "Office [allPartment=" + allPartment ;
	}
	
	
}


