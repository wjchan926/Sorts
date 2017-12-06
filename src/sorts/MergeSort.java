package sorts;

/**
 * MergeSort class is a utility class and contains all the methods required for
 * a Natural Merge Sort.
 * 
 * @author Wesley
 *
 */
public final class MergeSort {

	private static LinkedList<Integer> linkedList = new LinkedList<Integer>();
	private static Queue locationQueue = new Queue();
	private static long totalRunTime;
	private static long startTime;

	/**
	 * Private Constructor to prevent instantiation.
	 */
	private MergeSort() {

	}

	/**
	 * Method that performs the Natural Merge Sort. It is overloaded for ease of
	 * use. This method will keep track of how long the sort takes.
	 * 
	 * @param list
	 *            A Linked List for sorting.
	 */
	public static void naturalMergeSort(LinkedList<Integer> list) {
		linkedList = list;

		startTime = System.nanoTime();
		naturalMergeSort(linkedList.getHead());
		totalRunTime = System.nanoTime() - startTime;
	}

	/**
	 * This overloaded method performs the Natural Merge Sort.
	 * 
	 * @param start
	 *            First Node of the List to be sorted.
	 */
	private static void naturalMergeSort(Node<Integer> start) {
		if (start == null || start == null) {
			return;
		}

		linkedList.setHead(naturalMerge(start));

	}

	/**
	 * This method performs the natural merge sort. It first scans the data and
	 * splits the file into subfiles. Then it begins the sort and merging
	 * process.
	 * 
	 * @param start
	 *            Beginning of List
	 * @return node that represents a sorted LinkedList
	 */
	private static Node<Integer> naturalMerge(Node<Integer> start) {

		if (start == null || start.getNext() == null) {
			// return start;
		}

		Node<Integer> currentNode = new Node<Integer>();
		currentNode = start;

		// Initial Traversal of List, Create sub lists, mark locations of heads
		// using a Queue
		locationQueue.enqueue(linkedList);

		while (currentNode != null) {
			if (currentNode.getNext() != null) {
				if (currentNode.getData() > currentNode.getNext().getData()) {
					LinkedList<Integer> tempLinkedList = new LinkedList<Integer>();
					tempLinkedList.append(currentNode.getNext());
					locationQueue.enqueue(tempLinkedList);

					Node<Integer> tempNode = new Node<Integer>();
					tempNode = currentNode.getNext();

					currentNode.setNext(null);
					currentNode = tempNode;
				} else {
					currentNode = currentNode.getNext();
				}
			} else {
				break;
			}
		}

		Node<Integer> sortedList = new Node<Integer>();

		if (locationQueue.getSize() != 1) {
			while (locationQueue.getSize() > 1) {
				Node<Integer> node1 = locationQueue.dequeue().getData().getHead();
				Node<Integer> node2 = locationQueue.dequeue().getData().getHead();

				if (node1.getData() <= node2.getData()) {
					LinkedList<Integer> tempLinkedList = new LinkedList<Integer>();
					tempLinkedList.append(node1);
					locationQueue.enqueue(tempLinkedList);
				} else {
					LinkedList<Integer> tempLinkedList = new LinkedList<Integer>();
					tempLinkedList.append(node2);
					locationQueue.enqueue(tempLinkedList);
				}

				sortedList = merge(node1, node2);
			}

		} else {
			sortedList = linkedList.getHead();
		}

		while (!locationQueue.isEmpty()) {
			locationQueue.dequeue();
		}
		return sortedList;
	}

	/**
	 * This is the recursive merging method that combines 2 sublists in a sorted
	 * order.
	 * <p>
	 * This code is modified code from void merge(int arr[], int l, int m, int
	 * r) obtained from http://www.geeksforgeeks.org/merge-sort/
	 * <p>
	 * Original author: Rajat Mishra
	 * 
	 * 
	 * @param node1
	 *            Beginning of 1st Sublist
	 * @param node2
	 *            Beginning of 2nd Sublist
	 * @return node that represents a sorted LinkedList created from the 2
	 *         sublists
	 */
	private static Node<Integer> merge(Node<Integer> node1, Node<Integer> node2) {
		Node<Integer> sortedSub = new Node<Integer>();

		if (node1 == null) {
			return node2;
		}

		if (node2 == null) {
			return node1;
		}

		if (node1.getData() <= node2.getData()) {
			sortedSub = node1;
			sortedSub.setNext(merge(node1.getNext(), node2));
		} else {
			sortedSub = node2;
			sortedSub.setNext(merge(node1, node2.getNext()));
		}

		return sortedSub;
	}

	/**
	 * Gets the total sort runtime
	 * @return time it takes to sort elements
	 */
	public static long getTotalRunTime() {
		return totalRunTime;
	}
}
