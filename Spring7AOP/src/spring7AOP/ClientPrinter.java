package spring7AOP;
import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class ClientPrinter {
	private final String title;
	public ClientPrinter(String title) {
		this.title=title;
	}
	public void printClient(Client... client) {
		System.out.println(title);
		Arrays.asList(client).forEach(System.out::println);
	}
}
