package spring2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component()
public class Address {
	private String street;
	private String number;
	private String city;
	private String state;
	private String country;
	public Address(@Value("${animal.street}") String street, @Value("${animal.number}") String number, @Value("${animal.city}") String city, @Value("${animal.state}") String state, @Value("${animal.country}") String country) {
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
