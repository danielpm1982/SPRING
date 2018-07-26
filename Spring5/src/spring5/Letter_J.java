package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_j")
public class Letter_J implements Letter_Interface{
	@Value("${letter.10}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
