// TODO: comment this file

import acm.program.*;
import acm.util.*;
import java.io.*;    // for File
import java.util.*;  // for Scanner

public class Hangman extends HangmanProgram {

	
	public void run() {
		//Displays the introduction of the game by the function "intro"
		intro();
		//prompt the user for the dictionary filename
		String dictionaryFileName = promptUserForFile("Dictionary file name? ", "res");
		String secretWord = getRandomWord(dictionaryFileName);
		//initiate numbers for statsa
		int gamesCount = 1;
		int best = 0;
		int gamesWon = 0;
		//main game
		int guessesLeft = playOneGame(secretWord);
		//decide whether to play again
		while (readBoolean("Play again (Y/N)?", "Y", "N")){
			gamesCount += 1;
			secretWord = getRandomWord(dictionaryFileName);
			guessesLeft = playOneGame(secretWord);
			if (guessesLeft > 0){
				gamesWon += 1;
			}
			if (guessesLeft >= best){
				best = guessesLeft;
			}
		}
		
		//displays the stats 
		println();
		stats(gamesCount, gamesWon, best);

	}
	
	//Displays the introduction of the game
	
	private void intro() {
		println("CS 106A Hangman!");
		println("I will think of a random word.");
		println("You'll try to guess its letters.");
		println("Every time you guess a letter");
		println("that isn't in my word, a new body");
		println("part of the hanging man appears.");
		println("Guess correctly to avoid the gallows!");
		println();
	}
	
	/*Displays hint; asks the user to type a valid guess;
	 * figure our if a guess is in secret word or not;
	 * keep track of the number of guesses remaining;
	 * determine whether the game has ended (guessed all the letters)
	 * or run out of guesses.
	 * The input for this method is the secret word.
	 */
	
	private int playOneGame(String secretWord) {
		//initiate numbers 
		int guessesLeft = 8;
		String hint = "";
		for (int i=0; i<secretWord.length(); i++){
			hint += "-";
		}
		boolean keepAsking = true;
		String yourGuesses = "";
		String guessedLetters = "";
		String dash = "-";
		do {
			println("Secret word :"+hint);
			println("Your guesses: "+yourGuesses);
			println("Guesses left: "+guessesLeft);
			char inputGuess=readGuess(guessedLetters);
			yourGuesses += inputGuess;
			int j=0;
			for (int i=0; i<secretWord.length(); i++){
				if (inputGuess == secretWord.charAt(i)){
					println("Correct!"); 
					guessedLetters += inputGuess;
					hint = createHint(secretWord, guessedLetters);
					break;
				}else{
					j+=1;
				}
			} 
			
			if (j==secretWord.length()){
				println("Incorrect!");
				guessesLeft -= 1;
			}
			
			int checkComplete = hint.indexOf(dash);
			if (checkComplete==-1){
				println("You win! My word was \""+secretWord+"\".");
				keepAsking = false;
			}
			
			if (guessesLeft==0){
				println("No guesses left.");
				keepAsking = false;
			}
			//displays the ASCII Art
			displayHangman(guessesLeft);
			
		} while (keepAsking);
		return guessesLeft;
	}
	
	
	/* TODO: This method creates and returns a hint string based on the secreatWord and 
	*gessedLetters. The guessedLetters will be put on the correct position if they are 
	*in the secretWord. The other part of the secretWord will be "-". If none of the guessedWord
	*is correct, it will display all "-" based on the number of letters in the secretWord. Assumes
	*all the input letters are in uppercase.
	*/
	
