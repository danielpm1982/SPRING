package spring7AOP;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("spring7AOP")
@PropertySource("classpath:spring7AOP/app.properties")
public class ApplicationContextConfig {
	@Bean("address1")
	@Scope("singleton")
	public Address address1(@Value("${client1.street}") String street, @Value("${client1.number}") String number, @Value("${client1.city}") String city, @Value("${client1.state}") String state, @Value("${client1.country}") String country) {
		return new Address(street, number, city, state, country);
	}
	@Bean("address2")
	@Scope("singleton")
	public Address address2(@Value("${client2.street}") String street, @Value("${client2.number}") String number, @Value("${client2.city}") String city, @Value("${client2.state}") String state, @Value("${client2.country}") String country) {
		return new Address(street, number, city, state, country);
	}
	@Bean("client1")
	@Scope("prototype")
	public Client client1(@Value("${client1.name}") String name, @Value("${client1.birthDate}") String birthDate, Address address1) { 
		return new Client(name, birthDate, address1(null, null, null, null, null));  
	}
	@Bean("client2")
	@Scope("prototype")
	public Client client2(@Value("${client2.name}") String name, @Value("${client2.birthDate}") String birthDate, Address address2) { 
		return new Client(name, birthDate, address2(null, null, null, null, null));  
	}
	@Bean("clientPrinter")
	@Scope("singleton")
	public ClientPrinter clientPrinter(@Value("Printing clients...") String title) { 
		return new ClientPrinter(title);  
	}
}
