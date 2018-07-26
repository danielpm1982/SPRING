package spring5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("letter_a")
public class Letter_A implements Letter_Interface{
//	@Value("${letter.1}")
	private String letter;
//	public Letter_A(@Value("${letter.1}") String letter) {
//		this.letter=letter;
//	}
	@Override
	public String show() {
		return letter;
	}
	@Value("${letter.1}")
	public void setLetter(String letter) {
		this.letter = letter;
	}
}

//field, constructor or property injection - 3 options of injecting the value from the prop file.