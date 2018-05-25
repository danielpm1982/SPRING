package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_e")
public class Letter_E implements Letter_Interface{
	@Value("${letter.5}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
