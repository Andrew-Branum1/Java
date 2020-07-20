
public class SevenDaySubscriber extends NewsPaperSubscriber {

	//constructor
	public SevenDaySubscriber(String Street) {
		super(Street);
		setRate();
	}


	//sets the rate
	public void setRate() {
		sRate = 10.5;	
	}
	
	public String toString() {
		String a = "Street address: " + sStreet + "\n";
		String b = "Rate: " +sRate + "\n";
		String c = "Service type: 7 Day Subscriber \n";
		return a+b+c;
	}

}
