import java.util.*;

class BubbleSort {
	public static void main(String[] args){
		int[] a = {7, 3, 6, 8, 2, 79, 35, 3365};

		print(a);
		sort(a);
		print(a);

		System.out.println("Time Complexity of Bubble Sort is: O(n^2)");
	}
	
	// print out the array
	private static void print(int[] a) {
		System.out.print("[ ");

		for (int e : a)
			System.out.print(e + " ");

		System.out.println("]");
	}
	
	// precond: a[] is not empty
	// postcond: a[] is sorted
	// description: sort() method sorts an array into non-descending direction
	private static void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i ++) {
			boolean done = true;
		
				for (int j = i + 1; j < a.length; j ++) {
					if (a[i] > a[j]) {
						int temp = a[i]; // swap
						a[i] = a[j];
						a[j] = temp;
						done = false;
					}
				}
		  if (done) return;
		}
	}
}
