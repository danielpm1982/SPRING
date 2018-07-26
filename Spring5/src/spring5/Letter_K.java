package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_k")
public class Letter_K implements Letter_Interface{
	@Value("${letter.11}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
