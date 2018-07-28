package package1;

import java.util.Scanner;

public class Day1 {
	public static boolean isprime(int n){
		int counter=0;
   for(int i=1;i<=n;i++){
	   
	   if(n%i==0){
		   counter=counter+1;
		   
	   }
	   
   }
   if(counter==2){
	   return true;
   }
   return false;
  
	}
	
	public static void main(String[] args) {
		/*
		 * int stuclass=3; if(stuclass==1 || stuclass==2 || stuclass==3 ||
		 * stuclass==4 || stuclass==5){ System.out.println("primary school");
		 */

		Scanner s = new Scanner(System.in);
		int name = s.nextInt();
		System.out.println(name);
		for(int i=1;i<=name;i++){
			if(isprime(i)){
				System.out.print(i + " ");
			}
			
		}
	}
}
