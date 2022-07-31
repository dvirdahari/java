package office;

import java.util.ArrayList;

public abstract class Partment {
	
	protected int Id;
	protected String Address;
	protected double Area;
	protected int NumOfRoom;
	private ArrayList<Client> allClients;
	
	public Partment(int id, String address, double area, int numOfRoom) {
		this.Id = id;
		this.Address = address;
		this.Area = area;
		this.NumOfRoom = numOfRoom;
		this.allClients = new ArrayList<Client>();
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


	public ArrayList<Client> getAllClients() {
		return allClients;
	}
	
	public void addClient(Client client) {
		allClients.add(client);
	}

	@Override
	public String toString() {
		return "Id=" + Id + ",Address = " + Address + ",Area = " + Area + ",NumOfRoom = " + NumOfRoom;
	}
	
	
	
}
