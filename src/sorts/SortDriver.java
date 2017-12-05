package sorts;

import java.io.IOException;

/**
 * SortDriver is the class that runs all the sorts. It is split into 2 sections.
 * The first section demonstrate that the various sorts work. The second
 * section is for gathering the time data for ever sort complete. There are 75
 * total time data runs.
 * 
 * @author Wesley Chan
 *
 */
public class SortDriver {

	/**
	 * The main() method takes 6 command line arguments. The first argument is
	 * the input source filepath. The next 5 are the output source filepaths.
	 * 
	 * @param args
	 *            The first argument is the input source filepath. The next 5
	 *            are the output source filepaths.
	 */
	public static void main(String[] args) {

		// Sort Section - This section demonstrates that all 5 sorts work.
		// These will all be of size 50 files.
		// First command line argument is in the input source filepaths
		ReadFile quickSortInputFile = new ReadFile(args[0]);
		ReadFile quickSort50InputFile = new ReadFile(args[0]);
		ReadFile quickSort100InputFile = new ReadFile(args[0]);
		ReadFile quickSortMed3InputFile = new ReadFile(args[0]);
		ReadFile mergeSortInputFile = new ReadFile(args[0]);

		// Second 5 command line arguments are the output source filepath for
		// the sorted data
		WriteFile quickSortOutputFile = new WriteFile(args[1]);
		WriteFile quickSort50OutputFile = new WriteFile(args[2]);
		WriteFile quickSort100OutputFile = new WriteFile(args[3]);
		WriteFile quickSortMed3OutputFile = new WriteFile(args[4]);
		WriteFile mergeSortOutputFile = new WriteFile(args[5]);

		// Create ListParser Objects for getting data from files
		ListParser listParser1 = new ListParser(quickSortInputFile);
		ListParser listParser2 = new ListParser(quickSort50InputFile);
		ListParser listParser3 = new ListParser(quickSort100InputFile);
		ListParser listParser4 = new ListParser(quickSortMed3InputFile);
		ListParser listParser5 = new ListParser(mergeSortInputFile);

		// Create Arrays for the QuickSorts
		int[] qSArr = listParser1.parseToArray(50);
		int[] qS50Arr = listParser2.parseToArray(50);
		int[] qS100Arr = listParser3.parseToArray(50);
		int[] qSMed3Arr = listParser4.parseToArray(50);

		// Create Linked List for MergeSort
		LinkedList<Integer> msLinkedList = listParser5.parseToLinkedList(50);

		// Perform Sorts and log sorted data
		try {

			QuickSort.quickSort(qSArr);
			SortLog qSSortLog = new SortLog(qSArr, quickSortOutputFile);
			qSSortLog.write();

			QuickSort.quickSort50(qS50Arr);
			SortLog qS50SortLog = new SortLog(qS50Arr, quickSort50OutputFile);
			qS50SortLog.write();

			QuickSort.quickSort100(qS100Arr);
			SortLog qS100SortLog = new SortLog(qS100Arr, quickSort100OutputFile);
			qS100SortLog.write();

			QuickSort.quickSortMed3(qSMed3Arr);
			SortLog qSMed3SortLog = new SortLog(qSMed3Arr, quickSortMed3OutputFile);
			qSMed3SortLog.write();

			MergeSort.naturalMergeSort(msLinkedList);
			SortLog mSSortLog = new SortLog(msLinkedList, mergeSortOutputFile);
			mSSortLog.write();

		} catch (

		IOException e) {
			System.out.println("Output file path is incorrect.");
			e.printStackTrace();
		}

		// Close sorted output files quickSortOutputFile.closeFile();
		quickSort50OutputFile.closeFile();
		quickSort100OutputFile.closeFile();
		quickSortMed3OutputFile.closeFile();
		mergeSortOutputFile.closeFile();

		System.out.println("Sorting Completed.");

		// Timing Section - This section will run numerous sorts and save the
		// timing data for analysis purposes.
		// This section will have hard-coded filenames to facilitate the data
		// mining process.
		// QuickSort
		quickSortTimeData("DataMiningInput\\asc50.dat", "DataMiningOuput\\QSAsc50Times.txt", 50);
		quickSortTimeData("DataMiningInput\\asc1k.dat", "DataMiningOuput\\QSAsc1kTimes.txt", 1000);
		quickSortTimeData("DataMiningInput\\asc2k.dat", "DataMiningOuput\\QSAsc2kTimes.txt", 2000);
		quickSortTimeData("DataMiningInput\\asc5k.dat", "DataMiningOuput\\QSAsc5kTimes.txt", 5000);
		quickSortTimeData("DataMiningInput\\asc10k.dat", "DataMiningOuput\\QSAsc10kTimes.txt", 10000);

		quickSortTimeData("DataMiningInput\\ran50.dat", "DataMiningOuput\\QSRan50Times.txt", 50);
		quickSortTimeData("DataMiningInput\\ran1k.dat", "DataMiningOuput\\QSRan1kTimes.txt", 1000);
		quickSortTimeData("DataMiningInput\\ran2k.dat", "DataMiningOuput\\QSRan2kTimes.txt", 2000);
		quickSortTimeData("DataMiningInput\\ran5k.dat", "DataMiningOuput\\QSRan5kTimes.txt", 5000);
		quickSortTimeData("DataMiningInput\\ran10k.dat", "DataMiningOuput\\QSRan10kTimes.txt", 10000);
		
		quickSortTimeData("DataMiningInput\\rev50.dat", "DataMiningOuput\\QSRev50Times.txt", 50);
		quickSortTimeData("DataMiningInput\\rev1k.dat", "DataMiningOuput\\QSRev1kTimes.txt", 1000);
		quickSortTimeData("DataMiningInput\\rev2k.dat", "DataMiningOuput\\QSRev2kTimes.txt", 2000);
		quickSortTimeData("DataMiningInput\\rev5k.dat", "DataMiningOuput\\QSRev5kTimes.txt", 5000);
		quickSortTimeData("DataMiningInput\\rev10k.dat", "DataMiningOuput\\QSRev10kTimes.txt", 10000);
		
		// QuickSort 50 Cutoff
		quickSort50TimeData("DataMiningInput\\asc50.dat", "DataMiningOuput\\QS50Asc50Times.txt", 50);
		quickSort50TimeData("DataMiningInput\\asc1k.dat", "DataMiningOuput\\QS50Asc1kTimes.txt", 1000);
		quickSort50TimeData("DataMiningInput\\asc2k.dat", "DataMiningOuput\\QS50Asc2kTimes.txt", 2000);
		quickSort50TimeData("DataMiningInput\\asc5k.dat", "DataMiningOuput\\QS50Asc5kTimes.txt", 5000);
		quickSort50TimeData("DataMiningInput\\asc10k.dat", "DataMiningOuput\\QS50Asc10kTimes.txt", 10000);
		
		quickSort50TimeData("DataMiningInput\\ran50.dat", "DataMiningOuput\\QS50Ran50Times.txt", 50);
		quickSort50TimeData("DataMiningInput\\ran1k.dat", "DataMiningOuput\\QS50Ran1kTimes.txt", 1000);
		quickSort50TimeData("DataMiningInput\\ran2k.dat", "DataMiningOuput\\QS50Ran2kTimes.txt", 2000);
		quickSort50TimeData("DataMiningInput\\ran5k.dat", "DataMiningOuput\\QS50Ran5kTimes.txt", 5000);
		quickSort50TimeData("DataMiningInput\\ran10k.dat", "DataMiningOuput\\QS50Ran10kTimes.txt", 10000);
		
		quickSort50TimeData("DataMiningInput\\rev50.dat", "DataMiningOuput\\QS50Rev50Times.txt", 50);
		quickSort50TimeData("DataMiningInput\\rev1k.dat", "DataMiningOuput\\QS50Rev1kTimes.txt", 1000);
		quickSort50TimeData("DataMiningInput\\rev2k.dat", "DataMiningOuput\\QS50Rev2kTimes.txt", 2000);
		quickSort50TimeData("DataMiningInput\\rev5k.dat", "DataMiningOuput\\QS50Rev5kTimes.txt", 5000);
		quickSort50TimeData("DataMiningInput\\rev10k.dat", "DataMiningOuput\\QS50Rev10kTimes.txt", 10000);
		
		// QuickSort 100 Cutoff
		quickSort100TimeData("DataMiningInput\\asc50.dat", "DataMiningOuput\\QS100Asc50Times.txt", 50);
		quickSort100TimeData("DataMiningInput\\asc1k.dat", "DataMiningOuput\\QS100Asc1kTimes.txt", 1000);
		quickSort100TimeData("DataMiningInput\\asc2k.dat", "DataMiningOuput\\QS100Asc2kTimes.txt", 2000);
		quickSort100TimeData("DataMiningInput\\asc5k.dat", "DataMiningOuput\\QS100Asc5kTimes.txt", 5000);
		quickSort100TimeData("DataMiningInput\\asc10k.dat", "DataMiningOuput\\QS100Asc10kTimes.txt", 10000);
		
		quickSort100TimeData("DataMiningInput\\ran50.dat", "DataMiningOuput\\QS100Ran50Times.txt", 50);
		quickSort100TimeData("DataMiningInput\\ran1k.dat", "DataMiningOuput\\QS100Ran1kTimes.txt", 1000);
		quickSort100TimeData("DataMiningInput\\ran2k.dat", "DataMiningOuput\\QS100Ran2kTimes.txt", 2000);
		quickSort100TimeData("DataMiningInput\\ran5k.dat", "DataMiningOuput\\QS100Ran5kTimes.txt", 5000);
		quickSort100TimeData("DataMiningInput\\ran10k.dat", "DataMiningOuput\\QS100Ran10kTimes.txt", 10000);
		
		quickSort100TimeData("DataMiningInput\\rev50.dat", "DataMiningOuput\\QS100Rev50Times.txt", 50);
		quickSort100TimeData("DataMiningInput\\rev1k.dat", "DataMiningOuput\\QS100Rev1kTimes.txt", 1000);
		quickSort100TimeData("DataMiningInput\\rev2k.dat", "DataMiningOuput\\QS100Rev2kTimes.txt", 2000);
		quickSort100TimeData("DataMiningInput\\rev5k.dat", "DataMiningOuput\\QS100Rev5kTimes.txt", 5000);
		quickSort100TimeData("DataMiningInput\\rev10k.dat", "DataMiningOuput\\QS100Rev10kTimes.txt", 10000);
		
		// QuickSort Median of 3
		quickSortMed3TimeData("DataMiningInput\\asc50.dat", "DataMiningOuput\\QSMed3Asc50Times.txt", 50);
		quickSortMed3TimeData("DataMiningInput\\asc1k.dat", "DataMiningOuput\\QSMed3Asc1kTimes.txt", 1000);
		quickSortMed3TimeData("DataMiningInput\\asc2k.dat", "DataMiningOuput\\QSMed3Asc2kTimes.txt", 2000);
		quickSortMed3TimeData("DataMiningInput\\asc5k.dat", "DataMiningOuput\\QSMed3Asc5kTimes.txt", 5000);
		quickSortMed3TimeData("DataMiningInput\\asc10k.dat", "DataMiningOuput\\QSMed3Asc10kTimes.txt", 10000);
		
		quickSortMed3TimeData("DataMiningInput\\ran50.dat", "DataMiningOuput\\QSMed3Ran50Times.txt", 50);
		quickSortMed3TimeData("DataMiningInput\\ran1k.dat", "DataMiningOuput\\QSMed3Ran1kTimes.txt", 1000);
		quickSortMed3TimeData("DataMiningInput\\ran2k.dat", "DataMiningOuput\\QSMed3Ran2kTimes.txt", 2000);
		quickSortMed3TimeData("DataMiningInput\\ran5k.dat", "DataMiningOuput\\QSMed3Ran5kTimes.txt", 5000);
		quickSortMed3TimeData("DataMiningInput\\ran10k.dat", "DataMiningOuput\\QSMed3Ran10kTimes.txt", 10000);
		
		quickSortMed3TimeData("DataMiningInput\\rev50.dat", "DataMiningOuput\\QSMed3Rev50Times.txt", 50);
		quickSortMed3TimeData("DataMiningInput\\rev1k.dat", "DataMiningOuput\\QSMed3Rev1kTimes.txt", 1000);
		quickSortMed3TimeData("DataMiningInput\\rev2k.dat", "DataMiningOuput\\QSMed3Rev2kTimes.txt", 2000);
		quickSortMed3TimeData("DataMiningInput\\rev5k.dat", "DataMiningOuput\\QSMed3Rev5kTimes.txt", 5000);
		quickSortMed3TimeData("DataMiningInput\\rev10k.dat", "DataMiningOuput\\QSMed3Rev10kTimes.txt", 10000);
		
		// MergeSort
		mergeSortTimeData("DataMiningInput\\asc50.dat", "DataMiningOuput\\MSAsc50Times.txt", 50);
		mergeSortTimeData("DataMiningInput\\asc1k.dat", "DataMiningOuput\\MSAsc1kTimes.txt", 1000);
		mergeSortTimeData("DataMiningInput\\asc2k.dat", "DataMiningOuput\\MSAsc2kTimes.txt", 2000);
		mergeSortTimeData("DataMiningInput\\asc5k.dat", "DataMiningOuput\\MSAsc5kTimes.txt", 5000);
		mergeSortTimeData("DataMiningInput\\asc10k.dat", "DataMiningOuput\\MSAsc10kTimes.txt", 10000);
		
		mergeSortTimeData("DataMiningInput\\ran50.dat", "DataMiningOuput\\MSRan50Times.txt", 50);
		mergeSortTimeData("DataMiningInput\\ran1k.dat", "DataMiningOuput\\MSRan1kTimes.txt", 1000);
		mergeSortTimeData("DataMiningInput\\ran2k.dat", "DataMiningOuput\\MSRan2kTimes.txt", 2000);
		mergeSortTimeData("DataMiningInput\\ran5k.dat", "DataMiningOuput\\MSRan5kTimes.txt", 5000);
		mergeSortTimeData("DataMiningInput\\ran10k.dat", "DataMiningOuput\\MSRan10kTimes.txt", 10000);
		
		mergeSortTimeData("DataMiningInput\\rev50.dat", "DataMiningOuput\\MSRev50Times.txt", 50);
		mergeSortTimeData("DataMiningInput\\rev1k.dat", "DataMiningOuput\\MSRev1kTimes.txt", 1000);
		mergeSortTimeData("DataMiningInput\\rev2k.dat", "DataMiningOuput\\MSRev2kTimes.txt", 2000);
		mergeSortTimeData("DataMiningInput\\rev5k.dat", "DataMiningOuput\\MSRev5kTimes.txt", 5000);
		mergeSortTimeData("DataMiningInput\\rev10k.dat", "DataMiningOuput\\MSRev10kTimes.txt", 10000);

		System.out.println("Program Completed.");
	}

