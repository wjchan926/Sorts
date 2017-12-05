package sorts;

import java.io.*;

/**
 * This class writes the data to an output file for the Sort analysis. There
 * are no Sort functions or calculations found in this class. This class is
 * solely used for read/write purposes.
 * 
 * @author Wesley Chan
 *
 */
public class WriteFile {

	private String filepath;
	private FileWriter outFile;
	private PrintWriter printFile;

	/**
	 * Constructor for WriteFile class with a filepath as an argument
	 * 
	 * @param s
	 *            filepath
	 */
	WriteFile(String s){
		filepath = s;
		try {
			outFile = new FileWriter(filepath);
		} catch (IOException e) {
			System.out.println("File output path is incorrect.");
			e.printStackTrace();
		}
		printFile = new PrintWriter(outFile);
	}

	/**
	 * Writes a formatted string to file
	 * 
	 * @param s
	 *            string to be written to output file
	 */
	public void writeToFile(String s){
		printFile.printf(s);
	}

	/**
	 * Closes the printFile object
	 */
	public void closeFile() {
		printFile.close();
	}
}