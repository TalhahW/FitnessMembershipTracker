package MEM;

public class Months {

	private String duty;
	private String log;
	private String Name;
	
	
	
public Months(String aName, String aduty, String alog){
	setName(aName);
	setDuty(aduty);
	setLog(alog);
}



public String getName() {
	return Name;
}



public void setName(String name) {
	Name = name;
}



public String getDuty() {
	return duty;
}



public void setDuty(String duty) {
	this.duty = duty;
}



public String getLog() {
	return log;
}



public void setLog(String log) {
	this.log = log;
}


	
	
}
