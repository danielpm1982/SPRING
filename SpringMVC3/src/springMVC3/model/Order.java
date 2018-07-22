package springMVC3.model;
import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import springMVC3.validation.DiscountCodeValidator;

public class Order {
	@NotNull(message="You must type a client name!")
	@Size(min=1, message="At least one letter must be entered!")
	@Pattern(regexp="^[\\p{L} \\.\\-]+$", message="Invalid Name!")
	private String clientName;
	@NotNull(message="You must type a SSN!")
	@Min(value=1, message="The min number is: '000000001'!")
	@Max(value=999999999, message="The max number is: '999999999'!")
	private Long SSN;
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
	@DiscountCodeValidator(value= {"A","B","C","D"}, message="This value must start with 'A' or 'B' or 'C' or 'D' + discount percent value (e.g. 'A20' = 20% discount). After the first char (the letter char), only two or three other chars are allowed for the number (from 10 to 100), which must end with '0' - counting by tens.")
//	@DiscountCodeValidator
	private String discountCode;
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
		if(discountCode!=null&&discountCode!=""&&sandwichName!=null&&comboSize!=null) {
			setTotalPrice(SandwichPrice.getPrice(sandwichName, comboSize, discountCode)); //if there a discountCode is inserted, then update the price value for that discount. 
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
		if(discountCode!=null&&discountCode!=""&&sandwichName!=null&&comboSize!=null) {
			setTotalPrice(SandwichPrice.getPrice(sandwichName, comboSize, discountCode)); //if there a discountCode is inserted, then update the price value for that discount. 
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
	public Long getSSN() {
		return SSN;
	}
	public void setSSN(Long SSN) {
		this.SSN = SSN;
	}
	public String getDiscountCode() {
		return discountCode;
	}
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
		if(discountCode!=null&&discountCode!=""&&sandwichName!=null&&comboSize!=null) {
			setTotalPrice(SandwichPrice.getPrice(sandwichName, comboSize, discountCode)); //if there a discountCode is inserted, then update the price value for that discount. 
		}
	}
	@Override
	public String toString() {
		return "clientName: "+clientName+" SSNCardNo: "+SSN+" sandwichName: "+sandwichName+" comboSize: "+comboSize+" sandwichComposition: "+sandwichComposition+" totalPrice: $"+totalPrice+" payment: $"+paymentStringified+" discountCode: "+discountCode+" drink: "+drink+" sauceAddings: "+sauceAddingsStringified+" frenchFries: "+frenchFries;
	}
}
