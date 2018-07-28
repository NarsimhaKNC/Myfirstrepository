package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class testng2 {
	public class TC2{
		@Test(groups={"part1"})
		void login(){
			System.out.println("login details plz");
		}
		@Test(groups={"part2,part1"})
		void password(){
			System.out.println("password details");
		}
		@Test(groups={"part2"})
		void wrongdetails(){
			System.out.println("return to login button");}
		@Test(groups={"part1"})
		void homepage(){
			System.out.println("home page");
			Reporter.log("testing ");
		
		}
	}

}
