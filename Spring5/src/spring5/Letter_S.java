package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_s")
public class Letter_S implements Letter_Interface{
	@Value("${letter.19}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
