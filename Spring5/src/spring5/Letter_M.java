package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_m")
public class Letter_M implements Letter_Interface{
	@Value("${letter.13}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
