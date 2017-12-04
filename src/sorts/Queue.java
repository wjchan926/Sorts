package sorts;

public class Queue {

	private Node<LinkedList<Integer>> head;
	private Node<LinkedList<Integer>> tail;
	private int size;

	Queue() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

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

	public int getSize() {
		return size;
	}

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
