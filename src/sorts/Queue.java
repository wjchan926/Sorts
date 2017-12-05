package sorts;

/**
 * A Queue class that is used for the natural mergse sort process.
 * 
 * @author Wesley
 *
 */
public class Queue {

	private Node<LinkedList<Integer>> head;
	private Node<LinkedList<Integer>> tail;
	private int size;

	/**
	 * Default constructor
	 */
	Queue() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Checks if queue is empty
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Adds a linked list to the end of the queue
	 * @param linkedList element to be added to the end of the queue
	 */
	public void enqueue(LinkedList<Integer> linkedList) {

		Node<LinkedList<Integer>> tempNode = new Node<LinkedList<Integer>>();
		tempNode = tail;

		tail = new Node<LinkedList<Integer>>();
		tail.setData(linkedList);
		tail.setNext(null);

		if (isEmpty()) {
			head = tail;
		} else {
			tempNode.setNext(tail);
		}

		size++;
	}

	/**
	 * Removes the first element in the queue
	 * @return linked list element in the beginning of the queue
	 */
	public Node<LinkedList<Integer>> dequeue() {
		Node<LinkedList<Integer>> tempNode = new Node<LinkedList<Integer>>();
		tempNode = head;

		head = head.getNext();
		if (isEmpty()) {
			tail = null;
		}
		size--;

		return tempNode;
	}

	/**
	 * Gets the size of the queue
	 * @return size of the queue as an int
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Overridden toString() method for debugging purposes
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node<LinkedList<Integer>> currentNode = head;

		if (isEmpty()) {
			// No Data
			return sb.append("No Data.").toString();
		} else {
			while (currentNode != null) {
				sb.append(currentNode.getData().getHead().getData());
				// sb.append("\r\n");
				sb.append(" ");
				currentNode = currentNode.getNext();
			}
		}

		return sb.toString().trim();
	}
}
