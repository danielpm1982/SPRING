package spring7AOP;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Client{
	private String name;
	private LocalDate birthDate;
	private Address address;
	public Client(String name, String birthDate, Address address) { 
		this.name=name;
		this.birthDate=LocalDate.parse(birthDate);
		this.address=address;
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
