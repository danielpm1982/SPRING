package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_i")
public class Letter_I implements Letter_Interface{
	@Value("${letter.9}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
