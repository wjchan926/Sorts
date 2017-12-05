package sorts;

/**
 * 
 * QuickSort class is a utility class and contains all the methods required for
 * 4 different QuickSorts.
 * 
 * @author Wesley
 *
 */

public final class QuickSort {

	private static int[] arr = null;
	private static long totalRunTime;
	private static long startTime;

	/**
	 * Private constructor to prevent instantiation
	 */
	private QuickSort() {

	}

	/**
	 * QuickSort that selects the first item as a pivot
	 * 
	 * @param array
	 *            elements to be sorted
	 */
	public static void quickSort(int[] array) {
		arr = array;
		startTime = System.nanoTime();
		quickSort(0, arr.length - 1);
		totalRunTime = System.nanoTime() - startTime;
	}

	/**
	 * QuickSort that selects the first item as the pivot, stops at 100 element
	 * partitions and uses insertion sort to finish.
	 * 
	 * @param array
	 *            elements to be sorted
	 */
	public static void quickSort100(int[] array) {
		arr = array;
		startTime = System.nanoTime();
		quickSort(0, arr.length - 1, 100);
		totalRunTime = System.nanoTime() - startTime;
	}

	/**
	 * QuickSort that selects the first item as the pivot, stops at 50 element
	 * partitions and uses insertion sort to finish.
	 * 
	 * @param array
	 *            elements to be sorted
	 */
	public static void quickSort50(int[] array) {
		arr = array;
		startTime = System.nanoTime();
		quickSort(0, arr.length - 1, 50);
		totalRunTime = System.nanoTime() - startTime;
	}

	/**
	 * QuickSort that selects the median of 3 numbers as the pivot
	 * 
	 * @param array
	 *            elements to be sorted
	 */
	public static void quickSortMed3(int[] array) {
		arr = array;
		startTime = System.nanoTime();
		quickSortMed3(0, arr.length - 1);
		totalRunTime = System.nanoTime() - startTime;
	}

	/**
	 * Recursive QuickSort method used by quickSort(int[] array)
	 * 
	 * @param start
	 *            beginning of list
	 * @param end
	 *            last element of the list
	 */
	private static void quickSort(int start, int end) {

		if (start < end) {
			int pivotIndex = partition(start, end);

			quickSort(start, pivotIndex - 1);
			quickSort(pivotIndex + 1, end);
		}

	}

	/**
	 * Recursive QuickSort method used by the quicksorts with 50 and 100 limit
	 * partitions. Switches to insertion sort when the limit is reached.
	 * 
	 * @param start
	 *            beginning of list
	 * @param end
	 *            end of list
	 * @param stopSize
	 *            partition min limit
	 */
	private static void quickSort(int start, int end, int stopSize) {

		int subArraySize = end - start + 1;

		if (subArraySize < stopSize) {
			insertionSort(start, end);
			return;
		}

		quickSort(start, end);
	}

	/**
	 * Recursive QuickSort method used by uickSortMed3(int[] array). Calculates
	 * the median of 3 numbers as the pivot.
	 * 
	 * @param start
	 *            begining of list
	 * @param end
	 *            last element of list
	 */
	private static void quickSortMed3(int start, int end) {

		int n = end - start + 1;

		if (n <= 2) {
			insertionSort(start, end);
		} else {

			int median = medianOfThree(start, start + n / 2, end);
			exchange(start, median);

			int pivotIndex = partition(start, end);

			quickSortMed3(start, pivotIndex - 1);
			quickSortMed3(pivotIndex + 1, end);
		}
	}

	/**
	 * The partition method puts the pivot in the correct position in the array.
	 * It moves all elements smaller than the pivot before the pivot and all
	 * elements larger than the pivot after the pivot.
	 * 
	 * @param start beginning of sublist
	 * @param end end of sublist
	 * @return the index of the pivot
	 */
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

	/**
	 * Switches 2 elements in the array
	 * 
	 * @param i first element to switch
	 * @param j second element to switch
	 */
	private static void exchange(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * Performs an insertion sort
	 * @param start beginning of elements to sort
	 * @param end last element to sort
	 */
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

	/**
	 * Determines the median of 3 numbers.
	 * 
	 * @param i first number
	 * @param j second number
	 * @param k third number
	 * @return The median of the 3 input numbers.
	 */
	private static int medianOfThree(int i, int j, int k) {
		return ((arr[i] <= arr[j]) ? ((arr[j] <= arr[k]) ? j : (arr[i] <= arr[k]) ? k : i)
				: ((arr[k] <= arr[j]) ? j : (arr[k] <= arr[i]) ? k : i));

	}

	/**
	 * Gets the total time a sort takes.
	 * @return time a sort takes
	 */
	public static long getTotalRunTime() {
		return totalRunTime;
	}

}
