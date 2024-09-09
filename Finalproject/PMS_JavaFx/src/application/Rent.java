package application;

@SuppressWarnings("serial")
public abstract class Rent extends Partment {
	
	protected int price;
	protected int time;

	public Rent() {
		
	}
	
	public Rent(int id, String address, double area, int numOfRoom, int Rating, int price,int time) throws Exception {
		super(id, address, area, numOfRoom, Rating,price);
		setPrice(Price);
		setTime(time);
		
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
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) throws Exception {
		if(time != (int)time) {
			throw new Exception("id is not an integer");
						
		}
		else {
			this.time = time ;
		}
	}
	
}

