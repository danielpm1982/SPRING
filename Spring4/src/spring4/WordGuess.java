package spring4;
import java.util.Scanner;

public class WordGuess {
	private String wordToGuess;
	private String wordRevealed;
	private boolean gameOver;
	private int tryNo;
	private DifficultyType difficultyType;
	private int maxAttempts;
	private Scanner s;
	public WordGuess() {
	}
	public WordGuess(String wordToGuess) {
		this(wordToGuess, DifficultyType.VERY_EASY.name());
	}
	public WordGuess(String wordToGuess, String difficultyTypeString) {
		this.wordToGuess = wordToGuess.toUpperCase();
		this.difficultyType=DifficultyType.valueOf(difficultyTypeString);
		maxAttempts=((int)(wordToGuess.length()*difficultyType.getWeight()));
		updateWordRevealed(wordToGuess.length(), null);
		gameOver=false;
		tryNo=0;
		s = new Scanner(System.in);
	}
	public void setWordToGuess(String wordToGuess) {
		this.wordToGuess = wordToGuess;
	}
	public void setWordRevealed(String wordRevealed) {
		this.wordRevealed = wordRevealed;
	}
	private boolean isGameOver() {
		return gameOver;
	}
	public void play() {
		while(!isGameOver()) {
			System.out.println("Type a character and press <ENTER> to guess the word!");
			guessCharacter(s.nextLine().charAt(0));
		}
	}
	public void guessCharacter(Character characterToGuess) {
		characterToGuess=Character.toUpperCase(characterToGuess);
		if(tryNo<maxAttempts&&!gameOver&&wordToGuess.contains(characterToGuess.toString())) {
			tryNo++;
			System.out.println("RIGHT! '"+characterToGuess+"' DOES exist at this word!");
			updateWordRevealed(wordToGuess.length(), characterToGuess);
			if(!gameOver) {
				int remainingAttempts = maxAttempts-tryNo;
				if(remainingAttempts>0) {
					System.out.println("Attempts left: "+remainingAttempts+"!");
					System.out.println(wordRevealed);
				} else {
					System.out.println("Attempts left: "+remainingAttempts+"!");
					gameOver=true;
					System.out.println("Game Over!! Word is: "+wordToGuess+" You've guessed: "+wordRevealed+"! Guess attempts: "+tryNo+"!");
				}
			}
		} else if(tryNo<maxAttempts&&!gameOver&&!wordToGuess.contains(characterToGuess.toString())){
			tryNo++;
			System.out.println("WRONG! '"+characterToGuess+"' DOES NOT exist at this word!");
			int remainingAttempts = maxAttempts-tryNo;
			if(remainingAttempts>0) {
				System.out.println("Attempts left: "+remainingAttempts+"!");
				System.out.println(wordRevealed);
			} else {
				System.out.println("Attempts left: "+remainingAttempts+"!");
				gameOver=true;
				System.out.println("Game Over!! Word is: "+wordToGuess+" You've guessed: "+wordRevealed+"! Guess attempts: "+tryNo+" out of "+maxAttempts+"! (Difficulty: "+difficultyType.name()+")");
			}
		} else {
			System.out.println("Game is already Over!");
		}
	}
	private void updateWordRevealed(int wordLength, Character characterToReveal) {
		if(characterToReveal==null) {
			StringBuilder sb = new StringBuilder(wordLength);
			for (int i=0; i<wordLength; i++) {
				sb.append('*');
			}
			wordRevealed=sb.toString();
		} else {
			StringBuilder sb = new StringBuilder(wordRevealed);
			char[] wordToGuessArray = wordToGuess.toCharArray();
			for(int i=0;i<wordLength;i++) {
				if(wordToGuessArray[i]==characterToReveal) {
					sb.setCharAt(i, characterToReveal);
				}
			}
			wordRevealed=sb.toString();
			if(!wordRevealed.contains("*")) {
				gameOver=true;
				System.out.println("Game Over!! Word is: "+wordToGuess+" You've guessed: "+wordRevealed+"! Guess attempts: "+tryNo+" out of "+maxAttempts+"! (Difficulty: "+difficultyType.name()+")");
			}
		}
	}
}
