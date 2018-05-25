package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_p")
public class Letter_P implements Letter_Interface{
	@Value("${letter.16}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
