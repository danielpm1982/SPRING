package spring3;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
    	
    	//Java configuration class approach. Creating Dog and its dependencies manually at the config java class as well as injecting them into Dog bean.
    	//inversion of control and dependency injection using Annotations. Also Scope, init() - postConstruct - and destroy() - preDestroy - lifecycle methods' test.
    	//in the case of singleton scope, the init() and destroy() methods are executed the beggining and at the end of the execution (beans' instanciation and destroying).
    	//in the case of prototype, though, the destroy() is NOT executed at all, and the init() is executed only when getting each different reference to that individual bean instance.
    	
    	try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationContextConfig.class)) {
            
    		Thread.sleep(6500); //just for not mixing up console outputs...
    		System.out.println();
    		
    		AnimalInterface animal1A = ac.getBean("dog",AnimalInterface.class);
            System.out.println(animal1A);
            System.out.println(animal1A.move());
            System.out.println(animal1A.makeSound()+"\n");
            
            AnimalInterface animal1B = ac.getBean("dog",AnimalInterface.class);
            System.out.println(animal1B);
            System.out.println(animal1B.move());
            System.out.println(animal1B.makeSound()+"\n");
            
            System.out.println("animal1A instance == animal1B instance ? "+(animal1A==animal1B?"YES! Singleton Scope!\n":"NO! Prototype Scope!\n"));
            
            AnimalInterface animal2A = ac.getBean("cat",AnimalInterface.class);
            System.out.println(animal2A);
            System.out.println(animal2A.move());
            System.out.println(animal2A.makeSound()+"\n");
            
            AnimalInterface animal2B = ac.getBean("cat",AnimalInterface.class);
            System.out.println(animal2B);
            System.out.println(animal2B.move());
            System.out.println(animal2B.makeSound()+"\n");

            System.out.println("animal2A instance == animal2B instance ? "+(animal2A==animal2B?"YES! Singleton Scope!\n":"NO! Prototype Scope!\n"));
            
            AnimalInterface animal3A = ac.getBean("fish",AnimalInterface.class);
            System.out.println(animal3A);
            System.out.println(animal3A.move());
            System.out.println(animal3A.makeSound()+"\n");
            
            AnimalInterface animal3B = ac.getBean("fish",AnimalInterface.class);
            System.out.println(animal3B);
            System.out.println(animal3B.move());
            System.out.println(animal3B.makeSound()+"\n");
            
            System.out.println("animal3A instance == animal3B instance ? "+(animal3A==animal3B?"YES! Singleton Scope!\n":"NO! Prototype Scope!\n"));
            
            Thread.sleep(2000); //just for not mixing up console outputs...
        }
    }
}
