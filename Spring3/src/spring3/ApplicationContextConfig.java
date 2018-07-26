package spring3;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("spring3") //only for the other @Components not defined here manually. Only dog component bean is manually defined here.
@PropertySource("classpath:spring3/animal.properties")
public class ApplicationContextConfig {
	@Bean
	public MovementServiceInterface movementService() { //constructing movementService bean for injection at dog bean.
		return new MovementService3();
	}
	@Bean
	public Address address(@Value("${animal.street}") String street, @Value("${animal.number}") String number, @Value("${animal.city}") String city, @Value("${animal.state}") String state, @Value("${animal.country}") String country) { //constructing address bean for injection at dog bean.
		return new Address(street, number, city, state, country); //the @Value(${prop.name}) MUST BE put at the defining method above, not at the Constructor.
	}
//	@Bean
//	public AnimalInterface dog() { //creating dog bean and injecting dependencies 
//		return new Dog(movementService(), "Apollo", "2007-07-01", address(null, null, null, null, null));  
//	}
	@Bean
	public AnimalInterface dog(@Qualifier("movementService3") MovementServiceInterface movementServiceInterface, @Value("Apollo") String name, @Value("2007-07-01") String birthDate, Address address) { //creating dog bean and injecting dependencies 
		return new Dog(movementService(), name, birthDate, address(null, null, null, null, null));  
	}
}


/*In a Java Config Class, ir @Value or @Qualifier are needed, they have to be used in the bean defining method, on the left side of the respective parameters,
 * and then, those parameters, with the values set and qualified, injected as arguments in the Constructor itself. These annotations are NOT allowed at the Constructor.
 * Method calls or String literals, otherwise, can be injected directly at the Constructor, or passed to it through parameters previously set at the bean defining method, 
 * as in the case of properties values that have to use @Value or @Qualifier annotations. Thus, method defining parameters may or may not be necessary, depending on if
 * you have to use annotations to get the values of the constructor arguments. Using constructor injection of arguments previously set with annotations at the bean 
 * defining method avoids having to field inject these values at the bean class itself, which would be an alternative if annotations at the config java class could not 
 * be used.
 * For more about bean inter-bean reference and CGLIB proxy at java config classes, see: 
 * https://dzone.com/articles/defining-bean-dependencies-with-java-config-in-spring-framework.
 */

