package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_f")
public class Letter_F implements Letter_Interface{
	@Value("${letter.6}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
