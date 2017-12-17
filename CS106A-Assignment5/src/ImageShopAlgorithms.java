/* 
 * Note: these methods are public in order for them to be used by other files
 * in this assignment; DO NOT change them to private.  You may add additional
 * private methods to implement required functionality if you would like.
 * 
 * You should remove the stub lines from each method and replace them with your
 * implementation that returns an updated image.
 */

// TODO: comment this file explaining its behavior

import java.util.*;
import acm.graphics.*;

public class ImageShopAlgorithms implements ImageShopAlgorithmsInterface {

	
	public GImage flipHorizontal(GImage source) {
		/*This function is to flip the image horizontally 
		 * Similar with the two functions below
		 */
		
		//get the 2D array of the original image
		int[][] graphPixels = source.getPixelArray();
		int rowNum = graphPixels.length;
		int colNum = graphPixels[0].length;
		
		//create a new 2D array
		int[][] newGraphPixels = new int[rowNum][colNum];
		
		//flip the array
		for (int row = 0; row < rowNum; row++){
			for (int col = 0; col < colNum; col++){
				int singlePixel = graphPixels[row][col];
				newGraphPixels[row][colNum-col-1] = singlePixel;
			}
		}
		
		//create and update the new image
		GImage newGraph = new GImage(newGraphPixels);
		return newGraph;
	}

	public GImage rotateLeft(GImage source) {
		/*This function is to rotate the image to the left
		 * The first row become the first column; 
		 * The previously last column becomes the first row 
		 */
		
		//get the pixels of the original image
		int[][] graphPixels = source.getPixelArray();
		
		//create a new 2D array;
		int[][] newPixels = new int[graphPixels[0].length][graphPixels.length];
		
		for (int row = 0; row < graphPixels.length; row++){
			for (int col = 0; col < graphPixels[0].length; col++){
				int singlePixel = graphPixels[row][col];
				newPixels[graphPixels[0].length - col - 1][row] = singlePixel; 
				//why I need to -1: graphPixels[0].length is the actual col number
				//counting starts from 1
			}
		}
		
		//create and return the new image 
		GImage newImage = new GImage(newPixels);
		return newImage;	
	}

	public GImage rotateRight(GImage source) {
		// This function is to rotate a image to right;
		// Similar with the one before
		
		//get the array of original image
		int[][] graphPixels = source.getPixelArray();
		int oldRow = graphPixels.length;
		int oldCol = graphPixels[0].length;
		
		//create s new 2D array
	    int[][] newGraphPixels = new int[oldCol][oldRow];
		
		//update the new location
	    for (int row = 0; row < oldRow; row++){
	    	for (int col = 0; col < oldCol; col++){
	    		int singlePixels = graphPixels[row][col];
	    		newGraphPixels[col][oldCol-row-1] = singlePixels;
	    	}
	    }
		
		//create and return the new image
		GImage newImage = new GImage(newGraphPixels);
		return newImage;
	}

	public GImage greenScreen(GImage source) {
		/* This function is to make the green background to transparent 
		 * The way to identify green is: the green component is at least as twice
		 * as the larger component between red and blue
		 * The way to set transparent is to add a fourth component - alpha, 
		 * and set the alpha to 0
		 */
		
		// Check whether the point is green; if yes, set it to transparent
		// First, read in the image and get its pixel array
		int[][] graphPixels = source.getPixelArray();
		
		//Second, check each pixel
		for (int row = 0; row < graphPixels.length; row++){
			for (int col = 0; col < graphPixels[0].length; col++){
				int singlePixel = graphPixels[row][col];
				if (isGreen(singlePixel) == true){
					int newPixel = changeToTrans(singlePixel);
					graphPixels[row][col] = newPixel;
				}
			}
		}
		
		//update new pixels
		source.setPixelArray(graphPixels);
		return source;	
			
		//return null;
	}

	//function1 in greenScreen: check whether it is transparent 
	private boolean isGreen(int inputPixel) { 
		int green = GImage.getGreen(inputPixel);
		int red = GImage.getRed(inputPixel);
		int blue = GImage.getBlue(inputPixel);
		int bigger = Math.max(red, blue);
		if (green >= 2*bigger){
			return true; 
		}else{
			return false;
		}
	}
	
