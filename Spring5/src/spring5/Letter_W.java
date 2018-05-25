package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_w")
public class Letter_W implements Letter_Interface{
	@Value("${letter.23}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
