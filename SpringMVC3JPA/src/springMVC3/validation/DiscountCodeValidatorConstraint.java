package springMVC3.validation;
import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DiscountCodeValidatorConstraint implements ConstraintValidator<DiscountCodeValidator, String>{
	private String[] discountCodeValidatorValueArray;
	@Override
	public void initialize(DiscountCodeValidator discountCodeValidator) {
		discountCodeValidatorValueArray=discountCodeValidator.value();
	}
	@Override
	public boolean isValid(String userInput, ConstraintValidatorContext constraintValidatorContext) {
		for(String discountCodeValidatorValue : discountCodeValidatorValueArray) {
			if(checkInput(userInput, discountCodeValidatorValue)) {
				return true; //if the input matches ANY of the array discountCodeValidatorValues, when applied to the rules checked at checkInput() method, that user input is validated!
			}
		}
		return false;
	}
	private boolean checkInput(String userInput, String startingChar) {
		if(userInput!=null) {
			boolean b1 = userInput.startsWith(startingChar);
			boolean b2 = userInput.substring(1).length()==2||userInput.substring(1).length()==3; 
			boolean b2a = true;
			if(userInput.substring(1).length()==3) {
				b2a=userInput.substring(1).equals("100");
			}
			boolean b3 = checkIfStringRepresentsNumber(userInput.substring(1));
			boolean b4 = userInput.substring(userInput.length()-1).equals("0");
			return b1&&b2&&b2a&&b3&&b4;
		} else {
			return true;
		}
	}
	private boolean checkIfStringRepresentsNumber(String stringToCheck){
		List<Character> numberCharList = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
		for(char c : stringToCheck.toCharArray()) {
			if(!numberCharList.contains(Character.valueOf(c))) {
				return false;
			}
		}
		return true;
	}
}

/*
This Constraint class will implement the java general ConstraintValidator interface and will use
the DiscountCodeValidator, whose interface was defined before, for getting the values passed on the
Annotation by the user (or use the default one) that must be matched by the input value passed by 
the user at the html input field, according to the validation at isValid() method. If the user input 
matches the validation logic defined, against ANY of the the passed Annotation values, then it returns 
true, and is validated, otherwise, it returns false and does not validade... and the error message is 
displayed at the view. In the case the input value is null, it's also validated, as it is an optional 
input at the html form.
The validation will check if a discountCode starts with a given letter ("D" for default) 
and if the rest of the text consists of only two or three number characters representing the percent of 
discount being given. For example: the code 'D90' would validade because is starts with the default 'D' 
and ends up with only two other characters that represent the 90% discount that will be gained by the user. 
If there are three number characters, check if it is 100, the only possible value for 3-digit numbers here.
It also checks if the two characters are number string representations (and not letters) and if the last one 
is 0, as the discounts are from 10 to 100, counting by 10s.
If, instead of multiple values, only one single value is used for comparing with the input (only one letter), 
then, other than an array for the value attribute, at the DiscountCodeValidator @interface, and for 
discountCodeValidatorValue, here in this class, a String type would be used instead. An String[] type has
been used only to show how to set multiple possible values to have the input compared with.
*/
