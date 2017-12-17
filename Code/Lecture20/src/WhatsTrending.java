/*
 * File: WhatsTrending.java
 * -----------------------
 * This program uses a HashMap to store and output
 * the top trending tweets in a given text file.
 * It works by taking tweets that look like:
 *	
 *		I love CS 106A! #java #kareltherobot
 *
 * and mapping them to frequencies like:
 *
 *		#java ---> 1
 *		#kareltherobot ---> 1
 * -----------------------
 */

import acm.program.*;
import java.io.*;
import java.util.*;

public class WhatsTrending extends ConsoleProgram {
	public void run() {
		String filename = promptUserForFile("Tweets file: ", "res");
		HashMap<String, Integer> hashtags = readTweets(filename);

		// Print out hashtags that occur at least 15 times
		for (String tag : hashtags.keySet()) {
			int count = hashtags.get(tag);
			if (count >= 15) {
				println(tag + ": " + count);
			}
		}
	}

	// Returns a map from hashtags to their frequency in the given file
	private HashMap<String, Integer> readTweets(String filename) {
		HashMap<String, Integer> hashtags = new HashMap<String, Integer>();

		try {
			Scanner input = new Scanner(new File(filename));
			while (input.hasNext()) {
				String word = input.next().toLowerCase();

				// skip if not a hash tag
				if (word.charAt(0) == '#') {
					if (hashtags.containsKey(word)) {
						// we've already seen it
						int count = hashtags.get(word);
						hashtags.put(word, count + 1);
					} else {
						// this is the first time we've seen it
						hashtags.put(word, 1);
					}
				}
			}
		} catch (IOException ex) {
			println("Error reading file: " + ex);
		}
		
		return hashtags;
	}
}

