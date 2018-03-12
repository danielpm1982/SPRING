package spring3;
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

@Component("cat")
@Scope("singleton")
//@Scope("prototype")
public class Cat implements AnimalInterface{
//	@Autowired //dependency injection through fields and reflection
//	@Qualifier("movementService3")
	private MovementServiceInterface movementService;
//	@Value("Mimi")
	private String name;
//	@Value("2010-12-05")  
	private LocalDate birthDate;
//	@Autowired
	private Address address;
	@Autowired
	public Cat(@Qualifier("movementService2") MovementServiceInterface movementService, @Value("Mimi") String name, @Value("2010-12-05") String birthDate, Address address) {
		this.movementService=movementService;
		this.name=name;
		this.birthDate=LocalDate.parse(birthDate);
		this.address=address;
	}
	@Override
    public String makeSound() {
    	return "MiauMiau!!";
    }
    @Override
    public String move() {
    	return movementService+": "+movementService.move(AnimalType.CAT);
    }
//    @Autowired //injecting dependencies through setters instead of through Constructor
//    @Qualifier("movementService1")
//    public void setMovementService(MovementServiceInterface movementService) {
//		this.movementService = movementService;
//	}
//    @Value("Mimi")
//    public void setName(String name) {
//		this.name = name;
//	}
//    @Value("2010-12-05")
//    public void setBirthDate(String birthDate) {
//		this.birthDate = LocalDate.parse(birthDate);
//	}
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
