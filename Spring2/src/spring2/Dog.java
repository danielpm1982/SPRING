package spring2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dog")
//@Scope("singleton")
@Scope("prototype")
public class Dog implements AnimalInterface{
	@Autowired //dependency injection through fields and reflection
	@Qualifier("movementService3")
	private MovementServiceInterface movementService;
	@Value("Apollo")
	private String name;
//	@Value("2007-07-01") //field injection for birthDate or other complex fields won't work 'cause it seems not to exist a way of manipulating the String value in order to parse it to LocalDate, as in the Constructor and setter has been done successfully. Using these two approaches instead, in these cases.  
	private LocalDate birthDate;
	@Autowired
	private Address address;
//	@Autowired  //this annotation is optional if there's only one constructor at the bean Class to be injected with that dependencies
//	public Dog(@Qualifier("movementService2") MovementServiceInterface movementService, @Value("Apollo") String name, @Value("2007-07-01") String birthDate, Address address) { //the @Qualifier is alongside the parameters, not outside as the @Autowired
//		this.movementService=movementService;
//		this.name=name;
//		this.birthDate=LocalDate.parse(birthDate);
//		this.address=address;
//	}
	@Override
    public String makeSound() {
    	return "AuAuAuAu!!";
    }
    @Override
    public String move() {
    	return movementService+": "+movementService.move(AnimalType.DOG);
    }
//    @Autowired //injecting dependencies through setters instead of through Constructor
//    @Qualifier("movementService1")
//    public void setMovementService(MovementServiceInterface movementService) {
//		this.movementService = movementService;
//	}
//    @Value("Apollo")
//    public void setName(String name) {
//		this.name = name;
//	}
    @Value("2007-07-01")
    public void setBirthDate(String birthDate) {
		this.birthDate = LocalDate.parse(birthDate);
	}
//    @Autowired
//    public void setAddress(Address address) {
//		this.address = address;
//	}
    @PostConstruct
    public void init() {
        System.out.println("Initializing "+this.getClass().getName()+" Bean...");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("Destroying "+this.getClass().getName()+" Bean.");
    }
    @Override
    public String toString() {
    	return this.getClass().getSimpleName()+" bean instance. Name: "+name+". BirthDate: "+(birthDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))+". Address: "+address+".");
    }
}
