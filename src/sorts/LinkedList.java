package sorts;

/**
 * A Generic Linked List class. Many of the typical LinkedList methods are left
 * out since they were not being used.
 * 
 * @author Wesley
 *
 * @param <T>
 *            Generic Datatype
 */
public class LinkedList<T> {

	private Node<T> head;

	/**
	 * Default constructor for LinkedList class.
	 */
	LinkedList() {
		head = null;
	}

	/**
	 * Gets the first element of the list
	 * 
	 * @return the first Node in the list
	 */
	public Node<T> getHead() {
		return head;
	}

	/**
	 * Sets the first element of the list
	 * @param node Sets the first element of the list to this node
	 */
	public void setHead(Node<T> node) {
		head = node;
	}

	/**
	 * Adds an element to the end of the list. Increases the size of the list.
	 * 
	 * @param t
	 *            element to add to the list
	 */
	public void append(T t) {
		Node<T> tempNode = new Node<T>();
		tempNode.setData(t);
		tempNode.setNext(null);

		if (head == null) {
			head = tempNode;
		} else {
			Node<T> currentNode = new Node<T>();
			currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}

			currentNode.setNext(tempNode);
		}

	}

	/**
	 * Adds an element to the end of the list. Increases the size of the list.
	 * 
	 * @param node
	 *            element to add to the list
	 */
	public void append(Node<T> node) {
		Node<T> tempNode = new Node<T>();
		tempNode = node;

		if (head == null) {
			head = tempNode;
		} else {
			Node<T> currentNode = new Node<T>();
			currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}

			currentNode.setNext(tempNode);
		}

	}

	/**
	 * This method makes a deep copy of the list.
	 * 
	 * @return a copy of the list
	 */
	public LinkedList<T> copy() {
		LinkedList<T> tempList = new LinkedList<T>();

		Node<T> currentNode = head;

		while (currentNode != null) {
			tempList.append(currentNode.getData());
			currentNode = currentNode.getNext();
		}

		return tempList;
	}

	/**
	 * Overrides the toString() method. Allows printing of the List.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node<T> currentNode = head;

		if (head == null) {
			// No Data
			return sb.append("No Data to sort.").toString();
		} else {
			while (currentNode != null) {
				sb.append(currentNode.getData());
				sb.append("\r\n");
				currentNode = currentNode.getNext();
			}
		}

		return sb.toString().trim();
	}
}
