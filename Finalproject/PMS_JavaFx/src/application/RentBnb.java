package application;

@SuppressWarnings("serial")
public class RentBnb extends Rent {

	private int day;
	
	public RentBnb() {
		
	}
	public RentBnb(int id, String address, double area, int numOfRoom,int Rating,int price, int time,int day) throws Exception {
		super(id, address, area, numOfRoom,Rating,price,time);
		this.day = time;
		
	}



	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "RentBnb[" + "ID :"+ super.Id +" Address : "+ super.Address +" Area = "+ super.Area+ " NumOfRoom ="+ super.NumOfRoom + " day=" + day + "]";
	}
	

}
