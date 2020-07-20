import java.util.*;

public class ContactBuilder extends Contact {

	static ArrayList<ContactBuilder> subList = new ArrayList<ContactBuilder>(10);
	
	ContactBuilder(String eName, String ePhone) throws PhoneNumberException {
		super(eName, ePhone);
		// TODO Auto-generated constructor stub
	}
	
	
	//main method
	public static void main(String[] args) throws PhoneNumberException {
		Scanner scan = new Scanner(System.in);
		boolean quit = true;
		int i = 0;
		
		//loops until user quits
		while(quit) {
			
			System.out.println("Hello, please enter the name of the contact");
			String eName = scan.nextLine();
			System.out.println("Please enter the phone number.");
			String ePhone = scan.nextLine();
			
			//adds contact to the list
			subList.add(new ContactBuilder(eName, ePhone));
			subList.get(i).setPhone(ePhone);
			
			System.out.println("Would you like to add another contact? 'true' for yes and 'false' for no");
			quit = scan.nextBoolean();
			i++;
			scan.nextLine();
		}
		
		//prints the array list
		for(Contact contact: subList) {
			System.out.println();
			System.out.println(contact.toString());
			System.out.println("-----------------");
		}
		//closes the scanner
		scan.close();

	}

}
