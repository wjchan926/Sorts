package sorts;

import java.util.Random;

public class SortDriver {
	public static void main(String[] args) {

	/*	for (int j = 1; j < 100; j++) {
			int[] arr;
			arr = new int[10000];
			Random generator = new Random();
			for (int i = 0; i < 10000; i++) {
				arr[i] = (generator.nextInt(10000) + 1);
			}

			QuickSort.quickSort(arr);
			System.out.println(QuickSort.getTotalRunTime());
		}
*/
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.append(5);
		linkedList.append(8);
		linkedList.append(13);
		linkedList.append(16);
		linkedList.append(2);
		linkedList.append(6);
		linkedList.append(10);
		linkedList.append(14);
		linkedList.append(11);
		linkedList.append(1);
		linkedList.append(4);
		linkedList.append(15);
		linkedList.append(7);
		linkedList.append(3);
		linkedList.append(9);
		linkedList.append(12);
		
	//	System.out.print(linkedList);
		MergeSort.naturalMergeSort(linkedList);
	//	System.out.print(linkedList);
	}
}
