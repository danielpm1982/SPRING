package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_r")
public class Letter_R implements Letter_Interface{
	@Value("${letter.18}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
