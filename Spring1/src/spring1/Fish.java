package spring1;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Fish implements Animal{
    MovementService movementService;
    private String name;
	private LocalDate birthDate;
	private Address address;
    public Fish() {
	}
    public Fish(MovementService movementService, String name, String birthDate, Address address) {
    	this.movementService=movementService;
		this.name=name;
		this.birthDate=LocalDate.parse(birthDate);
		this.address=address;
	}
	@Override
    public String makeSound() {
        return "GlupGlup!!";
    }
    @Override
    public String move() {
        return movementService.move(AnimalType.FISH);
    }
    public void init() {
    	System.out.println("Initializing "+this.getClass().getName()+" Beans...\n");
    }
    public void destroy() {
        System.out.println("Destroying "+this.getClass().getName()+" Beans.");
    }
    public void setMovementService(MovementService movementService) {
		this.movementService = movementService;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate=LocalDate.parse(birthDate);
	}
	public void setAddress(Address address) {
		this.address = address;
	}
    @Override
    public String toString() {
    	return this.getClass().getSimpleName()+" -> name: "+name+" birthdate: "+(birthDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))+" address: "+address);
    }
}
