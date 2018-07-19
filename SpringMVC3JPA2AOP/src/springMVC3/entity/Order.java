package springMVC3.entity;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import springMVC3.helper.SandwichComposition;
import springMVC3.helper.SandwichPrice;
import springMVC3.validation.DiscountCodeValidator;

@Entity
@Table(name="scheme1.order")
@NamedQueries({
	@NamedQuery(name="Order.getAllOrders", query="from Order"),
	@NamedQuery(name="Order.getOrderById", query="select o from Order o where o.id=:id"),
	@NamedQuery(name="Order.getOrderBySSN", query="from Order o where o.SSN=:SSN"),
	@NamedQuery(name="Order.deleteOrder", query="delete from Order o where o.id=:id")
})
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private long id;
	@Column(name="client_name")
	@NotNull(message="You must type a client name!")
	@Size(min=1, message="At least one letter must be entered!")
	@Pattern(regexp="^[\\p{L} \\.\\-]+$", message="Invalid Name!")
	private String clientName;
	@Column(name="client_ssn")
	@NotNull(message="You must type a SSN!")
	@Min(value=1, message="The min number is: '000000001'!")
	@Max(value=999999999, message="The max number is: '999999999'!")
	private Long SSN;
	@Column(name="sandwich_name")
	@NotNull(message="You must select one of the options!")
	@Size(min=1, message="At least one option must be selected!")
	private String sandwichName;
	@Column(name="combo_size")
	@NotNull(message="You must select one of the options!")
	@Size(min=1, message="At least one option must be selected!")
	private String comboSize;
	private String sandwichComposition;
	@Column(name="total_price")
	private BigDecimal totalPrice;
	@Column(name="drink")
	@NotNull(message="You must select one of the options!")
	@Size(min=1, message="At least one option must be selected!")
	private String drink;
	@Transient
	@NotNull(message="You must select one of the options!")
	@Size(min=1, message="At least one option must be selected!")
	private String[] sauceAddings;
	@Column(name="sauce_addings")
	private String sauceAddingsStringified;
	@Column(name="french_fries")
	@NotNull(message="You must check one of the options!")
	@Size(min=1, message="At least one option must be checked!")
	private String frenchFries;
	@Transient
	@NotNull(message="You must select one of the options!")
	@Size(min=1, message="At least one option must be selected!")
	private String[] payment;
	@Column(name="payment")
	private String paymentStringified;
	@Column(name="discount_code")
	@DiscountCodeValidator(value= {"A","B","C","D"}, message="This value must start with 'A' or 'B' or 'C' or 'D' + discount percent value (e.g. 'A20' = 20% discount). After the first char (the letter char), only two or three other chars are allowed for the number (from 10 to 100), which must end with '0' - counting by tens.")
//	@DiscountCodeValidator
	private String discountCode;
	@Column(name="dateTime")
	private ZonedDateTime dateTime;
	public Order() {
		dateTime = ZonedDateTime.now();
	}
	public long getId() {
		return id;
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
	public String getDateTime() {
		return dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.LONG));
	}
	@Override
	public String toString() {
		return "clientName: "+clientName+" SSNCardNo: "+SSN+" sandwichName: "+sandwichName+" comboSize: "+comboSize+" sandwichComposition: "+sandwichComposition+" totalPrice: $"+totalPrice+" payment: "+paymentStringified+" discountCode: "+discountCode+" drink: "+drink+" sauceAddings: "+sauceAddingsStringified+" frenchFries: "+frenchFries;
	}
}
