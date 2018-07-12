package spring7AOP;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
    	
    	try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationContextConfig.class)) {
            
    		Thread.sleep(1500);
    		
    		System.out.println();
    		Client client1 = ac.getBean("client1", Client.class);
    		Client client2 = ac.getBean("client2", Client.class);
    		
    		System.out.println();
    		ClientPrinter clientPrinter = ac.getBean("clientPrinter", ClientPrinter.class);
    		clientPrinter.printClient(client1, client2);
    		System.out.println("client1 instance == client2 instance ? "+(client1==client2?"YES! Singleton Scope!\n":"NO! Prototype Scope!\n"));
    		
    		client1.destroy();
    		client2.destroy();
            
    		System.out.println();
            Thread.sleep(1500);
        }
    }
}


/*
This is the same Spring6 sample app, added AOP and an Aspect with two Advices (@Before and @After) 
for the pointCut "printClient(Client...)" of the clientPrinter bean, which, in turn, has a class
responsible merely to print (show) the Client objects, with a business method over which the Aspect
will be called. The target-object class (ClientPrinter) is set as @Component. The Configuration
class is set with @Configuration, @ComponentScan and @EnableAspectJAutoProxy. The Aspect class
with the @Aspect annotation, as well with the aspect methods - with each respective Advice annotation
and pointCut expression as a parameter. And, at the Main, the config class is loaded, and the beans
are got (instantiated and with its dependencies already injected), including the Aspect bean, whose 
Advices will be called according to its definitions, each time printClient(Client... client) method
is called on any object with a @Component marked class (in this case, only the ClientPrinter class).
 */
