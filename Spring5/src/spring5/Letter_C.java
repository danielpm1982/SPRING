package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_c")
public class Letter_C implements Letter_Interface{
	@Value("${letter.3}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
