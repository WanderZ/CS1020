import java.util.*;

class Merge {
	public static void main(String[] args){

		int[] a = {3, 4, 1, 5, 2, 7, 6, 9, 0, 8};

		print(a);
		mergeSort(a, 0, a.length - 1);
		print(a);
	}

	// print out the array in [ 1, 2, 3, ... n ] format
	private static void print(int[] a) {
		System.out.print("[ ");

		for(int e: a)
			System.out.print(e + " ");

		System.out.println("]");
	}

	// merge sort an array from position i to position j
	// precon: the array is not empty
	// precon: i < j
	// postcon: a[i] to a[j] is sorted
	private static void mergeSort (int[] a, int i, int j) {
		int mid = (i + j) / 2;
		if (i < j) { // base case is when i and j is splited into the same
			mergeSort(a, i, mid); // recursive step I
			mergeSort(a, mid + 1, j); // recursive step II
			merge(a, i, mid, j); // conquer step
		}
	}
	
	/*
	 * Merge() method is doing bulk of operations.
	 * Overal time complexity is O(n) * O(log n) = O(nlogN)
	 */
	// combine two sorted subarray into one whole
	// precon: a[] is not empty
	// precon: i < j, and mid = (i + j) / 2
	private static void merge (int[] a, int i, int mid, int j) {
		int[] temp = new int[j - i + 1];
		int left = i, right = mid + 1, next = 0;

		while (left <= mid && right <= j) {
			if (a[left] <= a[right]) 
				temp[next ++] = a[left ++];
			else
				temp[next ++] = a[right ++];
		}

		// only one 'while' command will be executed
		while (left <= mid) 
			temp[next ++] = a[left ++];
		while (right <= j) 
			temp[next ++] = a[right ++];

		for (int k = 0; k < temp.length; k ++) 
			a[i + k] = temp[k];
	}
}
