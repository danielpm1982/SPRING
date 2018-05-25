package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_l")
public class Letter_L implements Letter_Interface{
	@Value("${letter.12}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
