package MEM;

public class Member {
	
	private String name;
	private String phone;
	private String address;
	private Boolean attended;
	private Boolean paid;
	private double balance;
	
	public Member(String name, String phone, String address, Boolean attended, Boolean paid, double balance){
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.attended = attended;
		this.paid = paid;
		this.balance = balance;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public Boolean getAttended(){
		return this.attended;
	}
	
	public Boolean getPaid(){
		return this.paid;
	}
	
	public double getBalance(){
		return this.balance;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setAttended(Boolean attended){
		this.attended = attended;
	}
	
	public void setPaid(Boolean paid){
		this.paid = paid;
	}
	
	public void setBalance(double balance){
		this.balance = balance;
	}
	
	
	
	
}