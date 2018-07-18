package spring7AOP;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ClientPrinter {
	private final String title;
	public ClientPrinter(String title) {
		this.title=title;
	}
	public void printClient(boolean throwException, Client... client) throws Exception{
		System.out.println(title);
		Arrays.asList(client).forEach(System.out::println);
		if(throwException) {
			throw new Exception("@afterThrowingTestingException");
		}
	}
	public List<Client> getClientList(boolean throwException, Client... client) throws Exception{
		if(throwException) {
			throw new Exception("@afterTestingException");
		}
		return Arrays.asList(client);
	}
	public Client findClient(boolean throwException, Client client) throws Exception{
		if(throwException) {
			throw new Exception("@aroundTestingException");
		}
		return client;
	}
}
