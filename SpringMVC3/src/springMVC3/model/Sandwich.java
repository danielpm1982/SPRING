package springMVC3.model;
import java.math.BigDecimal;

public class Sandwich {
	private String name;
	private String size;
	private String composition;
	private BigDecimal price;
	private String drink;
	private String[] sauceAddings;
	private String sauceAddingsStringified;
	private String frenchFries;
	private String[] payment;
	private String paymentStringified;
	public Sandwich() {
		this.name="NONE!";
		this.size="NONE!";
		this.composition="NONE!";
		this.price=new BigDecimal("0");
		this.drink="NONE!";
		this.sauceAddings= new String[] {"NONE!"};
		this.frenchFries= "NONE!";
		this.payment=new String[]{"NONE!"};
		this.sauceAddingsStringified = "NONE!";
		this.paymentStringified = "NONE!";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		this.composition=SandwichComposition.getComposition(name); //when the spring form sets the name, the respective sandwich composition is fetched and also set
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
		setPrice(SandwichPrice.getPrice(name, size)); //when the spring form sets the size, the price of the combo sandwich is fetched and also set. The price depends only on the sandwich and combo size types. The drink and sauceAddings are both included. 
	}
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public String[] getSauceAddings() {
		return sauceAddings;
	}
	public void setSauceAddings(String[] sauceAddings) {
		this.sauceAddings = sauceAddings;
		String temp ="";
		for (int i=0; i<sauceAddings.length-1; i++) {
			temp+=(sauceAddings[i]+", ");
		}
		temp+=(sauceAddings[sauceAddings.length-1]);
		setSauceAddingsStringified(temp);
	}
	public String getSauceAddingsStringified() {
		return sauceAddingsStringified;
	}
	public void setSauceAddingsStringified(String sauceAddingsStringified) {
		this.sauceAddingsStringified = sauceAddingsStringified;
	}
	public String getFrenchFries() {
		return frenchFries;
	}
	public void setFrenchFries(String frenchFries) {
		this.frenchFries = frenchFries;
	}
	public String[] getPayment() {
		return payment;
	}
	public void setPayment(String[] payment) {
		this.payment = payment;
		String temp ="";
		for (int i=0; i<payment.length-1; i++) {
			temp+=(payment[i]+", ");
		}
		temp+=(payment[payment.length-1]);
		setPaymentStringified(temp);
	}
	public String getPaymentStringified() {
		return paymentStringified;
	}
	public void setPaymentStringified(String paymentStringified) {
		this.paymentStringified = paymentStringified;
	}
	@Override
	public String toString() {
		return "name: "+name+" size: "+size+" composition: "+composition+" price: $"+price+" payment: $"+paymentStringified+" drink: "+drink+" sauceAddings: "+sauceAddingsStringified+" frenchFries: "+frenchFries;
	}
}
