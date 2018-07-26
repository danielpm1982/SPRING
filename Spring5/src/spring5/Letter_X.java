package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_x")
public class Letter_X implements Letter_Interface{
	@Value("${letter.24}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
