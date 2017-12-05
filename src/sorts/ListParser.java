package sorts;

/**
 * This class is responsible for creating the different lists from the input
 * source file.
 * 
 * @author Wesley Chan
 *
 */
public class ListParser {
	private ReadFile file;

	/**
	 * Constructor for the ListParser class with one argument of type ReadFile
	 * 
	 * @param sourceFile
	 *            input source file
	 */
	ListParser(ReadFile sourceFile) {
		file = sourceFile;
	}

	/**
	 * This method creates an array of specified size from the input data. If
	 * the requested size is larger than the number of elements in the input
	 * data, the list will be resized to the amount of input data elements.
	 * 
	 * @param size
	 *            The requested size of the array as an int.
	 * @return An array of specified size filled with elements from the input
	 *         data.
	 */
	public int[] parseToArray(int size) {
		String[] tempArr = null;
		
		for (int line = 0; line < file.getFileLines().length; line++){
			tempArr = file.getFileLines()[line].split("\\s+");
		}
		
		if (tempArr.length < size) {
			size = tempArr.length;
		}

		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(tempArr[i]);
		}

		return arr;
	}

	/**
	 * This method creates a Linked List of specified size from the input data.
	 * If the requested size is larger than the number of elements in the input
	 * data, the list will be resized to the amount of input data elements.
	 * 
	 * @param size
	 *            The requested size of the list as an int.
	 * @return A LinkedList of specified size filled with elements from the
	 *         input data.
	 */
	public LinkedList<Integer> parseToLinkedList(int size) {
		String[] tempArr = null;
		
		for (int line = 0; line < file.getFileLines().length; line++){
			tempArr = file.getFileLines()[line].split("\\s+");
		}
		
		if (tempArr.length < size) {
			size = tempArr.length;
		}

		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		for (int i = 0; i < size; i++) {
			linkedList.append(Integer.parseInt(tempArr[i]));
		}

		return linkedList;
	}

}
