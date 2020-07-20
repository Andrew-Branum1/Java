package application;
import java.util.*;
import java.lang.*;
public class Package extends Address {
	//initializes variables and Arraylist
	private int TrackingID;
	private double Cost, Weight;
	private static boolean Discount = false;
	private Address Destination = new Address();
	private Shipping shipMethod;
	enum Shipping {Air, Ground, Sea}; 
	
	static ArrayList<Package> packageList = new ArrayList<Package>() {
		 {
             add(new Package(0, Shipping.Ground, null, 0));
      
        }
	};
	
	
	
	//prints out the packages within the packageList
	public static void printpackageList() {
		for (Package pack : packageList) {
			System.out.println(pack);
			System.out.println("--------------");
			
		}
	}
	//contructor
	public Package() {
		Weight = 0;
		TrackingID = 0;
		Cost=0;
		shipMethod = null;
		Destination = null;
	}
	
	//basic package class
	public Package(double Weight, Shipping shipMethod, Address Destination, int TrackingID) {
		this.Weight = Weight;
		this.shipMethod=shipMethod;
		this.Destination= Destination;
		this.TrackingID = TrackingID;
		calculateCost();
	}
	//method to check for discounts
	public static void checkDiscount(ArrayList<Package> packageList) {
		for(int i = 0; i < packageList.size(); i ++) {
			for(int j = i +1; j < packageList.size(); j++) {
				if(packageList.get(i).getDestination().toString().contentEquals(packageList.get(j).getDestination().toString())) {
					Discount = true;
					
				}
				else {
					Discount = false;
				}
				
			}
			
		}
		
		
	}
	
	//calculates the cost based off of the discount and weight and shipping method
	public void calculateCost() {
		if(Discount == true) {
			if(Weight <= 8) {
				if(shipMethod.equals(Shipping.Air)) {
					Cost = 4.00*.1;
				}
				else if (shipMethod.equals(Shipping.Ground)) {
					Cost = 1.80*.1;
				}
				else {
					Cost = 0.55*.1;
				}
			}
			else if (Weight <= 16 && Weight >= 9) {
				if(shipMethod.equals(Shipping.Air)) {
					Cost = 6.00*.1;
				}
				else if (shipMethod.equals(Shipping.Ground)) {
					Cost = 2.80*.1;
				}
				else {
					Cost = 1.50*.1;
				}
				
			}
			else {
				if(shipMethod.equals(Shipping.Air)) {
					this.Cost = 9.00*.1;
				}
				else if (shipMethod.equals(Shipping.Ground)) {
					this.Cost = 2.8*.1;
				}
				else {
					this.Cost = 2.00*.1;
				}
				
			}
		}
		else {
		if(Weight <= 8) {
			if(shipMethod.equals(Shipping.Air)) {
				Cost = 4.00;
			}
			else if (shipMethod.equals(Shipping.Ground)) {
				Cost = 1.80;
			}
			else {
				Cost = 0.55;
			}
		}
		else if (Weight <= 16 && Weight >= 9) {
			if(shipMethod.equals(Shipping.Air)) {
				Cost = 6.00;
			}
			else if (shipMethod.equals(Shipping.Ground)) {
				Cost = 2.80;
			}
			else {
				Cost = 1.50;
			}
			
		}
		else {
			if(shipMethod.equals(Shipping.Air)) {
				this.Cost = 9.00;
			}
			else if (shipMethod.equals(Shipping.Ground)) {
				this.Cost = 2.8;
			}
			else {
				this.Cost = 2.00;
			}
			
		}
		}
	
	}
	
	//getters and setters
	public double getWeight() {
		return Weight;
	}
	public Shipping getshipMethod() {
		return shipMethod;
	}
	public Address getDestination() {
		return Destination;
	}
	public void setWeight(double Weight) {
		this.Weight = Weight;
		calculateCost();
	}
	public void setshipMethod(Shipping shipMethod) {
		this.shipMethod = shipMethod;
		calculateCost();
	}
	public void setDestination(Address Destination) {
		this.Destination = Destination;
	}
	
	
	public void setTrackingID(int TrackingID) {
		   this.TrackingID = TrackingID;
	   }
	//ToString method to format the output
	public String toString() {
		String end;
		end = "Weight: " +Weight+ " ounces \n";
		end += "Shipping Method: by " +shipMethod+ "\n";
		end += "Cost: $" +Cost + "\n";
		end += "Applied Discount: "+Discount+ "\n";
		end += "Tracking ID: " +TrackingID+ "\n";
		end += "Address: "+Destination+ "\n";		
		return end;
	}
	
	//main
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean another = false;
		Shipping shipMethod= null;
		Address Destination= new Address();
		int TrackingID = 0;
		int i = 0;
		Random r = new Random();
		
		do {	//loop that runs until user doesn't want to add any packages
		
		System.out.println("Package Weight?");
		double Weight = scan.nextDouble();
		scan.nextLine();
		System.out.println("Shipping Method (Air, Ground, Sea)?");
		String ship;
		ship=scan.nextLine();
		
			if(ship.equalsIgnoreCase("air")) {
				shipMethod = Shipping.Air;
			}
			else if (ship.equalsIgnoreCase("Ground")) {
				shipMethod = Shipping.Ground;
			}
			else {
				shipMethod = Shipping.Sea;
			}
			
		System.out.println("Street Address of Destination?");
		String streetAddress = scan.nextLine();
		Destination.setstreetAddress(streetAddress);
		System.out.println("City of Destination?");
		String city = scan.nextLine();
		Destination.setCity(city);
		System.out.println("State of Destination?");
		String state = scan.nextLine();
		Destination.setState(state);
		System.out.println("5 digit ZIP Code of Destination?");
		int zipcode = scan.nextInt();
		Destination.setzipCode(zipcode);
		scan.nextLine();
		System.out.println("Would you like to add another package? Y or N");
		String ans;
		ans = scan.nextLine();
		Random rnd = new Random();
		Destination = new Address(streetAddress, city, state, zipcode);
	    TrackingID = rnd.nextInt(899999) + 100000;
		packageList.get(i).setWeight(Weight); //sets all the users info to the packageList
		packageList.get(i).setshipMethod(shipMethod);
		packageList.get(i).setDestination(Destination);
		packageList.get(i).setTrackingID(TrackingID);
		packageList.get(i).Destination.setCity(city);
		packageList.get(i).Destination.setState(state);
		packageList.get(i).Destination.setzipCode(zipcode);
		packageList.get(i).setTrackingID(TrackingID);
		checkDiscount(packageList);
		if(Discount == true) {
			packageList.get(i).setWeight(Weight); //sets all the users info to the packageList with discount
			packageList.get(i).setshipMethod(shipMethod);
		}
			if(ans.equalsIgnoreCase("Y")) {
				another = true;
				Destination = new Address();
				packageList.add(new Package(0, Shipping.Ground, Destination, TrackingID));
				i ++;
				
			}
			else {
				another = false;
			}
		
		System.out.println();
		}while(another == true);
		
		printpackageList();//prints packageList
		
	}
	
}