	/**
	 * Method that runs 50 QuickSorts and saves the time data
	 * 
	 * @param inputFileName
	 *            Input data for sorting
	 * @param outputFileName
	 *            Output file for saving the time data
	 * @param size
	 *            Number of elements to sort
	 */
	public static void quickSortTimeData(String inputFileName, String outputFileName, int size) {
		long[] arr = new long[50];
		ReadFile quickSortInputFile = new ReadFile(inputFileName);
		WriteFile quickSortOutputFile = new WriteFile(outputFileName);

		for (int i = 0; i < arr.length; i++) {
			ListParser listParser1 = new ListParser(quickSortInputFile);
			int[] qSArr = null;
			qSArr = listParser1.parseToArray(size);
			QuickSort.quickSort(qSArr);
			arr[i] = QuickSort.getTotalRunTime();
		}

		SortLog qSSortLog = new SortLog(arr, quickSortOutputFile);
		try {
			qSSortLog.writeTimes();
		} catch (IOException e) {
			System.out.println("Output file path is incorrect.");
			e.printStackTrace();
		}

		quickSortOutputFile.closeFile();
		System.out.println("QuickSort Times Recorded.");
	}

	/**
	 * Method that runs 50 QuickSorts with the 50 element cutoff and saves the
	 * time data
	 * 
	 * @param inputFileName
	 *            Input data for sorting
	 * @param outputFileName
	 *            Output file for saving the time data
	 * @param size
	 *            Number of elements to sort
	 */

