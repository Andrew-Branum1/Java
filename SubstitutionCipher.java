import java.util.*;
import java.lang.*;

public class SubstitutionCipher extends Cipher {
	protected static int shift;
	
	//constructor
	SubstitutionCipher(String Text) {
		super(Text);
		CipherText = "";
		
	}
	
	//mutator and accessor methods
	public int getShift() {
		return shift;
	}
	
	public void setShift(int count) {
		shift = count;
	}
	
	
	
	//menu method
	public static void menu() {
		System.out.println("Select an Action: ");
		System.out.println("1: Encrypt a Message");
		System.out.println("2: Decrypy a Message");
		System.out.println("3: Quit");
	}

	//encoding method
	public String Encode() {
		String Text = super.getPlainText();
	    String s = "";
	    int len = Text.length();
	    for(int x = 0; x < len; x++){//loops through the sting one character at a time and applies the shift
	        char c = (char)(Text.charAt(x) + shift);
	        if ((Character.isLowerCase(Text.charAt(x)) && c > 'z')|| (Character.isUpperCase(Text.charAt(x)) && c > 'Z'))
	            s += (char)(Text.charAt(x) - (26-shift));
	        else
	            s += (char)(Text.charAt(x) + shift);
	    }
	    
	    //sets and returns cipher
	    super.setCipherText(s);
	    return super.getCipherText();
	}
		

	//decode method (almost the same as encoding)
	public String Decode() {
		String Text = super.getPlainText();
	    String s = "";
	    int len = Text.length();
	    for(int x = 0; x < len; x++){
	        char c = (char)(Text.charAt(x) - shift);
	        if ((Character.isLowerCase(Text.charAt(x)) && c > 'z')|| (Character.isUpperCase(Text.charAt(x)) && c > 'Z'))
	            s += (char)(Text.charAt(x) - (26-shift));
	        else
	            s += (char)(Text.charAt(x) - shift);
	    }
	    super.setCipherText(s);
	    return super.getCipherText();
	}
	

	
	//main method
	public static void main(String[] args) {
		boolean restart = true;
		do { // loops until user decides to quit
		menu();
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		
		switch(choice) {//captures the user's selection and runs the designated code
		case 1:
			System.out.println("Please enter the number of shifts");
			shift = scan.nextInt();
			scan.nextLine();
			System.out.println("Please enter your plain text");
			String answer = scan.nextLine();
			SubstitutionCipher c1 = new SubstitutionCipher(answer);
			System.out.println(c1.Encode());
			System.out.println("");
			break;
		case 2:
			System.out.println("Please enter the number of shifts");
			shift = scan.nextInt();
			scan.nextLine();
			System.out.println("Please enter your cipher text");
			String answer2 = scan.nextLine();
			SubstitutionCipher c2 = new SubstitutionCipher(answer2);
			System.out.println(c2.Decode());
			System.out.println("");
			break;
			
		case 3:
			restart = false;
			break;
		}
		}while(restart == true);
	}
}
