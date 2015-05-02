/* Radix Sort Algorithms - non-comparison sort*/
import java.util.*;

class RadixSort {
  public static void main (String args[]) {
    RadixSort rs = new RadixSort();
    int[] a = {123, 2154, 222, 4, 283, 1560, 1061, 2150};
    
    rs.print(a);
    rs.sort(a);
    rs.print(a);
  }

  // precond: a[] is not empty
  private void print (int[] a) {
  	System.out.print("[ ");

  	for (int e: a)
  		System.out.print (e + " ");

  	System.out.println ("]");
  }

  // description: sort() mehtod sorts n d-digit numeirc strings in array a[]
  // precond: a[] is not empty
  // precond: n, d is positive integer
  // postcond: a[] is sorted
  // @overriding method
  private void sort (int[] a) {	sort (a, 8, 4); }  // 8 4-digit numerics

  private void sort (int[] a, int n, int d) {
  	for (int j = d; j > 0; j --) {

  		// initialize 10 queues to store the groups with the same j-th digit
  		// 10 groups because there are 10 digits (0, 1, 2, ..., 9)
  		/*
  		Queue<Integer> q0 = new LinkedList<Integer>();
  		Queue<Integer> q1 = new LinkedList<Integer>();
  		Queue<Integer> q2 = new LinkedList<Integer>();
  		Queue<Integer> q3 = new LinkedList<Integer>();
  		Queue<Integer> q4 = new LinkedList<Integer>();
  		Queue<Integer> q5 = new LinkedList<Integer>();
  		Queue<Integer> q6 = new LinkedList<Integer>();
  		Queue<Integer> q7 = new LinkedList<Integer>();
  		Queue<Integer> q8 = new LinkedList<Integer>();
  		Queue<Integer> q9 = new LinkedList<Integer>();

  		Queue[] q = {q0, q1, q2, q3, q4, q5, q6, q7, q8, q9}; 
  		// Queue<Integer> q = {q0, q1, q2, q3, q4, q5, q6, q7, q8, q9}; // Error!!
  		*/
  	  Queue<Integer>[] p = new LinkedList[10];
  	  for (int i = 0; i < 10; i ++) {
  	    p[i] = new LinkedList<Integer>();
  	  }

  		// place a[i] at the end of group k
  		for (int i = 0; i < n; i ++) {
  			int k = getDigit(a[i], j, d);
  			q[k].offer(a[i]); // q[k].add(a[i]);
  		}

  		// replace a[] with all items in queues
  		int position = 0; 
  		for (int i = 0; i < 10; i ++) {
  			while (q[i].peek() != null) {
  				a[position ++] = (int) q[i].poll(); // int = (int) Integer
  			}
  		}
  	} 
  }
  
  // precond: j is a positive integer
  // precond: String s is a stirng a numeric number
  // description: j is the j-th digit to be found, while d is the whole digits a number has
  // postcond: the j-th digit is returned
  private int getDigit (Integer s, int j, int d) {
  	int num = (int) s;
  	int digit = 0; 

  	for (int temp = 0; temp < d - j + 1; temp ++) {
  		digit = num % 10; 
  		num /= 10;
  	}
  	return digit;
  }
}
