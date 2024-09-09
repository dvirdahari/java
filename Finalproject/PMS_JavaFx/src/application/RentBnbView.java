package application;

public class RentBnbView {
	
	public RentBnbView() {}
	
	public RentBnbView(int id, String address, double area, int numOfRoom,int Rating,int price,int time, int day) 
	{
		 
	        System.out.println("\nRegular Rent Partmeny Booking Details: ");  
	        System.out.println("\nPartment ID : " + id);  
	        System.out.println("\nAddress : " + address);
	        System.out.println("\nArea : " + area);
	        System.out.println("\nRooms : " + numOfRoom);
	        System.out.println("\nRating : " + Rating);
	        System.out.println("\nPrice : " + price);
	        System.out.println("\nTime and Day : " + time+"  "+"Day : "+day);
	        
		
	}

}