	//function2 in greenScreen: set the point to transparent 
	private int changeToTrans(int inputPixel){
		int transparentPixel = GImage.createRGBPixel(1,1,1,0);
		return transparentPixel;
	}

	public GImage equalize(GImage source) {
		/* This function is to enhance the picture 
		 * The first step is to generate luminosity histogram for the source image
		 *  Then compute the cummulative luminosity histogram
		 *  Use the cummulative one to modify each pixel to increase contrast
		 */
		
		//Step 1: luminosity histogram
		
		//get the array of original image
		int[][] graphPixels = source.getPixelArray();
		int row = graphPixels.length;
		int col = graphPixels[0].length;
		
		//get the luminosity for each pixel
		//store the luminosity in array, the index represent the luminosity 
		
		//create a array to store luminosity
		int[] luminosity = new int [256];
		
		//get and store the luminosity for each pixel
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++){
				int singlepixel = graphPixels[i][j];
				int red = GImage.getRed(singlepixel);
				int green = GImage.getGreen(singlepixel);
				int blue = GImage.getBlue(singlepixel);
				int singleLuminosity = computeLuminosity(red, green, blue);
				luminosity[singleLuminosity] += 1;
			}
		}
		
		// Get the cumulative luminosity by the function
		updatedCumulativeLuminosityArray = cumulativeLuminosityFunc(luminosity, cumulativeLuminosityArray);
		
		// Use function to get the Max 
		int Max = getMax(updatedCumulativeLuminosityArray);
		
		// Use function to get the RGB for each pixel
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++){
				int singlepixel = graphPixels[i][j];
				int red = GImage.getRed(singlepixel);
				int green = GImage.getGreen(singlepixel);
				int blue = GImage.getBlue(singlepixel);
				int singleLuminosity = computeLuminosity(red, green, blue);
				int updatedRGB = getRGB(updatedCumulativeLuminosityArray[singleLuminosity], Max);
				int newPixel = GImage.createRGBPixel(updatedRGB, updatedRGB, updatedRGB);
				graphPixels[i][j] = newPixel;
			}
		}
		//update new pixels
			source.setPixelArray(graphPixels);
			return source;	
	}
	
	// Compute the cumulative luminosity histogram 
	
	// Create the empty cumulative luminosity array
	int[] cumulativeLuminosityArray = new int [256];
	int[] updatedCumulativeLuminosityArray = new int [256];
	
	
	private int [] cumulativeLuminosityFunc(int[] inputLuminosity, int[] updatedLuminosity){
		// Get the length of input 
		int inputLengh = inputLuminosity.length;
		// Set the first one
		updatedLuminosity[0] = inputLuminosity[0];
		
		for (int i = 1; i < inputLengh; i++){
			updatedLuminosity[i] = updatedLuminosity[i-1] + inputLuminosity[i];
		}
		
		return updatedLuminosity;
		
	}
	
	
	// Function to expand the luminosity 
	
	// get the number of total pixel 
	//check whether need to recreate Max out of the private
	private int getMax(int [] inputArray){
		int arrayLength = inputArray.length;
		int Max = 0;
		for (int i = 0; i < arrayLength; i++){
			if (Max < inputArray[i]){
				Max = inputArray[i];
			}
		}
		return Max;
	}
	
	// return the new RGB value for each pixel
	private int getRGB(int number, int maxNumber){
		int RGB = (255 * number) / maxNumber; 
		return RGB;
	}
	
	// update the graph 

	public GImage negative(GImage source) {
		/*This function is to make the convert an image to its inverse.
		 * For each pixel, all red, green and blue should be the inverse of 
		 * the original value, defining as 255-k
		 */
		
		//read in the image and get its pixel array
		int[][] graphPixels = source.getPixelArray();
		
		//get RGB for each pixel
		for (int row = 0; row < graphPixels.length; row++){
			for (int col = 0; col < graphPixels[0].length; col++){
				int singlePixel = graphPixels[row][col];
				int newPixel = createNewPixel(singlePixel);
				graphPixels[row][col] = newPixel;		
			}
		}
		
		source.setPixelArray(graphPixels); //this is to update image
		
		return source;
	}
	
	private int createNewPixel(int number){
		int red = 255 - GImage.getRed(number);
		int green = 255 - GImage.getGreen(number);
		int blue = 255 - GImage.getBlue(number);
		int updatedPixel = GImage.createRGBPixel(red, green, blue);
		return updatedPixel;
	}

	public GImage translate(GImage source, int dx, int dy) {
		/* This function will translate the image by dx and dy;
		 * First, get the numRow and numCol;
		 * store each pixel;
		 * move the pixel value to the reminder value;
		 * create and upload the new image
		 */
		// get the pixel of the original image;
		int [][] graphPixels = source.getPixelArray();
		int numRow = graphPixels.length;
		int numCol = graphPixels[0].length;
		
		//create a new 2D array;
		int [][] newGraphPixels = new int[numRow][numCol];
		
		//update each pixel;
		for (int row = 0; row < numRow; row++){
			for (int col = 0; col < numCol; col++){
				int singlePixel = graphPixels[row][col];
				//please note: if the variable will be used out of the ifelse loop,
				//it should be defined out of the loop;
				int newNumRow;
				int newNumCol;
				if (dy+row < 0){
					newNumRow = numRow - Math.abs(dy + row) % (numRow);
				}else{
					newNumRow = (dy + row) % numRow;
				}
				if (dx + col < 0){
					newNumCol = numCol - Math.abs(dx + col) % (numCol);
				}else{
					newNumCol = (dx + col) % numCol;
				}
				
				newGraphPixels[newNumRow][newNumCol] = singlePixel;
			}
		}
		
		//create and update new image;
		GImage newImage = new GImage(newGraphPixels);
		return newImage;
		
	}

	//private int abs(int i) {
		 //TODO Auto-generated method stub
		//return 0;
	//}

	public GImage blur(GImage source) {
		/* This function is to make the image blur though changing the RGB to the average
		 * of nearby 9 (including itself)
		 * The challenge is to address the points at the edge. 
		 */
		
		// get the pixel of the original image;
		int [][] graphPixels = source.getPixelArray();
		int numRow = graphPixels.length;
		int numCol = graphPixels[0].length;
		
		//create a new 2D array to store the updated info
		int [][] newGraphPixels = new int [numRow][numCol];
		
		//initiate three colors; n; px (pixel)
		
		int px; 
		ArrayList<Integer> dx = new ArrayList<Integer>(Arrays.asList(-1, 0, 1));
		ArrayList<Integer> dy = new ArrayList<Integer>(Arrays.asList(-1, 0, 1));
		
		int average_red;
		int average_blue;
		int average_green;
		
		//calculate the new RGB based on the location; 
		//if requirements meet, store it
		for (int row = 0; row < numRow; row++){
			for (int col = 0; col < numCol; col++){
				int red = 0;
				int blue = 0;
				int green = 0;
				float n = 0;
				
				//checkBox is a function to see which of the nine position is in the range 
				for (int i = 0; i < dx.size(); i++){
					for (int j = 0; j < dy.size(); j++){
						if (checkBox(row + dx.get(i), col + dy.get(j), numRow, numCol) == true){
							n += 1;
							px = graphPixels[row + dx.get(i)][col + dy.get(j)];	
							red += GImage.getRed(px);
							green += GImage.getGreen(px);
							blue += GImage.getBlue(px);
						}
					}
				}
				//calculate the new pixel
				average_red = Math.round(red / n);
				average_green = Math.round(green / n);
				average_blue = Math.round(blue / n);
				int updatedPixel = GImage.createRGBPixel(average_red, average_green, average_blue);
				newGraphPixels[row][col] = updatedPixel;
			}
		}
		//create and update new image;
		GImage newImage = new GImage(newGraphPixels);
		return newImage;
	}
	
	//function for blur: to check whether the location is in range 
		private boolean checkBox(int row, int col, int numRow, int numCol){
			if (row >= 0 & row <= numRow - 1 & col >= 0 & col <= numCol - 1){
				return true;
			}else{
				return false;
			}
		}
	
}
