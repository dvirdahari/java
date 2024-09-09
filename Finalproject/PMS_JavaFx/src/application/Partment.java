package application;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public abstract class Partment implements Cloneable,Serializable {
	
	protected int Id;
	protected String Address;
	protected double Area;
	protected int NumOfRoom;
	protected int Rating;
	protected int Price;
	private ArrayList<Client> allClients;
	
	public Partment()
	{
		
	}
	public Partment(int id, String address, double area, int numOfRoom,int Rating,int price) throws Exception {
		setId(id);
		this.Address = address;
		this.Area = area;
		setNumOfRoom(numOfRoom);
		setRating(Rating);
		this.allClients = new ArrayList<Client>();
		this.Price = price;
		
	}

	public int getId() {
		return Id;
	}

	public String getAddress() {
		return Address;
	}

	public double getArea() {
		return Area;
	}

	public int getNumOfRoom() {
		return NumOfRoom;
	}

	
	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) throws Exception {
		if(rating<0 || rating>10) {
			throw new Exception("The rating need to be between 0-10");
		}
		else {
			this.Rating = rating;		
		}						
	}

	public void setId(int id) throws Exception {
		if(id != (int)id) {
			throw new Exception("id is not an integer");
						
		}
		else {
			this.Id = id ;
		}
	}

	public void setNumOfRoom(int numOfRoom) throws Exception {
		if( numOfRoom != (int)numOfRoom) {
			throw new Exception("numOfRoom is not an integer");
		}
		else {
			this.NumOfRoom = numOfRoom ;
		}
	}

	public ArrayList<Client> getAllClients() {
		return allClients;
	}
	
	public void addClient(Client client) {
		allClients.add(client);
	}

	public boolean equals(Partment other) {
		return this.Address.equals(other.getAddress());
	}
	
	public String Agentfees(Partment partment) {
		if(partment instanceof RentBnb) {
			
		}else if(partment instanceof RentRegular) {
			System.out.println(partment);
			System.out.println("The Agency Fees is 4000¤");
			return "Partment :"+ partment + "The Agency Fees is 4000";
		}else {
			System.out.println(partment);
			System.out.println("The Agency Fees is:" + partment.Price*0.05);
			double p= partment.Price*0.05;
			String s=Double. toString(p);
			return "Partment :"+ partment + "The Agency Fees is " + p;
		}
		return "";
	}
	
	public Partment clone()throws CloneNotSupportedException{  
		return (Partment)super.clone();  
		}  
	
	
	
	
}

