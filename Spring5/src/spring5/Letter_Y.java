package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_y")
public class Letter_Y implements Letter_Interface{
	@Value("${letter.25}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
