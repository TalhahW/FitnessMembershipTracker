package MEM;

import java.util.Calendar;


public class Coach  {

	private String name;
	
	
	public Coach(String name){
		this.name= name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String print() {
		return getName();
	}
	
	public boolean occursOn(Coach other) {
		if (this.getName().equals(other.getName())) {
			return true;
		} else

			return false;

	}
}


