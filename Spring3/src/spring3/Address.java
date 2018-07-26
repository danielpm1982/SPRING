package spring3;
import org.springframework.beans.factory.annotation.Value;

public class Address {
//	@Value("${animal.street}") //no need for field injection if the values are injected at the java config class through the bean defining method using @Value or other related annotations.
	private String street;
//	@Value("${animal.number}")
	private String number;
//	@Value("${animal.city}")
	private String city;
//	@Value("${animal.state}")
	private String state;
//	@Value("${animal.country}")
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
