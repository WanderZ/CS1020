import java.util.*;

/* Quick sort is also a Devide-and-Counqer algorithm the same as Merge Sort*/
/* Merge Sort spends most of time on the Conquer Step and little time of Divide Step. */

/* In Quick Sort, after the partition, the pivot is moved to its FINAL POSTION. Therefore no merge is needed. */
/* Time complexity of Quick Sort is: 
 * Worst Case: a[] is in DEACREASING/DECREASING order O(n^2);
 * Best Case: When pivot exactly split tha array into equal half O(n log N).
 * Average Time Complexity: O(n log N).
 */
class QuickSort2 {

	// precond: a[] is not empty
	// precond: i < j
	public static void quickSort (int[] a, int i, int j) {
		if (i < j) { // base case
			int pivot = partition (a, i, j); 
			quickSort(a, i, pivot - 1);
			quickSort(a, pivot + 1, j);
			// No Merge is required
		}
	}

	// precond: a[] is not empty
	// precond: i < j
	// postcond: an integer 'pivot' is returned
	private static int partition (int[] a, int i, int j) {
		int pivot = a[i]; // take the pivot as the first element in array
		int m = i; // S1 and S2 are both empty

		for (int k = i + 1; k <= j; k ++) { // increment of k implies imcrement of S2 region
			if (a[k] < pivot) {
				m ++;
				swap(a, m, k);
			}
		}

		// after partition, pivot is swap to its proper position
		// S1-piviot-S2 || pivot = a[i];
		swap(a, i, m);
		return m;
	}

	// precond: a[] is not empty
	// precond: i, j are positive integers
	// postcond: a[i] and a[j] are exchanged
	private static void swap (int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// precond: a[] is not empty
	private static void print (int[] a) {
		System.out.print("[ ");
		for (int e: a)
			System.out.print (e + " ");

		System.out.println("]");
	}

	public static void main (String args[]) {
		int[] a = {9, 4, 6, 1, 5, 3, 0, 2, 8, 7 };

		print(a);
		quickSort(a, 0, a.length - 1);
		print(a);
	}
}
