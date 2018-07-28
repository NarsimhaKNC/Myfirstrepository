package package2;

import java.util.Scanner;
public class Loops {
   public static void main(String[] args){
	   
	   Scanner s = new Scanner(System.in);
	   int a= s.nextInt();{
	      System.out.println("a is :"+a);
	   //if(a%5==0){
		  // System.out.println(a+"; is divisible by 5");
		   //System.out.println("print only if conition is true");
	   //}else if(a>0){
		   //System.out.println("result will be one");
	   
	   if(a>0 && a%5==0){
		   if(a%5==0){
		   System.out.println(a+": positive and is divisible by 5");
		   System.out.println("print only condition is true");
	   }else if(a>0){
		   System.out.println(a+": is positiove and is not divisible by 5");
		   System.out.println("print only condition is false");
	   }else{
		   System.out.println(a+"is not positve");
		   
		   
		   
	   }
	   
   }
	   }
   }
}
