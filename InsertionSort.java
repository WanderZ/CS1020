import java.util.*;

public class InsertionSort {

	// precond: a[] is not empty
	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i ++) {
			int next = a[i];
			int j;
			for (j=i-1; j>=0 && a[j]>next; j--) // here we can't replace 'next' with a[i]
				a[j+1] = a[j];

			a[j+1] = next;// 'next' cant be replaced with a[i]
		}
	}
	
	// print out the array
	// precond: a[] is not empty
	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 7, 12, 3, 5, -6, 3, 8, 2, 10, -3 };

		printArray(arr);
		insertionSort(arr);
		printArray(arr);
	}
}

