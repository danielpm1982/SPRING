package spring5;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
    	
    	try (ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring5/applicationContext.xml")) {
            
    		Thread.sleep(2500); //just for not mixing up console outputs...
    		System.out.println();
    		
    		//Example of individual bean instantiation and dependency injection:
    		
    		Letter_Interface letter_a = ac.getBean("letter_a", Letter_A.class);
    		System.out.println("Letter "+letter_a.show()+"\n- individually instantiated and with dependencies injected!");
    		
    		System.out.println();
    		
    		//Compound bean instantiation and dependency injection:
    		
            All_Alphabet_Interface all_letters = ac.getBean("all_alphabet", All_Alphabet.class);
            System.out.println(all_letters.showAll()+"\n- collectively instantiated and injected at another bean (All_Alphabet bean), for compound bean test!");
            
            System.out.println();
            
            //Printing the Set Collection of all Alphabet_Interface letters
            all_letters.getLetterSet().forEach(x->System.out.println(x+" "));
            
            System.out.println();
            Thread.sleep(1000); //just for not mixing up console outputs...
        }
    }
}
