package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_h")
public class Letter_H implements Letter_Interface{
	@Value("${letter.8}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
