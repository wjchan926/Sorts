package sorts;

public class Queue {

	private Node<Integer> head;
	private Node<Integer> tail;
	private int size;

	Queue() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void enqueue(Node<Integer> node) {

		Node<Integer> tempNode = tail;

		tail = new Node<Integer>();
		tail.setData(node.getData());
		tail.setNext(null);

		if (isEmpty()) {
			head = tail;
		} else {
			tempNode.setNext(tail);
		}

		size++;
	}

	public Node<Integer> dequeue() {
		Node<Integer> tempNode = head;

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
		Node<Integer> currentNode = head;

		if (isEmpty()) {
			// No Data
			return sb.append("No Data.").toString();
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