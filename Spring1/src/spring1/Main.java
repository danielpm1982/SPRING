package spring1;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        
    	//full XML Config approach.
    	//inversion of control and dependency injection using XML, through constructor or setters, and from other beans, literals or properties archive.
    	//scope defining (singleton and prototype), and init() and destroy() callbacks for each bean, automatically called by the ApplicationContext.
    	
    	try (ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring1/applicationContext.xml")) {
            Animal animal1 = ac.getBean("animal",Animal.class);
            System.out.println("Animal animal1 instance:");
            System.out.println(animal1);
            System.out.println(animal1.move());
            System.out.println(animal1.makeSound()+"\n");

            System.out.println("Animal animal2 instance:");
            Animal animal2 = ac.getBean("animal",Animal.class);
            System.out.println(animal2);
            System.out.println(animal2.move());
            System.out.println(animal2.makeSound());
            System.out.println();
            System.out.println("animal1 instance == animal2 instance ? "+(animal1==animal2?"YES! Singleton Scope!\n":"NO! Prototype Scope!\n"));
        }
    }
}
