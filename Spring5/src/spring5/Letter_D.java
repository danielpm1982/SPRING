package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_d")
public class Letter_D implements Letter_Interface{
	@Value("${letter.4}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
