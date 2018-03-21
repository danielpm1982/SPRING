package springMVC3.model;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Order {
	@NotNull(message="You must type a client name!")
	@Size(min=1, message="At least one letter must be entered!")
	private String clientName;
	@NotNull(message="You must select one of the options!")
	@Size(min=1, message="At least one option must be selected!")
	private String sandwichName;
	@NotNull(message="You must select one of the options!")
	@Size(min=1, message="At least one option must be selected!")
	private String comboSize;
	private String sandwichComposition;
	private BigDecimal totalPrice;
	@NotNull(message="You must select one of the options!")
	@Size(min=1, message="At least one option must be selected!")
	private String drink;
	@NotNull(message="You must select one of the options!")
	@Size(min=1, message="At least one option must be selected!")
	private String[] sauceAddings;
	private String sauceAddingsStringified;
	@NotNull(message="You must check one of the options!")
	@Size(min=1, message="At least one option must be checked!")
	private String frenchFries;
	@NotNull(message="You must select one of the options!")
	@Size(min=1, message="At least one option must be selected!")
	private String[] payment;
	private String paymentStringified;
	public Order() {
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getSandwichName() {
		return sandwichName;
	}
	public void setSandwichName(String sandwichName) {
		this.sandwichName = sandwichName;
		this.sandwichComposition=SandwichComposition.getComposition(sandwichName); //when the spring form sets the sandwichName, the respective sandwich composition is fetched and also set
		if(comboSize!=null) { //must check whether comboSize has already been set, as the sequence of the form settings can't be controlled.
			setTotalPrice(SandwichPrice.getPrice(sandwichName, comboSize)); //when the spring form has set the sandwichName and comboSize, the totalPrice of the combo sandwich is fetched and also set. The price depends only on the sandwich and comboSize types. The drink and sauceAddings are both included.
		}
	}
	public String getComboSize() {
		return comboSize;
	}
	public void setComboSize(String comboSize) {
		this.comboSize = comboSize;
		if(sandwichName!=null) { //must check whether sandwichName has already been set, as the sequence of the form settings can't be controlled.
			setTotalPrice(SandwichPrice.getPrice(sandwichName, comboSize)); //when the spring form has set the sandwichName and comboSize, the totalPrice of the combo sandwich is fetched and also set. The price depends only on the sandwich and comboSize types. The drink and sauceAddings are both included.
		}
	}
	public String getSandwichComposition() {
		return sandwichComposition;
	}
	public void setSandwichComposition(String sandwichComposition) {
		this.sandwichComposition = sandwichComposition;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice=totalPrice;
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
		if(sauceAddings.length>0) {
			for (int i=0; i<sauceAddings.length-1; i++) {
				temp+=(sauceAddings[i]+", ");
			}
			temp+=(sauceAddings[sauceAddings.length-1]);
			setSauceAddingsStringified(temp);
		}
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
		if(payment.length>0) {
			for (int i=0; i<payment.length-1; i++) {
				temp+=(payment[i]+", ");
			}
			temp+=(payment[payment.length-1]);
			setPaymentStringified(temp);
		}
	}
	public String getPaymentStringified() {
		return paymentStringified;
	}
	public void setPaymentStringified(String paymentStringified) {
		this.paymentStringified = paymentStringified;
	}
	@Override
	public String toString() {
		return "clientName: "+clientName+" sandwichName: "+sandwichName+" comboSize: "+comboSize+" sandwichComposition: "+sandwichComposition+" totalPrice: $"+totalPrice+" payment: $"+paymentStringified+" drink: "+drink+" sauceAddings: "+sauceAddingsStringified+" frenchFries: "+frenchFries;
	}
}
