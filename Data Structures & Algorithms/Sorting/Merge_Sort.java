package Sorting;

import java.util.*;

public class Merge_Sort {
	public static int[] merge_sort (int[] array, int p, int r) {
		/*
		 * fill in your program
		 */
		int q;
		if(p < r) {
			q = (p+r)/2;
			merge_sort(array,p,q);
			merge_sort(array,q+1,r);
			merge(array,p,q,r);
			
		}
				
		return array;
	}
	
	public static int[] merge (int[] array, int p, int q, int r) {
		/*
		 * fill in your program
		 */
		int start1 = q - p + 1;
		int start2 = r - q;
		int[] left = new int[start1 + 1];
		int[] right = new int[start2 + 1];
		
		int i;
		int j;
		
		for(i = 1; i <= start1; i++) {
			left[i] = array[p + i - 1];
		}
		for(j = 1; j <= start2; j++) {
			right[j] = array[q + j];
		}
		
		left[start1] = Integer.MAX_VALUE;
		right[start2] = Integer.MAX_VALUE;

		i = 0;
		j = 0;
		
		for(int k = p;k <= r; k++) {
			if(left[i] <= right[j]) {
				array[k] = left[i];
				i++;
			}
			else {
				array[k] = right[j];
				j++;
			}
		}
		
		
		return array;
	}
	
	/*
	 * n: the size of the output array
	 * k: the maximum value in the array
	 */
	public static int[] generate_random_array (int n, int k) {
		List<Integer> list;
		int[] array;
		Random rnd;
		
		rnd = new Random(System.currentTimeMillis());
		
		list = new ArrayList<Integer> ();
		for (int i = 1; i <= n; i++) 
			list.add(new Integer(rnd.nextInt(k+1)));
		
		Collections.shuffle(list, rnd);
		
		array = new int[n];
		for (int i = 0; i < n; i++) 
			array[i] = list.get(i).intValue();
		
		return array;
	}
	
	/*
	 * n: the size of the output array
	 */
	public static int[] generate_random_array (int n) {
		List<Integer> list;
		int[] array;
		
		list = new ArrayList<Integer> ();
		for (int i = 1; i <= n; i++) 
			list.add(new Integer(i));
		
		Collections.shuffle(list, new Random(System.currentTimeMillis()));
		
		array = new int[n];
		for (int i = 0; i < n; i++) 
			array[i] = list.get(i).intValue();
		
		return array;
	}
	
	/*
	 * Input: an integer array
	 * Output: true if the array is acsendingly sorted, otherwise return false
	 */
	public static boolean check_sorted (int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i-1] > array[i])
				return false;
		}
		return true;
	}
	
	public static void print_array (int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + ", ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Merge sort starts ------------------");
		for (int n = 10000; n <= 100000; n=n+10000) {
			int[] array = Merge_Sort.generate_random_array(n);
			//Sort.print_array(array);
			long t1 = System.currentTimeMillis();
			array = Merge_Sort.merge_sort(array, 0, n-1);
			long t2 = System.currentTimeMillis();
			long t = t2 - t1;
			//Sort.print_array(array);
			boolean flag = Merge_Sort.check_sorted(array);
			System.out.println(n + "," + t + "," + flag);
		}
		System.out.println("Merge sort ends ------------------");
	}

}
