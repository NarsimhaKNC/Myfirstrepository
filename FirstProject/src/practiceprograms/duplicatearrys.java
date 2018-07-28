package practiceprograms;

import java.util.Arrays;
import java.util.Collections;

public class duplicatearrys {
	// public static void main(String[] args) {
	public static int removeDuplicateElements(int arr[], int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[] temp = new int[n];
		int j = 0;
		for (int i = 0; i < n - 1; i++) {
			for (j = 0; j < n - 1; j++)
			{
				if (arr[i] != arr[i + 1]) {
					temp[j++] = arr[i];
					temp[i] = arr[j];

				}
		}
		temp[j++] = arr[n - 1];
		// Changing original array
		for (i = 0; i < j; i++) {
			arr[i] = temp[i];
		}
		return j;
	}
		return j;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 4, 6, 20, 10, 4, };
		Arrays.sort(arr);

		int length = arr.length;

		length = removeDuplicateElements(arr, length);
		// printing array elements
		for (int i = 0; i < length; i++)
			System.out.print(arr[i] + " ");
	}

	/*
	 * int arr[]={10,20,4,6,20,55,4,73,10}; int origin=arr[0]; int dupli=arr[0];
	 * int n=0; System.out.println("given array is:");{ for(int
	 * i=0;i<arr.length;i++){ System.out.println(arr[i] + "\t");{ if(origin==0
	 * || arr[n]==1){ origin=arr[n]; System.out.println("print the original");
	 * }else if(origin!=dupli){ arr[n]=dupli; System.out.println();
	 */

}
