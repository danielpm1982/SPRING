package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_q")
public class Letter_Q implements Letter_Interface{
	@Value("${letter.17}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
