package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_u")
public class Letter_U implements Letter_Interface{
	@Value("${letter.21}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
