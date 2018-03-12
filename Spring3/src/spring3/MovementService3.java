package spring3;
import org.springframework.stereotype.Component;

@Component
public class MovementService3 implements MovementServiceInterface{
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