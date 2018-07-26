package spring7AOP;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
    	
    	try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationContextConfig.class)) {
            
    		Thread.sleep(1500);
    		ClientPrinter clientPrinter = ac.getBean("clientPrinter", ClientPrinter.class);
    		Logger logger = Logger.getLogger("ClientPrinter.class");
    		Client client1 = ac.getBean("client1", Client.class);
    		Client client2 = ac.getBean("client2", Client.class);
    		
    		logger.info("\ntesting pointCut 1...");
    		try {
    			clientPrinter.getClientList(false, client1, client2); //--> testing @AfterReturning (shows the return if boolean flag eq false) and @After(Finally) (either exception occurs or not)
    		} catch (Exception e) {
				logger.info("At Main: "+e.getMessage());
			} finally {
				logger.info("At Main Finally!");
			}
    		
    		logger.info("\ntesting pointCut 2...");
			try {
				clientPrinter.printClient(true, client1, client2); //--> testing @Before and @AfterThrowing (shows the throwing if boolean flag eq true)
			} catch (Exception e) {
				logger.info("At Main: "+e.getMessage());
			} finally {
				logger.info("At Main Finally!");
			}
    		
    		logger.info("\ntesting pointCut 3...");
			try {
				clientPrinter.findClient(false, client1); //--> testing @Around (shows the return if boolean flag eq false)
			} catch (Exception e) {
				logger.info("At Main: "+e.getMessage());
			} finally {
				logger.info("At Main Finally!");
			}
    		
    		logger.info("\nclient1 instance == client2 instance ? "+(client1==client2?"YES! Singleton Scope!\n":"NO! Prototype Scope!\n"));
    		
    		client1.destroy();
    		client2.destroy();
            
    		logger.info("\n");
            Thread.sleep(1500);
        }
    }
}


/*
This 2nd version of Main is only to use the same logger for all outputs as a way of avoiding eventual 
inconsistencies with the order of the messages. The same would have to be done at all outputs of the project,
using one single and same logger output ('ClientPrinter.class' one, for instance).  
 */
