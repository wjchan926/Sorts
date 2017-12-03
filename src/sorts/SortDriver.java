package sorts;

import java.util.Random;

public class SortDriver {
	public static void main(String[] args) {

		for (int j = 1; j < 10000; j++) {
			int[] arr;
			arr = new int[1000];
			Random generator = new Random();
			for (int i = 0; i < 1000; i++) {
				arr[i] = (generator.nextInt(1000) + 1);
			}

			QuickSort.quickSort(arr);
			System.out.println(QuickSort.getTotalRunTime());
		}

	}
}
