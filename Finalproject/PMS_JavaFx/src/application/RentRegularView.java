package application;

public class RentRegularView {
	
	
	public RentRegularView() {}
	
	public RentRegularView(int id, String address, double area, int numOfRoom,int Rating,int price,int time, int month) 
	{
		 
	        System.out.println("\nRegular Rent Partmeny Booking Details: ");  
	        System.out.println("\nPartment ID : " + id);  
	        System.out.println("\nAddress : " + address);
	        System.out.println("\nArea : " + area);
	        System.out.println("\nRooms : " + numOfRoom);
	        System.out.println("\nRating : " + Rating);
	        System.out.println("\nPrice : " + price);
	        System.out.println("\nTime and Month : " + time+"  "+"month  :"+month);
	        
		
	}

}
