/*
 * File: OpeningCrawl.java
 * -----------------------
 * A GraphicsProgram that uses an ArrayList of GLabels
 * to read in text and scroll it up the screen like in Star Wars.
 * 
 * Public domain image from http://www.publicdomainpictures.net/pictures/130000/velka/night-sky-background-14391263141jp.jpg
 * Public domain soundtrack from https://commons.wikimedia.org/wiki/File:Gustav_Holst_-_the_planets,_op._32_-_i._mars,_the_bringer_of_war.ogg
 * -----------------------
 */

import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import acm.graphics.*;

public class OpeningCrawl extends GraphicsProgram {
	
	private static final String CRAWL_TEXT_FILENAME = "res/opening-crawl.txt";
	private static final String CRAWL_MUSIC_FILENAME = "res/music.au";
	private static final String BACKGROUND_IMAGE = "res/background.jpg";
	
	private static final double LABEL_PADDING = 15;	
	private static final double PAUSE_TIME = 20;
	
	public void run() {
		setCanvasSize(800, 700);
		
		// Play the background music
		AudioClip music = MediaTools.loadAudioClip(CRAWL_MUSIC_FILENAME);
		music.play();
		
		// Add our background image
		GImage bg = new GImage(BACKGROUND_IMAGE);
		bg.setSize(getWidth(), getHeight());
		add(bg);
		
		// Create GLabels from the text file
		ArrayList<GLabel> labelsList = readOpeningCrawlFile(CRAWL_TEXT_FILENAME);
		
		// Initial placement of labels at the bottom center of the screen
		double y = getHeight();
		for (int i = 0; i < labelsList.size(); i++) {
			GLabel currentLabel = labelsList.get(i);
			
			double x = getWidth() / 2.0 - currentLabel.getWidth() / 2.0;
			add(labelsList.get(i), x, y);

			y += currentLabel.getAscent() + LABEL_PADDING;
		}
		
		// Animate labels forever
		while (true) {
			for (int i = 0; i < labelsList.size(); i++) {
				labelsList.get(i).move(0, -1);
			}
			pause(PAUSE_TIME);
		}
	}
	
	/* This method returns an ArrayList containing a GLabel for each line in the
	 * given file.  The GLabels are in the same order as the lines in the text file.
	 */
	private ArrayList<GLabel> readOpeningCrawlFile(String crawlFilename) {
		try {
			Scanner scanner = new Scanner(new File(crawlFilename));
			
			ArrayList<GLabel> labelsList = new ArrayList<>();
			while  (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				// Make a GLabel out of this line and put it in our arraylist
				GLabel label = new GLabel(line);
				label.setFont("Courier New-bold-32");
				label.setColor(Color.WHITE);
				labelsList.add(label);
			}
			scanner.close();
			return labelsList;
		} catch (IOException e) {
			println("Could not read this file.");
			return null;
		}
	}
}
