/*
 * File: DictionaryLookup.java
 * -----------------------
 * This is a program that reads an input file containing a series of pairs of
 * lines where the first line is a word, and thse second is its definition.
 * The program stores the word/definition pairs in a HashMap, and then prompts
 * the user to type a word, after which the program prints out the definition.
 * -----------------------
 */

import acm.program.*;
import java.io.*;
import java.util.*;

public class DictionaryLookup extends ConsoleProgram {
	public void run() {
		HashMap<String, String> dictionary = new HashMap<>(); 
		try {
			// each line of the file has a word, followed by definition:
			// abrogate	  
			// repeal or annul by authority
			Scanner input = new Scanner(new File("res/dictionary.txt"));
			while (input.hasNextLine()) {
				String word = input.nextLine();
				String definition = input.nextLine();
				
				dictionary.put(word, definition);
			}
		} catch (IOException e) {
			println("file error: " + e);
		}

		// look up words in the dictionary
		String word = readLine("Word to look up (or Enter to quit)? ");
		while (!word.equals("")) {
			if (dictionary.containsKey(word)) {
				String definition = dictionary.get(word);
				println("Definition: " + definition);
			} else {
				println("I don't know that word!");
			}
			
			word = readLine("Word to look up (or Enter to quit)? ");
		}
	}
}
