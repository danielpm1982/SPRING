package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_t")
public class Letter_T implements Letter_Interface{
	@Value("${letter.20}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
