package office;

public class SaleParment extends Partment {
	
	private int price;

	public SaleParment(int id, String address, double area, int numOfRoom, int price) {
		super(id, address, area, numOfRoom);
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SaleParment [price=" + price + "]";
	}
	
}
