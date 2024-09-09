package application;

@SuppressWarnings("serial")
public class SalePartment extends Partment {
	
	private int price;
	
	public SalePartment() {}
	
	public SalePartment(int id, String address, double area, int numOfRoom,int Rating, int price) throws Exception {
		super(id, address, area, numOfRoom,Rating,price);
		setPrice(Price);
		
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) throws Exception {
		if(price != (int)price) {
			throw new Exception("id is not an integer");
						
		}
		else {
			this.price = price ;
		}
	}

	public double Agencyfees(SalePartment partment) {
		return  partment.price*0.05; 
	}
	
	@Override
	public String toString() {
		return "SaleParment[ "+ "ID :"+ super.Id +" Address : "+ super.Address +" Area = "+ super.Area+ " NumOfRoom ="+ super.NumOfRoom +" Price =" + price + "USD"+"]";
	}

	
	
	
}
