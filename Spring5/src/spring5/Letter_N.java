package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_n")
public class Letter_N implements Letter_Interface{
	@Value("${letter.14}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
