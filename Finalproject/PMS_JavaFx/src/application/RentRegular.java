package application;


@SuppressWarnings("serial")
public class RentRegular extends Rent {

	private int month;

	public RentRegular() {
		
	}
	public RentRegular(int id, String address, double area, int numOfRoom,int Rating,int price,int time, int month) throws Exception {
		super(id, address, area, numOfRoom,Rating,price,time);
		this.month = time;		
		
		}

	public void Agencyfees(SalePartment partment) {
		System.out.println("The Agency fees is 4000");
	}
		
	
	public int getMonth() {
		return month;
		}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "RentRegular[" + "ID :"+ super.Id +" Address : "+ super.Address +" Area = "+ super.Area+ " NumOfRoom ="+ super.NumOfRoom + " month=" + month + "]";
	}
	
	
}