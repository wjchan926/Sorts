package sorts;

public final class MergeSort {

	private static LinkedList<Integer> linkedList = new LinkedList<Integer>();
	private static Queue locationQueue = new Queue();

	public static void naturalMergeSort(LinkedList<Integer> list) {
		linkedList = list;

		naturalMergeSort(linkedList.getHead());
	}

	/*
	 * public static void mergeSort(LinkedList<Integer> list) { linkedList =
	 * list;
	 * 
	 * }
	 */

	private static void naturalMergeSort(Node<Integer> start) {
		if (start == null || start.getNext() == null) {
			return;
		}

		naturalMerge(start);

	}

	private static Node<Integer> naturalMerge(Node<Integer> start) {

		if (start == null || start.getNext() == null) {
			return start;
		}

		Node<Integer> currentNode = new Node<Integer>();
		currentNode = start;
		
		// Initial Traversal of List, Create sub lists, mark locations of heads using a Queue
		Node<Integer> firstNode = new Node<Integer>();
		firstNode = currentNode;
		locationQueue.enqueue(firstNode);
		
		while (currentNode != null) {
			if (currentNode.getNext() != null) {				
				if (currentNode.getData() > currentNode.getNext().getData()) {
					Node<Integer> locationNode = new Node<Integer>();
					locationNode = currentNode.getNext();
					locationQueue.enqueue(locationNode);
					
					
					Node<Integer> tempNode = new Node<Integer>();
					tempNode = currentNode.getNext();
					
					currentNode.setNext(null); 
					currentNode = tempNode;
				}
				else{
					currentNode = currentNode.getNext();
				}
			}	
			else{
				break;
			}
		}
		
		Node<Integer> sortedList = new Node<Integer>();
		
		while (locationQueue.getSize() > 1){
			Node<Integer> node1 = locationQueue.dequeue();
			Node<Integer> node2 = locationQueue.dequeue();
		
			if (node1.getData() <= node2.getData()){
				locationQueue.enqueue(node1);
			} else{
				locationQueue.enqueue(node2);
			}
			
			sortedList = merge(node1, node2);
		}

		return sortedList;
		
		/*
		 * Node<Integer> startFirstSub = new Node<Integer>(); Node<Integer>
		 * endFirstSub = new Node<Integer>();
		 * 
		 * Node<Integer> startSecondSub = new Node<Integer>(); Node<Integer>
		 * endSecondSub = new Node<Integer>();
		 * 
		 * startFirstSub = start; endFirstSub = start;
		 * 
		 * // Located end of first sorted subset while (endFirstSub.getNext() !=
		 * null && endFirstSub.getNext().getData() > endFirstSub.getData()) {
		 * endFirstSub = endFirstSub.getNext(); }
		 * 
		 * startSecondSub = endFirstSub.getNext(); endSecondSub =
		 * endFirstSub.getNext();
		 * 
		 * // Locate end of second sorted subset while (endSecondSub.getNext()
		 * != null && endSecondSub.getNext().getData() > endSecondSub.getData())
		 * { endSecondSub = endSecondSub.getNext(); }
		 */

	}

	private static Node<Integer> merge(Node<Integer> node1, Node<Integer> node2) {

		Node<Integer> sortedSub;

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
	/*
	 * private static void mergeSort(Node<Integer> start, Node<Integer> end) {
	 * if (start.getData().compareTo(end.getData()) < 0) {
	 * 
	 * Node<Integer> middle = new Node<Integer>(); middle = getMiddleNode(start,
	 * end);
	 * 
	 * mergeSort(start, middle); mergeSort(middle.getNext(), end); //
	 * merge(start, middle, end); } }
	 * 
	 * private static Node<Integer> getMiddleNode(Node<Integer> start,
	 * Node<Integer> end) { Node<Integer> firstPtr = start; Node<Integer>
	 * secondPtr = start;
	 * 
	 * while (secondPtr.getNext() != null) { secondPtr = secondPtr.getNext(); if
	 * (secondPtr.getNext() != null) { secondPtr = secondPtr.getNext(); firstPtr
	 * = firstPtr.getNext(); } }
	 * 
	 * return firstPtr; }
	 */
}
