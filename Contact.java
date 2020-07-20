
public class Contact {
	protected String Name;
	protected  String Phone;
	
	//constructor
	Contact(String eName, String ePhone) throws PhoneNumberException{
		setName(eName);
		setPhone(ePhone);
	}
	
	//mutator methods
	public void setName(String eName) {
		Name = eName;
	}
	
	//setPhone method that determines if the number is of the correct format
	public void setPhone(String ePhone) throws PhoneNumberException {
		PhoneNumberException message = new PhoneNumberException("Incorract number format");
		PhoneNumberException message1 = new PhoneNumberException("Incorract number length");
		if(ePhone.length() == 8)  {
			
			if(ePhone.charAt(0) == '1') {
				throw message;
			}
			else if(ePhone.charAt(0) == '0') {
				throw message;
			}
		
			else if(ePhone.charAt(3) != '-'){
				throw message;
			}
		}
		else if(ePhone.length() == 12) {
			
			if(ePhone.charAt(3) != '-') {
				throw message;
			}
			
			else if(ePhone.charAt(4)== '1') {
				throw message;
			}
			else if(ePhone.charAt(4) == '0') {
				throw message;
			}
		}
		else {
			throw message1;
		}
		Phone = ePhone;
		System.out.println("Contact added.");
	}
	
	//get method
	public String getPhone() {
		return Phone;
	}
	
	//toString method 
	public String toString() {
		String a = "Name: " +Name+ "\n";
		String b = "Phone Number: " +Phone+ "\n";
		
		return a+b;
	}
	
}
