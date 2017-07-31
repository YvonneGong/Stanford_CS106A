/*This is the second question of assignment 2. The goal is to write an interactive console program
 * named Weather. It will display the temperature entered, until entering the "sentinel" value.
 * In addition, it will display the highest, lowest and average temperature entered and show
 * the number of cold day (below 50.) Sentinel value should be written by class constant.
 */

import java.util.Collections;
import java.util.List;

import acm.program.*;
import java.util.ArrayList;
import java.util.List;

public class Weather extends ConsoleProgram {
	//set the sentinel as -1
	private static final int stopTemp=-1;
	public void run() {
		//set the starting sum to 0
		int sumTemp = 0;
		//create an empty list to store the input temp
		List<Integer> tempList = new ArrayList<Integer>();
		//set the starting cold days number to 0
		int coldDays = 0;
		//first line and input
		println ("YG's CS 106A \"Weather Master 4000\" !");
		int inputTemp = readInt("Next temperature (or " + stopTemp + " to quit)?");
		while(inputTemp != stopTemp){
			sumTemp += inputTemp;
			tempList.add(inputTemp);
			if (inputTemp <= 50){
				coldDays += 1;
			}
			inputTemp = readInt("Next temperature (or " + stopTemp + " to quit)?");
		}
		//get the number of list size
		int numberTemp = tempList.size();
		//print out the results and records
		if (numberTemp >= 1){
			//get the average
			double averageTemp = (double)sumTemp/numberTemp;
			//get the highest
			int highestTemp = Collections.max(tempList);
			//get the lowest
			int lowestTemp = Collections.min(tempList);
			//print out
			println ("Highest temperature = "+highestTemp);
			println ("Lowest temperature = "+lowestTemp);
			println ("Average = "+averageTemp);
			println (coldDays + " cold days(s)");
		}else{
			println ("No temperatures were entered.");
		}
		
		
		
		
		
	}
}
