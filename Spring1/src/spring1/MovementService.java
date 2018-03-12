package spring1;
public class MovementService {
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
}
