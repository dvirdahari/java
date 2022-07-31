package office;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Office {
	
	private ArrayList<Partment> allPartment;
	
	
	public Office() {
	this.allPartment = new ArrayList<Partment>();
	}
	
	public ArrayList<Partment> getAllPartment() {
		return allPartment;
	}

	public void addPartment(Partment partment) {
		allPartment.add(partment);
	}
	
	@Override
	public String toString() {
		return "Office [allPartment=" + allPartment ;
	}
	
	
}

