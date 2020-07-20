import java.util.*;



public class Subscribers extends NewsPaperSubscriber {
	//array list of the subscribers
	static ArrayList<NewsPaperSubscriber> subList = new ArrayList<NewsPaperSubscriber>();
     
       
	
	//constructor
	public Subscribers(String Street) {
		super(Street);
		setRate();
	
	}
	
	
	//main method
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean go = true;
		boolean sameA = false;
		
		
		
		System.out.println("What is your address?");
		String Street = scan.nextLine();
		System.out.println("Which service would you like top subscribe to? (SevenDay, Weekday, Weekend)");
		String choice = scan.nextLine();
		
		//decides the type of subscriber
		if(choice.equalsIgnoreCase("SevenDay")) {
			subList.add(new SevenDaySubscriber(Street));
		}
		
		else if(choice.equalsIgnoreCase("Weekday")) {
			subList.add(new WeekdaySubscriber(Street));
		}
		
		else if (choice.equalsIgnoreCase("Weekend")) {
			subList.add(new WeekendSubscriber(Street));
		}
		
		//decides if the user wishes to continue or not
		System.out.println("Would you like to enter another? Enter 'true' for yes and 'false' for no");
		go = scan.nextBoolean();
		scan.nextLine();
		
			do {
				
				System.out.println("Please enter another address");
				Street = scan.nextLine();
				//checks the array list to see if any of the street addresses match the one inputted
				for(NewsPaperSubscriber sub: subList) {
					if(sub.getsStreet().equals(Street)){
						sameA = true;
						System.out.println("Address already in use");
						break;
					}
				}
				//if the address is different it runs the loop again asking for the same information
				if(!sameA) {
					System.out.println("Which service would you like top subscribe to? (SevenDay, Weekday, Weekend)");
					choice = scan.nextLine();
					
					//decides subscriber type
					if(choice.equalsIgnoreCase("SevenDay")) {
						subList.add(new SevenDaySubscriber(Street));
						
					}
					
					else if(choice.equalsIgnoreCase("Weekday")) {
						subList.add(new WeekdaySubscriber(Street));
						
					}
					
					else if (choice.equalsIgnoreCase("Weekend")) {
						subList.add(new WeekendSubscriber(Street));
						
					}
					
				}
				//decides to loop again or not
				System.out.println("Would you like to enter another? Enter 'true' for yes and 'false' for no");
				go = scan.nextBoolean();
				scan.nextLine();
				
			}while(go == true);
			
			
		
		
		
		
		//prints the array list
		for(NewsPaperSubscriber sub: subList) {
			System.out.println();
			System.out.println(sub.toString());
			System.out.println("-----------------");
		}
		//closes the scanner
		scan.close();
	}

	//set rate method
	public void setRate() {
		
		
	}

}
