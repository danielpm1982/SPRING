package springMVC3.model;
import java.util.Arrays;
import java.util.List;

public class Drink {
	private String drinkValue;
	private String drinkLabel;
	public Drink() {
		this.drinkValue="NONE!";
		this.drinkLabel="NONE!";
	}
	public Drink(String drinkValue, String drinkLabel) {
		this.drinkValue=drinkValue;
		this.drinkLabel=drinkLabel;
	}
	public String getDrinkValue() {
		return drinkValue;
	}
	public void setDrinkValue(String drinkValue) {
		this.drinkValue = drinkValue;
	}
	public String getDrinkLabel() {
		return drinkLabel;
	}
	public void setDrinkLabel(String drinkLabel) {
		this.drinkLabel = drinkLabel;
	}
	@Override
	public String toString() {
		return drinkValue+" : "+drinkLabel;
	}
	public static List<Drink> getDrinkList() {
		return Arrays.asList(new Drink("COKE","Coca-Cola"), new Drink("COKEZERO","Coca-Cola Zero"), new Drink("FANTAORANGE", "Fanta Orange"), new Drink("FANTAGRAPE", "Fanta Grape"), new Drink("SPRITE", "Sprite"));
	}
}
