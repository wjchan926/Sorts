package sorts;

public final class QuickSort {

	private static int[] arr;
	private static long totalRunTime;
	private static long startTime;

	public static void quickSort(int[] array) {
		arr = array;
		startTime = System.nanoTime();
		quickSort(0, arr.length - 1);
		totalRunTime = System.nanoTime() - startTime;
	}

	public static void quickSort100(int[] array) {
		arr = array;
		startTime = System.nanoTime();
		quickSort(0, arr.length - 1, 100);
		totalRunTime = System.nanoTime() - startTime;
	}

	public static void quickSort50(int[] array) {
		arr = array;
		startTime = System.nanoTime();
		quickSort(0, arr.length - 1, 50);
		totalRunTime = System.nanoTime() - startTime;
	}

	public static void quickSortMed3(int[] array) {
		arr = array;
		startTime = System.nanoTime();
		quickSortMed3(0, arr.length - 1);
		totalRunTime = System.nanoTime() - startTime;
	}

	private static void quickSort(int start, int end) {

		if (start < end) {
			int pivotIndex = partition(start, end);

			quickSort(start, pivotIndex - 1);
			quickSort(pivotIndex + 1, end);
		}

	}

	private static void quickSort(int start, int end, int stopSize) {

		int subArraySize = end - start + 1;

		if (subArraySize < stopSize) {
			insertionSort(start, end);
			return;
		}

		quickSort(start, end);
	}

	private static void quickSortMed3(int start, int end) {

		int median = medianOfThree(start, (start + end) / 2, end);
		exchange(start, median);

		int pivotIndex = partition(start, end);

		quickSortMed3(start, pivotIndex - 1);
		quickSortMed3(pivotIndex + 1, end);

	}

	private static int partition(int start, int end) {

		int pivot = arr[start];

		int i = start + 1;

		for (int j = start + 1; j <= end; j++) {
			if (arr[j] < pivot) {

				exchange(i, j);
				i++;

			}
		}

		arr[start] = arr[i - 1];
		arr[i - 1] = pivot;

		return i - 1;
	}

	private static void exchange(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void insertionSort(int start, int end) {
		for (int i = start + 1; i <= end; i++) {
			int current = arr[i];
			int j = i - 1;
			
			while (j >= 0 && arr[j] > current) {
				arr[j + 1] = arr[j];
				j--;
			}
			
			arr[j + 1] = current;
		}
	}

	private static int medianOfThree(int i, int j, int k) {
		return (arr[i] < arr[j] ? (arr[j] < arr[k] ? j : arr[i] < arr[k] ? k : i)
				: (arr[k] < arr[j] ? j : arr[k] < arr[i] ? k : i));

	}

	public static long getTotalRunTime() {
		return totalRunTime;
	}

}
