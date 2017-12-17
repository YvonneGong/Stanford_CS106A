import acm.program.*;
import java.util.*;
import java.io.*;

// A program that prints out the reverse of the inputted file.
public class ReverseFile extends ConsoleProgram {
	public void run() {
		String filename = promptUserForFile("Filename: ", "res");
		try {
			Scanner scanner = new Scanner(new File(filename));
			ArrayList<String> lines = new ArrayList<>();
			while (scanner.hasNextLine()) {
				lines.add(scanner.nextLine());
			}
			
			for (int i = lines.size() - 1; i >= 0; i--) {
				println(lines.get(i));
			}
			scanner.close();
		} catch (IOException e) {
			println("Could not read file: " + e);
		}
	}
}
