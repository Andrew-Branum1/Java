import java.util.*;


public abstract class NewsPaperSubscriber {
	
protected String sStreet;
protected double sRate;

//constructor that initializes street address
public NewsPaperSubscriber(String Street) {
	sStreet = Street;
	sRate = 0;
}

//getter and setter methods
public String getsStreet() {
	return sStreet;
}

public double getsRate() {
	return sRate;
}

public void setsStreet(String Street) {
	sStreet = Street;
}
//abstract setRate
public abstract void setRate();

public void equals() {

}
	
	public static void main(String[] args) {
	

	}

}
