
public abstract class Cipher {
	protected String PlainText;
	protected String CipherText;
	
	Cipher(String Text){//constructor that initializes PlainText and CypherText
		PlainText = Text;
		CipherText = "";
	}
	
	//mutators and accessor methods
	protected String getPlainText() {
		return PlainText;
	}
	
	protected String getCipherText() {
		return CipherText;
	}
	
	public void setPlainText(String Text) {
		PlainText = Text;
	}
	
	public void setCipherText(String Text2) {
		CipherText = Text2;
	}
	
	//encode and decode methods
	
	public abstract String Encode();
	public abstract String Decode();
	
	
	public static void main(String[] args) {
	

	}

}
