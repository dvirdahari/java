package office;

public class Client {

	private String Phone_Num;
	private String Name;
	
	public Client(String Phone_Num,String Name) {
		this.Phone_Num = Phone_Num;
		this.Name = Name;
	}

	public String getPhone_Num() {
		return Phone_Num;
	}

	public void setPhone_Num(String phone_Num) {
		Phone_Num = phone_Num;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "Client [Phone_Num=" + Phone_Num + ", Name=" + Name + "]";
	}
	
	
}
