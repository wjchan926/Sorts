package sorts;

import java.io.IOException;

/**
 * This Log class is responsible for logging the Sorted data and streaming it to
 * the output file. Output file formatting is all controlled here and can be
 * changed with this class if needed.
 * 
 * @author Wesley Chan
 *
 */
public class SortLog {
	private LinkedList<Integer> sortedList;
	private int[] sortedArr;
	private WriteFile outputFile;
	private StringBuffer sortedSb;
	private long[] sortedLongArr;

	/**
	 * Overloaded constructor for SortLog class that accepts 2 arguments
	 * 
	 * @param arr
	 *            A sorted Array of the original input data.
	 * @param outputFile
	 *            The output file for saving the sorted array.
	 */
	SortLog(int[] arr, WriteFile outputFile) {
		sortedArr = arr;
		this.outputFile = outputFile;
		sortedSb = listToString(sortedArr);
	}

	/**
	 * Overloaded constructor for SortLog class that accepts 2 arguments. This
	 * constructor is used for time data only.
	 * 
	 * @param arr
	 *            An array of times it took to run sorts
	 * @param outputFile
	 *            The output file for saving the time data.
	 */
	SortLog(long[] arr, WriteFile outputFile) {
		sortedLongArr = arr;
		this.outputFile = outputFile;
		sortedSb = listToString(sortedLongArr);
	}

	/**
	 * Overloaded constructor for SortLog class that accepts 2 arguments
	 * 
	 * @param list
	 *            A sorted Linked List of the original input data.
	 * @param outputFile
	 *            The output file for saving the sorted list.
	 */
	SortLog(LinkedList<Integer> list, WriteFile outputFile) {
		sortedList = list;
		this.outputFile = outputFile;
		sortedSb = listToString(sortedList);
	}

	/**
	 * Formats all the analyzed data and streams the data to the output file.
	 * Adds horizontal rules for readability.
	 * 
	 * @throws IOException
	 *             if the output filepath is incorrect.
	 */
	public void write() throws IOException {
		StringBuffer log = new StringBuffer();

		log.append("Sorted Data:\r\n");
		log.append(horizontalRule());
		log.append(sortedSb);
		outputFile.writeToFile(log.toString());
	}

	/**
	 * Writes the time data to the output files
	 * 
	 * @throws IOException
	 *             if the output filepath is incorrect.
	 */
	public void writeTimes() throws IOException {
		StringBuffer log = new StringBuffer();
		log.append(sortedSb);
		outputFile.writeToFile(log.toString());
	}

	/**
	 * Converts the sorted array into a StringBuffer object for streaming.
	 * 
	 * @param arr
	 *            A sorted array.
	 * @return A StringBuffer object converted from the sorted array.
	 */
	private StringBuffer listToString(int[] arr) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + "\r\n");
		}

		return sb;
	}

	/**
	 * Converts the sorted array into a StringBuffer object for streaming.
	 * 
	 * @param arr
	 *            A sorted array.
	 * @return A StringBuffer object converted from the sorted array.
	 */
	private StringBuffer listToString(long[] arr) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + "\r\n");
		}

		return sb;
	}

	/**
	 * Converts the sorted linked list into a StringBuffer object for streaming.
	 * 
	 * @param linkedList
	 *            A sorted array.
	 * @return A StringBuffer object converted from the sorted linked list.
	 */
	private StringBuffer listToString(LinkedList<Integer> linkedList) {
		StringBuffer sb = new StringBuffer();

		Node<Integer> currentNode = new Node<Integer>();
		currentNode = linkedList.getHead();

		while (currentNode != null) {
			sb.append(currentNode.getData() + "\r\n");
			currentNode = currentNode.getNext();
		}

		return sb;
	}

	/*
	 * Creates a horizontal rule
	 */
	private String horizontalRule() {
		return "-------------\r\n";
	}

}
