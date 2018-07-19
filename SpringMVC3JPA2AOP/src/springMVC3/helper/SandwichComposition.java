package springMVC3.helper;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SandwichComposition {
	public static String getComposition(String sandwichName) {
		if(validadeNameAsEnumType(sandwichName)) {
			switch(SandwichType.valueOf(sandwichName)) {
				case BIGMEAL:
					return "A double layer of sear-sizzled 100% pure beef mingled with special sauce on a sesame seed bun and topped with melty American cheese, crisp lettuce, minced onions and tangy pickles";
				case CHEESEMEAL:
					return " A juicy 100% beef patty simply seasoned with a pinch of salt and pepper, melty American cheese, tangy pickles, minced onions, ketchup and mustard";
				case CHICKENMEAL:
					return "Famously crispy chicken topped with mayonnaise, shredded iceberg lettuce and served perfectly on a toasty bun. Show your taste buds some lovin’ with this local option";
				case BBQMEAL:
					return "A 100% beef patty seasoned with a pinch of salt and pepper, then topped with melted white cheddar, zesty barbecue ranch sauce and crispy tortilla strips, all on a classic bun";
				case FISHMEAL:
					return "Dive right in and enjoy our wild-caught fish from our sustainable fishery, topped with melty American cheese, creamy tartar sauce and served on a soft, steamed bun";
				default:
					return "NONE";
			}
		} else {
			return "NONE!";
		}
	}
	public static boolean validadeNameAsEnumType(String name) {
		return Arrays.asList(SandwichType.values()).stream().map(x->x.toString()).collect(Collectors.toList()).contains(name);
	}
}
