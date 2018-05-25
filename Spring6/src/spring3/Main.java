package spring3;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
    	
    	try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationContextConfig.class)) {
            
    		Thread.sleep(1500);
    		
    		System.out.println();
    		Client client1 = ac.getBean("client1", Client.class);
    		Client client2 = ac.getBean("client2", Client.class);
    		
    		System.out.println();
    		System.out.println(client1);
    		System.out.println(client2);
    		System.out.println("client1 instance == client2 instance ? "+(client1==client2?"YES! Singleton Scope!\n":"NO! Prototype Scope!\n"));
    		
    		client1.destroy();
    		client2.destroy();
            
    		System.out.println();
            Thread.sleep(1500);
        }
    }
}
