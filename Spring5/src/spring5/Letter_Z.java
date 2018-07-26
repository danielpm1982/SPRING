package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_z")
public class Letter_Z implements Letter_Interface{
	@Value("${letter.26}")
	private String letter;
	@Override
	public String show() {
		return letter;
	}
}
