
public class WeekdaySubscriber extends NewsPaperSubscriber {
	
	//constructor
	public WeekdaySubscriber(String Street) {
		super(Street);
		setRate();
	}


	//sets the rate
	public void setRate() {
		sRate = 7.5;	
	}
	
	public String toString() {
		String a = "Street address: " + sStreet + "\n";
		String b = "Rate: " +sRate + "\n";
		String c = "Service type: Weekday Subscriber \n";
		return a+b+c;
	}
}
