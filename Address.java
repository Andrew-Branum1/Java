package application;

import java.util.Scanner;
import java.lang.*;

public class Address{
	private String streetAddress, city, state;
	private int zipcode;
	//constructor
	public Address(){
		streetAddress = "";
		city = "";
		state = "";
		zipcode = 0;
	}
	//general address class
	public Address(String streetAddress, String city, String state, int zipcode) {
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public String toString() {
		String end;
		end = streetAddress+ "\n";
		end += city +", "+ state+ "  "+ zipcode;
		return end;
	}
	
	
	public String getstreetAddress() {
		return streetAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	public int getzipCode() {
		return zipcode;
	}
	public void setstreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setzipCode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
	
}
