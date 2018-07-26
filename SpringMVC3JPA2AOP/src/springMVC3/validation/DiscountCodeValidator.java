package springMVC3.validation;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=DiscountCodeValidatorConstraint.class)
@Target({ FIELD, METHOD })
@Retention(RUNTIME)
public @interface DiscountCodeValidator {
	public String[] value() default {"D"};
	public String message() default "This value must start with 'D' + discount percent value (e.g. 'D50' = 50% discount). After the first char (the letter char), only two or three other chars are allowed for the number (from 10 to 100), which must end with '0' - counting by tens.";
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {};
}

/*
For this @interface of the Annotation being created, a default value and message is set as the attributes of
the Annotation (whose values can be overriden by customized ones, if the user passes them when using the Annotation).
Groups and Payload are also set as attributes in case they're needed.
The Retention of this Annotation will last until the runtime period.
The Targets will be fields and methods.
The Constraint, with the Annotation business rules for validation, will be the DiscountCodeValidatorConstraint class. 
*/