	public static void quickSort50TimeData(String inputFileName, String outputFileName, int size) {
		long[] arr = new long[50];
		ReadFile quickSortInputFile = new ReadFile(inputFileName);
		WriteFile quickSortOutputFile = new WriteFile(outputFileName);

		for (int i = 0; i < arr.length; i++) {
			ListParser listParser1 = new ListParser(quickSortInputFile);
			int[] qSArr = null;
			qSArr = listParser1.parseToArray(size);
			QuickSort.quickSort50(qSArr);
			arr[i] = QuickSort.getTotalRunTime();
		}

		SortLog qSSortLog = new SortLog(arr, quickSortOutputFile);
		try {
			qSSortLog.writeTimes();
		} catch (IOException e) {
			System.out.println("Output file path is incorrect.");
			e.printStackTrace();
		}

		quickSortOutputFile.closeFile();
		System.out.println("QuickSort50 Times Recorded.");
	}

	/**
	 * Method that runs 50 QuickSorts with the 100 element cutoff and saves
	 * the time data
	 * 
	 * @param inputFileName
	 *            Input data for sorting
	 * @param outputFileName
	 *            Output file for saving the time data
	 * @param size
	 *            Number of elements to sort
	 */
	public static void quickSort100TimeData(String inputFileName, String outputFileName, int size) {
		long[] arr = new long[50];
		ReadFile quickSortInputFile = new ReadFile(inputFileName);
		WriteFile quickSortOutputFile = new WriteFile(outputFileName);

		for (int i = 0; i < arr.length; i++) {
			ListParser listParser1 = new ListParser(quickSortInputFile);
			int[] qSArr = null;
			qSArr = listParser1.parseToArray(size);
			QuickSort.quickSort100(qSArr);
			arr[i] = QuickSort.getTotalRunTime();
		}

		SortLog qSSortLog = new SortLog(arr, quickSortOutputFile);
		try {
			qSSortLog.writeTimes();
		} catch (IOException e) {
			System.out.println("Output file path is incorrect.");
			e.printStackTrace();
		}

		quickSortOutputFile.closeFile();
		System.out.println("QuickSort100 Times Recorded.");
	}

