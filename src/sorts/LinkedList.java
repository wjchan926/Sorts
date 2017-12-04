package sorts;

public class LinkedList<T> {

	private Node<T> head;
	private int size;

	/**
	 * Default constructor for PathList class.
	 */
	LinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * Gets the size of the list.
	 * 
	 * @return the list size as an int
	 */
	public int getSize() {
		return size;
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
	 * Adds an element to the end of the list. Increases the size of the list.
	 * 
	 * @param t
	 *            element to add to the list
	 */
	public void append(T t) {
		Node<T> tempNode = new Node<T>();
		tempNode.setData(t);
		tempNode.setNext(null);
		
		if (head == null){
			head = tempNode;						
		} else{
			Node<T> currentNode = new Node<T>();
			currentNode = head;
			while (currentNode.getNext() != null){
				currentNode = currentNode.getNext();
			}
			
			currentNode.setNext(tempNode);				
		}
		
		size++;
		
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
	 * Checks if the list is empty
	 * 
	 * @return true of the list is empty, false otherwise
	 */
	private boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node<T> currentNode = head;

		if (isEmpty()) {
			// No Data
			return sb.append("No Data to sort.").toString();
		} else {
			while (currentNode != null) {
				sb.append(currentNode.getData());
			//	sb.append("\r\n");	
				sb.append(" ");	
				currentNode = currentNode.getNext();
			}			
		}

		return sb.toString().trim();
	}
}
