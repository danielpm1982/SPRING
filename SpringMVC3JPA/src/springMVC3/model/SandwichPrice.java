package springMVC3.model;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SandwichPrice {
	public static BigDecimal getPrice(String sandwichName, String size) {
		if(validadeNameAndSizeAsEnumType(sandwichName, size)) {
			switch(SandwichType.valueOf(sandwichName)) {
				case BIGMEAL:
					return getPrice(size, new double[]{3.5,4.5,5.5,6.5});
				case CHEESEMEAL:
					return getPrice(size, new double[]{1.5,2.5,3.5,4.5});
				case CHICKENMEAL:
					return getPrice(size, new double[]{1.5,2.5,3.5,4.5});
				case BBQMEAL:
					return getPrice(size, new double[]{2.5,3.5,4.5,5.5});
				case FISHMEAL:
					return getPrice(size, new double[]{2.3,3.2,4.7,7.2});
				default:
					return new BigDecimal("0");
			}
		} else {
			return new BigDecimal("0");
		}
	}
	public static BigDecimal getPrice(String sandwichName, String size, String discountCode) {
		if(validadeDiscountCode(discountCode)) {
			BigDecimal discountCodeFactor;
			switch(DiscountType.valueOf(discountCode).toString().substring(1)) { //considers only the chars for the number, not the initial letter
				case "10":
					discountCodeFactor=new BigDecimal(0.9);
					break;
				case "20":
					discountCodeFactor=new BigDecimal(0.8);
					break;
				case "30":
					discountCodeFactor=new BigDecimal(0.7);
					break;
				case "40":
					discountCodeFactor=new BigDecimal(0.6);
					break;
				case "50":
					discountCodeFactor=new BigDecimal(0.5);
					break;
				case "60":
					discountCodeFactor=new BigDecimal(0.4);
					break;
				case "70":
					discountCodeFactor=new BigDecimal(0.3);
					break;
				case "80":
					discountCodeFactor=new BigDecimal(0.2);
					break;
				case "90":
					discountCodeFactor=new BigDecimal(0.1);
					break;
				case "100":
					discountCodeFactor=new BigDecimal(0);
					break;
				default:
					discountCodeFactor=new BigDecimal(1);
			}
			return getPrice(sandwichName, size).multiply(discountCodeFactor).setScale(2, RoundingMode.CEILING);
		}else {
			return getPrice(sandwichName, size);
		}
	}
	private static BigDecimal getPrice(String size, double[] sizePriceArray) {
		switch(SizeType.valueOf(size)) {
			case SMALL:
				return new BigDecimal(sizePriceArray[0]).setScale(2, RoundingMode.CEILING);
			case MEDIUM:
				return new BigDecimal(sizePriceArray[1]).setScale(2, RoundingMode.CEILING);
			case BIG:
				return new BigDecimal(sizePriceArray[2]).setScale(2, RoundingMode.CEILING);
			case ULTRA:
				return new BigDecimal(sizePriceArray[3]).setScale(2, RoundingMode.CEILING);
			default:
				return new BigDecimal("0");
		}
	}
	public static boolean validadeNameAndSizeAsEnumType(String name, String size) {
		boolean b1 = Arrays.asList(SandwichType.values()).stream().map(x->x.toString()).collect(Collectors.toList()).contains(name);
		boolean b2 = Arrays.asList(SizeType.values()).stream().map(x->x.toString()).collect(Collectors.toList()).contains(size);
		return b1&&b2;
	}
	public static boolean validadeDiscountCode(String discount) {
		return Arrays.asList(DiscountType.values()).stream().map(x->x.toString()).collect(Collectors.toList()).contains(discount);
	}
}
