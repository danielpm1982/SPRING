package spring4;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
    	try (ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring4/applicationContext.xml")) {
    		System.out.println();
    		ac.getBean("header", Header.class).getFieldsAndValues().entrySet().forEach(x->System.out.println(x.getKey()+": "+x.getValue()));
    		System.out.println();
    		System.out.println("Choose a secret word to guess by typing an integer from 1 to 15:");
    		Scanner s = new Scanner(System.in);
    		WordGuess game = ac.getBean("word"+s.nextLine(), WordGuess.class);
    		game.play();
        }
    }
}
