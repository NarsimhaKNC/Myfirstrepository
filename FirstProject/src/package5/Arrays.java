package package5;

import java.util.Scanner;

public class Arrays {
	public static void main(String[] args){
	int arr[]={1,2,5,3,7,5,8,9};
	int marks[]=new int[7];
	Scanner sc=new Scanner(System.in);
	int marksarraysize=marks.length;
	for(int i=0;i<marksarraysize;i++){
		marks[i]=sc.nextInt();
	}
	for(int i=0;i<marksarraysize;i++){
		System.out.println("marks for sub" +i+ "is" +marks[i]);
	
	/*int arrsize=arr.length;
	System.out.println("size of the array is"+arrsize);
	for(int i=0;i<arrsize;i++){
		System.out.println("value of the index"+i+"is:"+arr[i]);*/
		for(Integer A:arr){
			System.out.println(A);
	}
	
	}
}
}
	
