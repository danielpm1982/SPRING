package springMVC3.aspect;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ControllerServiceDAOAspect {
	@Pointcut("execution(* *.controller.*.*(..))")
	private void controllerPointCut() {}
	@Pointcut("execution(* *.controller.*.initBinder(..))")
	private void controllerPointCutDoNot() {}
	@Pointcut("execution(* *.service.*.*(..))")
	private void servicePointCut() {}
	@Pointcut("execution(* *.dao.*.*(..))")
	private void daoPointCut() {}
	@Pointcut("controllerPointCut() && !controllerPointCutDoNot() || servicePointCut() || daoPointCut()")
	private void GeneralPointCut() {}
	@Before	("GeneralPointCut()")
	public void beforeMethodCall(JoinPoint joinPoint) {
		String matchingMethodSignature =  joinPoint.getSignature().toShortString();
		Object[] matchingArgArray = joinPoint.getArgs();
		List<String> matchingArgList = Arrays.asList(matchingArgArray).stream().map(Object::toString).collect(Collectors.toList());
		String matchingSingleArgString = (!matchingArgList.isEmpty()?matchingArgList.toString():"null arg");
		System.out.println("AOP @Before - signature: "+matchingMethodSignature+" arg:"+matchingSingleArgString);
	}
	@AfterReturning	(pointcut="GeneralPointCut()", returning="result")
	public void afterReturningFromMethodCall(JoinPoint joinPoint, Object result) {
		String matchingMethodSignature =  joinPoint.getSignature().toShortString();
		Object[] matchingArgArray = joinPoint.getArgs();
		List<String> matchingArgList = Arrays.asList(matchingArgArray).stream().map(Object::toString).collect(Collectors.toList());
		String matchingSingleArgString = (!matchingArgList.isEmpty()?matchingArgList.toString():"null arg");
		System.out.println("AOP @AfterReturning - signature: "+matchingMethodSignature+" arg:"+matchingSingleArgString);
		System.out.println("At @Aspect: Return result: "+(result!=null?result:"null result!"));
	}
}

/* 
 Only an example of Aspect with @Before and @AfterReturning Advices for the united pointCut above. 
 Shows the moment before and after all method calls for the packages above, along  with the signature, 
 arg and return of the method when they exist.
 Other Advices as @AfterThrowing, @After(Finally) and @Around could be tested here if Exception handling 
 was added to the targeted classes.
*/
