package sorts;

import java.io.*;

/**
 * This class reads the input data for the Sorts. There are no Sort functions or
 * calculations found in this class. This class is solely used for read/write
 * purposes. It will also keep track of the number of matrices in the input
 * file.
 * 
 * @author Wesley Chan
 *
 */
public class ReadFile {

	private File f;
	private String[] fileLines;

	/**
	 * Constructor with filepath as an argument
	 * 
	 * @param fileName
	 *            filepath of input source
	 */
	public ReadFile(String fileName) {

		f = new File(fileName);
		try {
			fileLines = new String[countLines() + 1];
		} catch (IOException e) {
			System.out.println("File input is incorrect.");
			e.printStackTrace();
		}
		readFromFile();

	}

	/**
	 * Gets the file being read
	 * 
	 * @return f file
	 */
	public File getFile() {
		return f;
	}

	/**
	 * Gets the fileLines array
	 * 
	 * @return fileLines array
	 */
	public String[] getFileLines() {
		return fileLines;
	}

	/**
	 * Reads the file line by line and stores each in an index of the fileLines
	 * array.
	 * 
	 */
	private void readFromFile() {

		try {
			FileReader fr = new FileReader(f);
			BufferedReader input = new BufferedReader(fr);

			for (int i = 0; i < fileLines.length; i++) {
				fileLines[i] = input.readLine();
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Make sure input file exists.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File input is incorrect.");
			e.printStackTrace();
		}

	}

	/**
	 * Method that counts the number of lines in the data source file. It
	 * utilizes a buffered binary read.
	 * 
	 * @return count the number of lines in file
	 * @throws IOException
	 *             if the file input is incorrect
	 * @throws FileNotFoundException
	 *             if the file f cannot be found
	 */
	private int countLines() throws IOException, FileNotFoundException {

		InputStream inputFile = new BufferedInputStream(new FileInputStream(f.getAbsolutePath()));

		byte[] c = new byte[1024];
		int count = 0;
		int readChars = 0;

		// Loop until end of stream
		while ((readChars = inputFile.read(c)) != -1) {
			// Read characters until return sequence is read
			for (int i = 0; i < readChars; i++) {
				// Search for number of line returns "\n"
				if (c[i] == '\n') {
					// Increment count for every line return read
					count++;
				}
			}
		}
		// Close out InputStream
		inputFile.close();

		return count;

	}
}