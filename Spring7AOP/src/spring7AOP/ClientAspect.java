package spring7AOP;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ClientAspect {
//	@Pointcut("execution(public void spring7AOP.ClientPrinter.printClient(Client...))")
	@Pointcut("execution(* *.*.printClient(..))")
	private void printClientPointCut() {}
	@Pointcut("execution(* *.*.getClientList(..))")
	private void getClientListPointCut() {}
	@Pointcut("execution(* *.*.findClient(..))")
	private void findClientPointCut() {}
//	@Before	("execution(* *.*.printClient(..))")
	@Before	("printClientPointCut()")
	public void beforePrintClient(JoinPoint joinPoint) {
		String matchingMethodSignature =  joinPoint.getSignature().toShortString();
		Object[] matchingArgsArray = (Object[])joinPoint.getArgs()[1]; //getArgs(), in this case, returns an array of arrays, with two elements, which are the boolean flag (for throwing the Exception) and the array with all Client args passed. As done here, getting that Client array, and downcasting it from a general Object to Object[], one can latter get each Object toString and display in a List<String> list, for instance... showing the toString of each Client arg... each Client toString, in this case.
		List<String> matchingArgsToStringList = Arrays.asList(matchingArgsArray).stream().map(Object::toString).collect(Collectors.toList());
		System.out.println("AOP @Before - signature: "+matchingMethodSignature+" args:"+matchingArgsToStringList);
	}
	@AfterReturning	(pointcut="getClientListPointCut()", returning="result")
	public void afterReturningGetClientList(JoinPoint joinPoint, List<Client> result) {
		String matchingMethodSignature =  joinPoint.getSignature().toShortString();
		Object[] matchingArgsArray = (Object[])joinPoint.getArgs()[1];
		List<String> matchingArgsToStringList = Arrays.asList(matchingArgsArray).stream().map(Object::toString).collect(Collectors.toList());
		System.out.println("AOP @AfterReturning - signature: "+matchingMethodSignature+" args:"+matchingArgsToStringList);
		System.out.println("At @Aspect: Return result: "+result);
	}
	@AfterThrowing(pointcut="printClientPointCut()", throwing="throwing")
	public void afterThrowingPrintClient(JoinPoint joinPoint, Throwable throwing) {
		String matchingMethodSignature =  joinPoint.getSignature().toShortString();
		Object[] matchingArgsArray = (Object[])joinPoint.getArgs()[1];
		List<String> matchingArgsToStringList = Arrays.asList(matchingArgsArray).stream().map(Object::toString).collect(Collectors.toList());
		System.out.println("AOP @AfterThrowing - signature: "+matchingMethodSignature+" args:"+matchingArgsToStringList);
		System.out.println("At @Aspect: Throwing: "+throwing);
	}
	@After	("getClientListPointCut()")
	public void afterGetClientList(JoinPoint joinPoint) {
		String matchingMethodSignature =  joinPoint.getSignature().toShortString();
		Object[] matchingArgsArray = (Object[])joinPoint.getArgs()[1];
		List<String> matchingArgsToStringList = Arrays.asList(matchingArgsArray).stream().map(Object::toString).collect(Collectors.toList());
		System.out.println("AOP @After(Finally) - signature: "+matchingMethodSignature+" args:"+matchingArgsToStringList);
	}
	@Around	("findClientPointCut()")
	public void aroundFindClient(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("Before method call:");
		String matchingMethodSignature =  proceedingJoinPoint.getSignature().toShortString();
		Client matchingSingleArg = (Client)proceedingJoinPoint.getArgs()[1];
		System.out.println("AOP @Around - signature: "+matchingMethodSignature+" arg:"+matchingSingleArg);
		try {
			System.out.println("Proceeding method call...");
			Client resultClient = (Client)proceedingJoinPoint.proceed();
			System.out.println("Successfull method call!");
			System.out.println("Return result: "+resultClient);
		} catch (Throwable e) {
			System.out.println("At @Aspect: "+e.getMessage()+". Interrupting this Exception - not rethrowing to the Main!"); //if rethrowing to the Main is desired, just do so!
			System.out.println("Method call not sucessfull!");
		}
	}
}
