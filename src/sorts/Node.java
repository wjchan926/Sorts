package sorts;

/**
 * Generic Node class.
 * 
 * @author Wesley
 *
 * @param <T> Generic Datatype
 */
public class Node<T> {
	private T data;
	private Node<T> next;

	/**
	 * Default Constructor
	 */
	public Node() {
		data = null;
		next = null;
	}

	/**
	 * Returns the data stored in the node
	 * 
	 * @return data stored in node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Returns this node's following node
	 * 
	 * @return current node's following node
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * Sets the data value of the node.
	 * 
	 * @param t
	 *            data of the node as a generic datatype
	 */
	public void setData(T t) {
		data = t;
	}

	/**
	 * Sets the current node's following node
	 * 
	 * @param node
	 *            node that will follow the current node
	 */
	public void setNext(Node<T> node) {
		next = node;
	}		 
	
	/**
	 * Overridden toString() method of debugging purposes.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(data);
		return sb.toString();
	}

}
