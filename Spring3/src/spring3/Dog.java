package spring3;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;

//this bean is defined manually at the config java class - no component scanning here.
@Scope("singleton")
public class Dog implements AnimalInterface{
	//depenedency injection is done manually at the config java class after construction of the injecting beans.
	//qualified manually at the config java class.
	private MovementServiceInterface movementService;
	// @Value("Apollo") //the simple values for properties could also be injected through field injection, not only at the config java class.
	private String name;
	//injected manually at the config java class.
	private LocalDate birthDate;
	//injected manually at the config java class after construction from animal.properties source file.
	private Address address;
	//Constructor to be used at the bean creation inside the config java class:
	public Dog(MovementServiceInterface movementService, String name, String birthDate, Address address) { 
		this.movementService=movementService;
		this.name=name;
		this.birthDate=LocalDate.parse(birthDate);
		this.address=address;
	}
	@Override
    public String makeSound() {
    	return "AuAuAuAu!!";
    }
    @Override
    public String move() {
    	return movementService+": "+movementService.move(AnimalType.DOG);
    }
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
