package spring7AOP;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ClientAspect {
	@Before	("execution(public void printClient(Client...))")
	public void beforePrintClientAdvice() {
		System.out.println("----------------------------------------");
		System.out.println("AOP @Aspect/@Before Advice/pointCut: printClient(Client...)");
	}
	@After	("execution(public void printClient(Client...))")
	public void afterPrintClientAdvice() {
		System.out.println("AOP @Aspect/@After Advice/pointCut: printClient(Client...)");
		System.out.println("AOP aspects successfully executed!");
		System.out.println("----------------------------------------");
	}
}
