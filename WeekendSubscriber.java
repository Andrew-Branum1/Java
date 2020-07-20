
public class WeekendSubscriber extends NewsPaperSubscriber {

	//constructor
	public WeekendSubscriber(String Street) {
		super(Street);
		setRate();
	}


	//sets the rate
	public void setRate() {
		sRate = 4.5;	
	}
	
	public String toString() {
		String a = "Street address: " + sStreet + "\n";
		String b = "Rate: " +sRate + "\n";
		String c = "Service type: Weekend Subscriber \n";
		return a+b+c;
	}
}
