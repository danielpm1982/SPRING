package spring3;

public class Address {
	private String street;
	private String number;
	private String city;
	private String state;
	private String country;
	public Address(String street, String number, String city, String state, String country) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	@Override
	public String toString() {
		return street+", "+number+", "+city+" - "+state+", "+country;
	}
}
