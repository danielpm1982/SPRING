package spring2;
import org.springframework.stereotype.Component;

@Component
public class MovementService1 implements MovementServiceInterface{ //Id auto generated from class name: movementService1. Except when the first two or more characters of the class name are upper case, in which case the id uses the Class name without any modification.
	@Override
	public String move(AnimalType animalType) {
		switch(animalType) {
			case DOG:
				return "Dog is walking!";
			case CAT:
				return "Cat is running!";
			case FISH:
				return "Fish is swimming!";
			default:
				return "Unkown species is moving!";
		}
	}
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
