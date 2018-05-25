package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_g")
public class Letter_G implements Letter_Interface{
	@Value("${letter.7}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
