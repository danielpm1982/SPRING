package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_v")
public class Letter_V implements Letter_Interface{
	@Value("${letter.22}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
