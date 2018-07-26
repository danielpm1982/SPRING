package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_b")
public class Letter_B implements Letter_Interface{
	@Value("${letter.2}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