	private String createHint(String secretWord, String guessedLetters) {
		//get the length of two inputs
		int secretWordLength = secretWord.length();
		int guessedLettersLength = guessedLetters.length();
		
		//create an empty string
		String comparedResult ="";
		
		//use double for loop to compare letter by letter
		for (int i=0; i<secretWordLength; i++){
			boolean notFound = true;
			for (int j=0; j<guessedLettersLength; j++){
				if(secretWord.charAt(i)!=guessedLetters.charAt(j)){
					//skip the actions below and continue to the next inner for loop 
					continue;
				}
				comparedResult += secretWord.charAt(i);
				notFound = false;
				//break the inner for loop, so that if there is repeat letter in guessedLetters it won't be compared twice
				break;  
			}
			if(notFound){
				comparedResult += "-";
			}
		}
		
		return comparedResult;
	}

	
	/* TODO: Prompts the user to type a single letter to guess,  and return the uppercase char
	 * The input parameter is a string called guessedLetters. If the user has not types in any
	 * letters it will be an empty string. The methods should re-prompts the user till they type
	 * a string that is a single letter from A-Z, case-insensitive, not has been guessed before.
	 */
	private char readGuess(String guessedLetters) {
		String newLetter = "";
		int lengthGuessedLetters = guessedLetters.length();
		//create an empty char at the beginning/ upper scope which can be returned at the end
		char upperTyped='\0';
		boolean correctInput=false;
		//use to while loop to keep asking input unless the input is correct
		while (correctInput==false){
			newLetter = readLine("Your guess?");
			int lengthTyped = newLetter.length();
			//print error message is the typed in is not one letter
			if (lengthTyped != 1){
				println("Type a single letter from A-Z.");
			}else{
				//change string to character 
				char charTyped = newLetter.charAt(0);
				//print error message if typed is not letter
				if (!Character.isLetter(charTyped)){
					println("Type a single letter from A-Z.");
				}else{
					//change lowercase to uppercase if needed
					if (Character.isLowerCase(charTyped)){
						upperTyped = Character.toUpperCase(charTyped);
					}else{
						upperTyped = charTyped;
					}
				
					//check whether the upperTyped is in the guessedLetter
					int k=0;
					for (int j=0; j<lengthGuessedLetters; j++){
						if (upperTyped == guessedLetters.charAt(j)){
							println("You already guessed that letter.");
							break;
						}else{
							k++;
						}
					}
				
					if (k==lengthGuessedLetters){
						correctInput = true;
					}
				}				
			}		
		}		
		return upperTyped;	
	}
	
	/* Displays the hanging man on each turn based on the  guessLeft input. There are 9 
	 * text files named as display0.txt to display9.txt. These files contain the text that 
	 * should be displayed each turn when the player has 0 guesses remaining through 8 guesses
	 * remaining. All the text files are under res/ folder. The contents of the file should
	 * be displayed on the console or the second console to the right of the main console.
	 * 
	 * 
	 */
	private void displayHangman(int guessesLeft) {
		//removes any text from the secondary console
		canvas.clear();
		// open the correct file for reading.
		try{
			Scanner input = new Scanner(new File("res","display"+guessesLeft+".txt"));
			
			while (input.hasNextLine()){
				String part = input.nextLine();
				canvas.println(part);
			}
			input.close();
		} catch (FileNotFoundException ex){
			println("Error reading the file: "+ex);
		}
	}
	
	/* Displays the total number of games played; number of games won; 
	 * PCT of games won; and  the game that required the fewest guesses to
	 * complete. 
	 */
	private void stats(int gamesCount, int gamesWon, int best) {
		println("Overall statistics:");
		println("Games played: " + gamesCount);
		println("Games won: " + gamesWon);
		double percentWon = (double) gamesWon/gamesCount * 100;
		println("Win percent: " + percentWon + "%");
		println("Best game: " + best + "guesses(es) remaining");
		println("Thanks for playing!");
	}
	

	
	/* Get a random word from the dictionary data files. The dictionary files starts with
	 * the number of word in the file, followed by actual word. Every word is in one line.
	 */
	private String getRandomWord(String filename) {
		//initiate a selectedWord
		String selectedWord = "";
		// gets the number of words in the file
		try{
			Scanner inputFile = new Scanner(new File(filename));
			int numberWords = inputFile.nextInt();
			//generate a random number between 1 to numberWords;
			int randomNumber = RandomGenerator.getInstance().nextInt(1, numberWords);
			for (int i=0; i<randomNumber; i++){
				selectedWord = inputFile.next();
			}
			inputFile.close();
		} catch (FileNotFoundException ex){
			println("Error reading the file: "+ex);
		}
		return selectedWord;
	}
	
	
}
