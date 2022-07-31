package office;

public class Main {

	public static void main(String[] args) {
		
		Partment c1 = new SaleParment(1234,"ness",136.4,5,400);
		Partment c2 = new SaleParment(1234,"ness",136.4,5,450);
		Client d1 = new Client("0546011778", "yossi");
		Office a1 = new Office() {};
		
		a1.addPartment(c1);
		a1.addPartment(c2);
		c1.addClient(d1);
		
		System.out.println(a1.getAllPartment());
		System.out.println(c1.getAllClients());
	}

}
