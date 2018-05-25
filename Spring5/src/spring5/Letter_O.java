package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_o")
public class Letter_O implements Letter_Interface{
	@Value("${letter.15}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
