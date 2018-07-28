package package4;
import java.io.*;
import java.util.*;

/*public class factorialnum {
	public static void main(String args[]) {
		int n = 10;
		int fact = 1;

		for (int i = 1; i <= n; i++) {

			fact = fact * i;
		}

		System.out.println("factoral=" + fact);
	}
}*/

public class factorialnum 
{
    static Scanner sc=new Scanner(System.in);

    public static void main(String args[])
    {
        long n=sc.nextLong(),prod=1;
        for(long i=1;i<=n;i++)
        {
            prod=prod*i;
        }
        System.out.println(prod);
    }
}
