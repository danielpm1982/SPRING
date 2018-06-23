package springMVC3.model;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Order.class)
public class Order_ {
    public static volatile SingularAttribute<Order,Long> id;
    public static volatile SingularAttribute<Order,String> clientName;
    public static volatile SingularAttribute<Order,Long> SSN;
    public static volatile SingularAttribute<Order,String> sandwichName;
    public static volatile SingularAttribute<Order,String> comboSize;
    public static volatile SingularAttribute<Order,String> sandwichComposition;
    public static volatile SingularAttribute<Order,BigDecimal> totalPrice;
    public static volatile SingularAttribute<Order,String> drink;
    public static volatile SingularAttribute<Order,String> sauceAddingsStringified;
    public static volatile SingularAttribute<Order,String> frenchFries;
    public static volatile SingularAttribute<Order,String> paymentStringified;
    public static volatile SingularAttribute<Order,String> discountCode;
    public static volatile SingularAttribute<Order,ZonedDateTime> dateTime;
}
