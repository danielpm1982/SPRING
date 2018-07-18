package spring7AOP;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
    	
try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationContextConfig.class)) {
            
    		Thread.sleep(1500);
    		ClientPrinter clientPrinter = ac.getBean("clientPrinter", ClientPrinter.class);
    		Client client1 = ac.getBean("client1", Client.class);
    		Client client2 = ac.getBean("client2", Client.class);
    		
    		System.out.println("\ntesting pointCut 1...");
    		try {
    			clientPrinter.getClientList(false, client1, client2); //--> testing @AfterReturning (shows the return if boolean flag eq false) and @After(Finally) (either exception occurs or not)
    		} catch (Exception e) {
				System.out.println("At Main: "+e.getMessage());
			} finally {
				System.out.println("At Main Finally!");
			}
    		
    		System.out.println("\ntesting pointCut 2...");
			try {
				clientPrinter.printClient(true, client1, client2); //--> testing @Before and @AfterThrowing (shows the throwing if boolean flag eq true)
			} catch (Exception e) {
				System.out.println("At Main: "+e.getMessage());
			} finally {
				System.out.println("At Main Finally!");
			}
    		
    		System.out.println("\ntesting pointCut 3...");
			try {
				clientPrinter.findClient(false, client1); //--> testing @Around (shows the return if boolean flag eq false)
			} catch (Exception e) {
				System.out.println("At Main: "+e.getMessage());
			} finally {
				System.out.println("At Main Finally!");
			}
    		
    		System.out.println("\nclient1 instance == client2 instance ? "+(client1==client2?"YES! Singleton Scope!\n":"NO! Prototype Scope!\n"));
    		
    		client1.destroy();
    		client2.destroy();
            
    		System.out.println();
            Thread.sleep(1500);
        }
    }
}


/*
This is the same Spring6 sample app, added AOP and an Aspect Class with all Spring @Advices
for 3 different pointCuts matched at the ClientPrinter class, which, in turn, has business methods 
responsible for printing, getting and finding the Client objects (using simulation), over which 
the Aspect will be called. The target-object class (ClientPrinter) is set as @Component. The 
Configuration class is set with @Configuration, @ComponentScan and @EnableAspectJAutoProxy. The Aspect 
class with the @Aspect annotation, as well with the aspect methods - with each respective Advice annotation,
and pointCut expression as attribute or refactored as a reuseable @Pointcut method. And, at the Main, 
the config class is loaded, and the beans are got (instantiated and with its dependencies already injected), 
including the Aspect bean, whose Advices will be called according to its definitions, each time any matching 
method is called on any matching object with a @Component marked class (in this case, only the ClientPrinter 
class will match all three pointCuts). This is a simple example of using AOP for console Spring apps.
 */