	/**
	 * Method that runs 50 QuickSorts with the median of 3 cutoff and saves
	 * the time data
	 * 
	 * @param inputFileName
	 *            Input data for sorting
	 * @param outputFileName
	 *            Output file for saving the time data
	 * @param size
	 *            Number of elements to sort
	 */
	public static void quickSortMed3TimeData(String inputFileName, String outputFileName, int size) {
		long[] arr = new long[50];
		ReadFile quickSortInputFile = new ReadFile(inputFileName);
		WriteFile quickSortOutputFile = new WriteFile(outputFileName);

		for (int i = 0; i < arr.length; i++) {
			ListParser listParser1 = new ListParser(quickSortInputFile);
			int[] qSArr = null;
			qSArr = listParser1.parseToArray(size);
			QuickSort.quickSortMed3(qSArr);
			arr[i] = QuickSort.getTotalRunTime();
		}

		SortLog qSSortLog = new SortLog(arr, quickSortOutputFile);
		try {
			qSSortLog.writeTimes();
		} catch (IOException e) {
			System.out.println("Output file path is incorrect.");
			e.printStackTrace();
		}

		quickSortOutputFile.closeFile();
		System.out.println("QuickSortMed3 Times Recorded.");
	}

	/**
	 * Method that runs 50 MergeSorts and saves the time data
	 * 
	 * @param inputFileName
	 *            Input data for sorting
	 * @param outputFileName
	 *            Output file for saving the time data
	 * @param size
	 *            Number of elements to sort
	 */
	public static void mergeSortTimeData(String inputFileName, String outputFileName, int size) {
		long[] arr = new long[50];
		ReadFile mergeSortInputFile = new ReadFile(inputFileName);
		WriteFile mergeSortOutputFile = new WriteFile(outputFileName);

		for (int i = 0; i < arr.length; i++) {
			ListParser listParser1 = new ListParser(mergeSortInputFile);
			LinkedList<Integer> msLinkedList = listParser1.parseToLinkedList(size);
			MergeSort.naturalMergeSort(msLinkedList);
			arr[i] = MergeSort.getTotalRunTime();
		}

		SortLog mSSortLog = new SortLog(arr, mergeSortOutputFile);
		try {
			mSSortLog.writeTimes();
		} catch (IOException e) {
			System.out.println("Output file path is incorrect.");
			e.printStackTrace();
		}

		mergeSortOutputFile.closeFile();
		System.out.println("Natrual MergeSort Times Recorded.");
	}

}
